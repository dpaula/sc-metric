package com.dpaula.scmetric.domain.repository;


import com.dpaula.scmetric.domain.model.AppMetricEvent;
import com.dpaula.scmetric.domain.model.HealthCheckConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

public interface AppMetricEventRepository extends JpaRepository<AppMetricEvent, UUID> {
    Optional<AppMetricEvent> findFirstByCreatedAtBeforeAndCheckTypeAndIdNotOrderByCreatedAtDesc(OffsetDateTime createdAt,
                                                                                HealthCheckConfig.CheckType type,
                                                                                UUID id);
}
