package com.sw.service.testDataGenerators.rest.v1;

import com.sw.service.rest.v1.LaborRequestResource;

public class LaborRequestGenerator {
    public static LaborRequestResource getlaborRequest () {
        return LaborRequestResource.builder()
                .length(10.0)
                .width(10.0)
                .ppu(2.0)
                .build();
    }
}
