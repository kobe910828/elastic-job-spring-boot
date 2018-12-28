package com.elastic.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.elastic.model.Foo;
import com.elastic.repository.FooRepository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/12/27 21:56
 */
public class MyDataflowJob implements DataflowJob<Foo>{
    @Resource
    private FooRepository fooRepository;

    @Override
    public List<Foo> fetchData(ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()),
                Thread.currentThread().getId(), "DATAFLOW FETCH"));
        List<Foo> list = fooRepository.findTodoData(shardingContext.getShardingParameter(), 3);
        for (Foo each : list) {
            System.out.println(each);
        }
        return list;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<Foo> data) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()),
                Thread.currentThread().getId(), "DATAFLOW PROCESS"));
        for (Foo each : data) {
            fooRepository.setCompleted(each.getId());
            System.out.println(each);
        }
    }
}
