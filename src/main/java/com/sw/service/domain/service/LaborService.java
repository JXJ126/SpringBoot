package com.sw.service.domain.service;

import com.sw.service.domain.entity.Labor;

import java.util.List;

public interface LaborService {
    Labor createLabor (Labor labor);

    Labor getLaborById (Long id);

    List<Labor> findAllLabor();

    Labor updateLabor (Long id ,Labor updatedLabor);

    boolean deleteLabor (Long id);

    Double calculateCost (Labor labor);

    Labor saveCost(Labor labor);
}
