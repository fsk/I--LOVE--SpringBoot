package com.frknshnklksz.services.implement;

import com.frknshnklksz.dto.PatientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientImpl {


    PatientDto save(PatientDto patientDto);

    void delete(Long id);

    List<PatientDto> getAll();

    Page<PatientDto> getAll(Pageable pageable);
}
