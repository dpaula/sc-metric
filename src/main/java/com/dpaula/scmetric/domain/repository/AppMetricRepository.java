package com.dpaula.scmetric.domain.repository;


import com.dpaula.scmetric.domain.model.AppMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppMetricRepository extends JpaRepository<AppMetric, UUID> {
    Optional<AppMetric> findOneByAppId(UUID appId);
}
