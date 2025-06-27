package com.sw.service.rest.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaborResponseResource {

    private Double totalCost;

    public LaborResponseResource(double totalCost){
        this.totalCost = totalCost;
    }
}
