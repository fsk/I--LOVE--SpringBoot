package com.frknshnklksz.controllers;

import com.frknshnklksz.dto.PatientDto;
import com.frknshnklksz.services.implement.PatientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientImpl patientImpl;

    @PostMapping
    public ResponseEntity<PatientDto> add(@RequestBody PatientDto patientDto){
        return ResponseEntity.ok(patientImpl.save(patientDto));
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> list(){
        return ResponseEntity.ok(patientImpl.getAll());
    }


}
