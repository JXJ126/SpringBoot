package com.sw.service.rest;

import com.sw.service.rest.v1.LaborRequestResource;
import com.sw.service.rest.v1.LaborResponseResource;
import com.sw.service.domain.service.LaborService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LaborController{

    private final LaborService laborService;

    @PostMapping("/labor/price")
    public LaborResponseResource calculateCost(@RequestBody LaborRequestResource request) {
        System.out.println(request);
        return laborService.calculateTotalCost(request);
    }

    @GetMapping("/test")
    public String test(){
        return "API is running!";
    }
}
