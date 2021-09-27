package ru.skillfactory.sfmanagement.background;

import org.quartz.SchedulerException;
import org.quartz.spi.InstanceIdGenerator;

import java.util.UUID;

public class CustomQuartzInstanceGenerator implements InstanceIdGenerator {

    @Override
    public String generateInstanceId() throws SchedulerException {
        try {
            return UUID.randomUUID().toString();
        } catch (Exception e) {
            throw new SchedulerException("Не удалось сгенерировать идентификатор");
        }
    }
}
