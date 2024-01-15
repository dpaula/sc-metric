package com.dpaula.scmetric.api.model;

import com.dpaula.scmetric.domain.model.HealthCheckConfig;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class HealthCheckConfigModel {
    @NotNull
    private HealthCheckConfig.CheckType type;
    @NotNull
    private Integer timeout;

    public HealthCheckConfig toDomain() {
        return HealthCheckConfig.builder()
                .type(this.getType())
                .timeout(this.getTimeout())
                .build();
    }
}
