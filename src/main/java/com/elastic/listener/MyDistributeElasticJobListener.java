package com.elastic.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;

/**
 * @author xin.huang
 * @version v1.0
 * @date 2018/12/27 22:06
 */
public class MyDistributeElasticJobListener extends AbstractDistributeOnceElasticJobListener {

    public MyDistributeElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        System.out.println(shardingContexts.getJobName() + " | MyDistributeElasticJobListener doBeforeJobExecutedAtLastStarted...");
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        System.out.println(shardingContexts.getJobName() + " | MyDistributeElasticJobListener doAfterJobExecutedAtLastCompleted...");
    }
}
