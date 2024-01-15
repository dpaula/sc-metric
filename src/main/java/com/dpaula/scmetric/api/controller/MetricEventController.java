package com.dpaula.scmetric.api.controller;

import com.dpaula.scmetric.api.model.AppMetricEventModel;
import com.dpaula.scmetric.core.Mapper;
import com.dpaula.scmetric.domain.repository.AppMetricEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/metrics/events")
@RequiredArgsConstructor
public class MetricEventController {
    private final AppMetricEventRepository results;
    private final Mapper mapper;

    @GetMapping
    public List<AppMetricEventModel> findAll() {
        return results.findAll()
                .stream()
                .map(metric -> mapper.map(metric, AppMetricEventModel.class))
                .toList();
    }
}
