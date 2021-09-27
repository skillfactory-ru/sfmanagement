package ru.skillfactory.sfmanagement.config;

import org.quartz.simpl.SimpleJobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import ru.skillfactory.sfmanagement.background.SchedulerJobFactory;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class SchedulerConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private QuartzProperties quartzProperties;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerJobFactory schedulerJobFactory = new SchedulerJobFactory();
        schedulerJobFactory.setApplicationContext(applicationContext);

        Properties properties = new Properties();
        properties.putAll(quartzProperties.getProperties());

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setQuartzProperties(properties);
        schedulerFactoryBean.setJobFactory(schedulerJobFactory);
        return schedulerFactoryBean;
    }
}
