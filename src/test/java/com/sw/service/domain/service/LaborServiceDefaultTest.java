package com.sw.service.domain.service;

import com.sw.service.domain.entity.Labor;
import com.sw.service.domain.repository.LaborRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LaborServiceDefaultTest {
    LaborService subject;

    @MockitoBean
    LaborRepository mockLaborRepository;
    @Autowired
    private LaborService laborService;

    @BeforeEach
    public void setUp() {
        subject = new LaborServiceDefault(mockLaborRepository);
    }

    @Test
    void Given_a_laborObject_WHEN_calculateCost_is_called_THEN_a_cost_is_returned() {
        Double correctCost = 200.0;
        Labor labor = new Labor(-1,10.0, 10.0, 2.0, 0.0);
        Double calculatedPrice = laborService.calculateCost(labor);
        assertEquals(correctCost, calculatedPrice);
    }
}
