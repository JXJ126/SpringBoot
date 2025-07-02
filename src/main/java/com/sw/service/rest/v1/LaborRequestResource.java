package com.sw.service.rest.v1;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaborRequestResource {
    @Positive
    private Double length;
    @Positive
    private Double width;
    @Positive
    private Double ppu;
    private Double cost;
}
