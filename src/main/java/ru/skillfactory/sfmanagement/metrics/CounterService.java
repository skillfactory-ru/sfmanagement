package ru.skillfactory.sfmanagement.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    public void increaseCount(String tag, String date, String value) {
        Counter counter = Metrics.counter(tag, "date", date, "value", value);
        counter.increment();
    }
}
