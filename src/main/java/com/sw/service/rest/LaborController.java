package com.sw.service.rest;

import com.sw.service.domain.entity.Labor;
import com.sw.service.rest.mapper.LaborMapper;
import com.sw.service.rest.v1.LaborRequestResource;
import com.sw.service.rest.v1.LaborResponseResource;
import com.sw.service.domain.service.LaborService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LaborController{

    private final LaborService laborService;
    private final LaborMapper laborMapper;


    @PostMapping("/labor/price")
    public LaborResponseResource calculateCost(@Valid @RequestBody LaborRequestResource request) {
//        System.out.println(request);

        Labor labor = laborMapper.convertLaborRequesttoLabor(request);

        // 1. Map to labor object
        // 2. Pass the labor object into the service calculateTotalCost method
        return laborMapper.convertLabortoLaborResponse(laborService.saveCost(labor));
    }

    @GetMapping("/test")
    public String test(){
        return "API is running!";
    }
}
