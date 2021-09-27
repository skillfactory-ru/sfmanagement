package ru.skillfactory.sfmanagement.background;

import lombok.extern.slf4j.Slf4j;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class JobScheduleCreator {

    public JobDetail createJob(Class <? extends QuartzJobBean> jobClass, boolean isDurable,
                               ApplicationContext applicationContext, String jobName, String jobGroup) {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(jobClass);
        jobDetailFactoryBean.setDurability(isDurable);
        jobDetailFactoryBean.setApplicationContext(applicationContext);
        jobDetailFactoryBean.setName(jobName);
        jobDetailFactoryBean.setGroup(jobGroup);

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobName + jobGroup, jobClass.getName());
        jobDetailFactoryBean.setJobDataMap(jobDataMap);

        jobDetailFactoryBean.afterPropertiesSet();
        return jobDetailFactoryBean.getObject();
    }

    public CronTrigger cronTrigger(String triggerName, Date startDate, String cronExpression, int misFireInstruction) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setName(triggerName);
        factoryBean.setStartTime(startDate);
        factoryBean.setCronExpression(cronExpression);
        factoryBean.setMisfireInstruction(misFireInstruction);
        try {
            factoryBean.afterPropertiesSet();
        } catch (Exception e) {
            log.error("Не удалось создать триггер", e);
        }

        return factoryBean.getObject();
    }
}
