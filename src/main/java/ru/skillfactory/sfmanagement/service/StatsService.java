package ru.skillfactory.sfmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import ru.skillfactory.sfmanagement.background.JobScheduleCreator;
import ru.skillfactory.sfmanagement.background.StatsJob;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatsService {

    private final SchedulerFactoryBean schedulerFactoryBean;

    @Value("${app.stats.cron}")
    private String cronExpression;


    @PostConstruct
    public void startJob() {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            JobDetail statsJob = JobBuilder.newJob(StatsJob.class).withIdentity("statsJob", "statsJob").build();
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("statsJob", "statsJob")
                    .forJob(statsJob)
                    .withSchedule(
                            CronScheduleBuilder.cronSchedule(cronExpression)).build();
            scheduler.scheduleJob(statsJob, trigger);
        } catch (Exception e) {
            log.info("Произошла непредвиденная ошибка");
        }
    }
}
