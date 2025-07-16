package com.sw.service.rest.mapper;

import com.sw.service.domain.entity.Labor;
import com.sw.service.domain.repository.LaborRepository;
import com.sw.service.domain.service.LaborService;
import com.sw.service.rest.v1.LaborRequestResource;
import com.sw.service.rest.v1.LaborResponseResource;
import com.sw.service.testDataGenerators.domain.entity.LaborGenerator;
import com.sw.service.testDataGenerators.rest.v1.LaborRequestGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LaborMapperTest {

    @Autowired
    private LaborMapper subject;

    @Test
    void GIVEN_a_labor_that_labor_will_be_converted_into_a_Labor_Response () {
        Labor expected = LaborGenerator.getValidLabor();

        LaborResponseResource actual = subject.convertLabortoLaborResponse(expected);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getCost(), actual.getTotalCost());

    }

    @Test
    void GIVEN_a_labor_request_that_labor_request_will_be_converted_into_a_Labor () {
        LaborRequestResource expected = LaborRequestGenerator.getlaborRequest();

        Labor actual = subject.convertLaborRequesttoLabor(expected);

        assertEquals(expected.getLength(), actual.getLength());
        assertEquals(expected.getWidth(), actual.getWidth());
        assertEquals(expected.getPpu(), actual.getPpu());
    }
}
