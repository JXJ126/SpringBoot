package com.sw.service.domain.service;

import com.sw.service.domain.entity.Labor;
import com.sw.service.domain.repository.LaborRepository;
import com.sw.service.rest.mapper.LaborMapper;
import com.sw.service.rest.v1.LaborResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaborServiceDefault implements LaborService {

    private final LaborRepository laborRepository;

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
            existing.setCost(updatedLabor.getCost());
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

    public Double calculateCost (Labor labor) {
        Double cost = labor.getWidth() * labor.getLength() * labor.getPpu();
        labor.setCost(cost);
        return cost;
    }

    public Labor saveCost(Labor labor) {
//        double totalCost = (labor.getLength() * labor.getWidth()) * labor.getPpu();
        // Refactor, change it to where the mapping is done in the controller instead of the service
        // Save the cost in the database to make ^ easier. **
        // Watch the rest of the videos
        // Create Service Interface **
        double totalCost = calculateCost(labor);
        labor = laborRepository.save(labor);
//        laborResponseResource.setTotalCost(totalCost);
//        LaborResponseResource laborResponseResource = new LaborResponseResource();
//        laborResponseResource.setTotalCost(totalCost);
        labor.setCost(totalCost);
        return labor;
//        LaborMapper laborMapper = new LaborMapper();
        // 1.The parameter for this method will be Labor instead of LaborRequestResource
        // 2.Calculate the cost
        // 3.Save the Labor object into the repository
        // 4.After saving the object to the repository will now have an ID
        // Labor labor = laborRepository.save(labor);
        // 5.Then map the Labor we got from saving the object to the LaborResponseResource then return it
//        return laborMapper.convertLabortoLaborResponse(totalCost);
    }
}
