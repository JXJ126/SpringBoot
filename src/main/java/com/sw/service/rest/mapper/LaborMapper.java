package com.sw.service.rest.mapper;

import com.sw.service.domain.entity.Labor;
import com.sw.service.rest.v1.LaborRequestResource;
import com.sw.service.rest.v1.LaborResponseResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LaborMapper {
    @Mapping(source = "cost", target = "totalCost")
    LaborResponseResource convertLabortoLaborResponse (Labor labor);
    Labor convertLaborRequesttoLabor (LaborRequestResource request);
}
