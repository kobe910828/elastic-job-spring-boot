package com.elastic.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/12/27 21:26
 */
public class MyElasticJobListener implements ElasticJobListener{
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        System.out.println(shardingContexts.getJobName() + " | MyElasticJobListener beforeJobExecuted");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        System.out.println(shardingContexts.getJobName() + " | MyElasticJobListener afterJobExecuted");
    }
}
