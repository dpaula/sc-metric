package com.dpaula.scmetric.domain.model;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.Validate;

@Getter
@Builder
@Embeddable
public class HealthCheckConfig {
    private CheckType type;
    private Integer timeout;

    protected HealthCheckConfig() {

    }

    public HealthCheckConfig(CheckType type, Integer timeout) {
        Validate.notNull(type);
        Validate.notNull(timeout);
        this.type = type;
        this.timeout = timeout;
    }

    public enum CheckType {
        HTTP,
        PING;
    }
}
