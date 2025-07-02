package com.sw.service.domain.service;

import com.sw.service.domain.entity.Labor;
import com.sw.service.domain.repository.LaborRepository;
import com.sw.service.rest.mapper.LaborMapper;
import com.sw.service.rest.v1.LaborRequestResource;
import com.sw.service.rest.v1.LaborResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaborServiceDefault {

    private final LaborRepository laborRepository;
    private final LaborMapper labormapper;

    public Labor createLabor (Labor labor) {
        return laborRepository.save(labor);
    }

    public Labor getLaborById (Long id) {
        return laborRepository.findById(id).orElse(null);
    }

    public List<Labor> findAllLabor() {
        return laborRepository.findAll();
    }

    public Labor updateLabor(Long id, Labor updatedLabor) {
        return laborRepository.findById(id).map(existing -> {
            existing.setLength(updatedLabor.getLength());
            existing.setWidth(updatedLabor.getWidth());
            existing.setPpu(updatedLabor.getPpu());
            return laborRepository.save(existing);
        }).orElse(null);
    }
    public boolean deleteLabor(Long id) {
        if (laborRepository.existsById(id)) {
            laborRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public LaborResponseResource calculateTotalCost (LaborRequestResource request) {
        double totalCost = (request.getLength() * request.getWidth()) * request.getPpu();
        LaborMapper laborMapper = new LaborMapper();
        return laborMapper.convertLabortoLaborResponse(totalCost);
    }
}
