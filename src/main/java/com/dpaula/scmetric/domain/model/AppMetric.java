package com.dpaula.scmetric.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.Validate;

import java.time.Duration;
import java.util.UUID;

@Entity
@Getter
@Builder
public class AppMetric {

    @Id
    private UUID id;

    @Builder.Default
    private String upTime = Duration.ofSeconds(0).toString();

    @Builder.Default
    private String downTime = Duration.ofSeconds(0).toString();

    @Column(unique = true, columnDefinition = "char(36)")
    private UUID appId;

    private HealthCheckConfig.CheckType checkType;

    protected AppMetric() {
        //For JPA/Hibernate
    }

    public AppMetric(UUID id, String upTime, String downTime, UUID appId,
                     HealthCheckConfig.CheckType checkType) {
        Validate.notNull(upTime);
        Validate.notNull(downTime);
        Validate.notNull(appId);
        Validate.notNull(checkType);
        this.id = id;
        this.appId = appId;
        this.checkType = checkType;
        this.upTime = upTime;
        this.downTime = downTime;
    }

    public static AppMetric of(HealthCheckTaskResult result) {
        return AppMetric.builder()
                .appId(result.getAppId())
                .checkType(result.getCheckConfig().getType())
                .build();
    }

    public void processResult(AppMetricEvent lastResult,
                              AppMetricEvent actualResult) {
        Validate.notNull(lastResult);
        Validate.notNull(actualResult);

        var duration = Duration.between(lastResult.getCreatedAt(), actualResult.getCreatedAt());

        if (lastResult.isUp()) {
            sumUpTime(duration);
        } else {
            sumDownTime(duration);
        }
    }

    private void sumUpTime(Duration duration) {
        this.upTime = Duration.parse(this.upTime).plus(duration).toString();
    }

    private void sumDownTime(Duration duration) {
        this.downTime = Duration.parse(this.downTime).plus(duration).toString();
    }
}
