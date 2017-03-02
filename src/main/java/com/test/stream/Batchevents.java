package com.test.stream;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.task.batch.listener.support.JobExecutionEvent;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by shahbour on 2/28/17.
 */
@EnableBinding(Sink.class)
public class Batchevents {


    @Autowired
    JobExplorer jobExplorer;

    @StreamListener(Sink.INPUT)
    public void handle(JobExecutionEvent jobExecutionEvent) throws IOException {
        //if(jobExecutionEvent.getStatus().name().equals("COMPLETED")) {
        JobExecution jobExecution = jobExplorer.getJobExecution(jobExecutionEvent.getId());
        if(jobExecution != null) {
            ExecutionContext executionContext = jobExecution.getExecutionContext();
        }
    }
}
