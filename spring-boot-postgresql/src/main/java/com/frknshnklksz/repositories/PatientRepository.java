package com.frknshnklksz.repositories;

import com.frknshnklksz.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
