package com.dpaula.scmetric.api.listener;

import com.dpaula.scmetric.api.model.HealthCheckTaskResultModel;
import com.dpaula.scmetric.domain.model.HealthCheckTaskResult;
import com.dpaula.scmetric.domain.service.MetricService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Fernando de Lima on 14/01/24
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class HealthCheckResultEventListener implements Consumer<HealthCheckTaskResultModel> {

    private final MetricService metricService;

    @Override
    public void accept(HealthCheckTaskResultModel model) {
        log.info("Processando metrica, id: {} ", model.getId());
        final var domain = model.toDomain();
        metricService.process(domain);

    }
}
