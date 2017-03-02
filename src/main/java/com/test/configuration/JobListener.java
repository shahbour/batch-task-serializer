package com.test.configuration;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shahbour on 2/28/17.
 */
@Component("jobListener")
public class JobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        Map<String,String> map = new HashMap<>();
        map.put("test","test");

        jobExecution.getExecutionContext().put("key1","value1");
        jobExecution.getExecutionContext().put("key2",map);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

    }
}
