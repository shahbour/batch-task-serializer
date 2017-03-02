package com.test.controller;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.batch.listener.support.JobExecutionEvent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shahbour on 2/28/17.
 */
@RestController
public class DefaultController {

    @Autowired
    JobExplorer jobExplorer;


    @RequestMapping("/execution/{executionId}")
    public JobExecutionEvent restart(@PathVariable("executionId")long executionId) {
        JobExecution jobExecution = jobExplorer.getJobExecution(executionId);
        ExecutionContext executionContext = jobExecution.getExecutionContext();
        return new JobExecutionEvent(jobExecution);
    }

}
