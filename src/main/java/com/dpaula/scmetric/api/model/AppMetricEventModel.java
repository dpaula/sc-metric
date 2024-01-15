package com.dpaula.scmetric.api.model;

import com.dpaula.scmetric.domain.model.HealthCheckConfig;
import com.dpaula.scmetric.domain.model.HealthCheckTaskResult;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class AppMetricEventModel {
    private UUID id;
    private UUID scheduleId;
    private UUID appId;
    private OffsetDateTime createdAt;
    private HealthCheckConfig.CheckType checkType;
    private HealthCheckTaskResult.Status resultStatus;
}
