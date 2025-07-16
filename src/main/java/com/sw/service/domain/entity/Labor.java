package com.sw.service.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Labor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double length;
    private Double width;
    private Double ppu;
    private Double cost;

//    public Double calculate () {
//        cost = (this.length * this.width) * this.ppu;
//        return cost;
//    }
}
