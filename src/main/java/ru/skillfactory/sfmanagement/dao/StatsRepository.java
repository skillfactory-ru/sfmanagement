package ru.skillfactory.sfmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillfactory.sfmanagement.domain.Stats;

import java.time.LocalDate;
import java.util.Optional;

public interface StatsRepository extends JpaRepository<Stats, Long> {

    Optional<Stats> findByDay(LocalDate date);
}
