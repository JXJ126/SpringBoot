package com.sw.service.rest.mapper;

import com.sw.service.domain.entity.Labor;
import com.sw.service.rest.v1.LaborRequestResource;
import com.sw.service.rest.v1.LaborResponseResource;
import org.springframework.stereotype.Component;

@Component
public class LaborMapper {

    public LaborResponseResource convertLabortoLaborResponse(double totalCost) {
        return new LaborResponseResource(totalCost);
    }

    public Labor convertLaborRequesttoLabor (LaborRequestResource request) {
        return new Labor(
                null,
                request.getLength(),
                request.getWidth(),
                request.getPpu()
        );
    }
}

