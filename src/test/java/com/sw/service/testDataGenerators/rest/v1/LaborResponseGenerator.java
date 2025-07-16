package com.sw.service.testDataGenerators.rest.v1;

import com.sw.service.rest.v1.LaborResponseResource;

public class LaborResponseGenerator {
    public static LaborResponseResource getLaborResponse() {
        return LaborResponseResource.builder()
                .id(1)
                .totalCost(200.0)
                .build();
    }
}
