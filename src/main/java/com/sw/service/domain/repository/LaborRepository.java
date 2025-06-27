package com.sw.service.domain.repository;

import com.sw.service.domain.entity.Labor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborRepository extends JpaRepository<Labor, Long> {

}
