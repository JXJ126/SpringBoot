package com.sw.service.rest.v1;

import com.sw.service.domain.entity.Labor;
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
    private Integer id;

}
