package com.dpaula.scmetric.api.model;

import lombok.Data;

import java.util.UUID;

@Data
public class AppModel {
    private UUID id;
    private String name;
    private String address;
}
