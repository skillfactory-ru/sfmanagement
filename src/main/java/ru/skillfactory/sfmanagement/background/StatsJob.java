package ru.skillfactory.sfmanagement.background;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class StatsJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Шедулером запущена задача в фоне с именем {}", jobExecutionContext.getJobDetail().getKey().getName());
    }
}
