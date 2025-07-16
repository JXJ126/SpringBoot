package com.sw.service.testDataGenerators.domain.entity;


import com.sw.service.domain.entity.Labor;

public class LaborGenerator {
    public static Labor getValidLabor() {
        return Labor.builder()
                .id(1)
                .length(10.0)
                .width(10.0)
                .ppu(2.0)
                .cost(200.0)
                .build();
    }

    public static Labor getInvalidLabor() {
        return Labor.builder()
                .id(2)
                .length(0.0)
                .width(0.0)
                .ppu(0.0)
                .cost(00.0)
                .build();
    }
}
