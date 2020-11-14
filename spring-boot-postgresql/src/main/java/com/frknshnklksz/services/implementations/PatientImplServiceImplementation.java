package com.frknshnklksz.services.implementations;

import com.frknshnklksz.dto.PatientDto;
import com.frknshnklksz.entities.Adress;
import com.frknshnklksz.entities.Patient;
import com.frknshnklksz.repositories.AdressRepository;
import com.frknshnklksz.repositories.PatientRepository;
import com.frknshnklksz.services.implement.PatientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientImplServiceImplementation implements PatientImpl {

    private final PatientRepository patientRepository;
    private final AdressRepository adressRepository;

    @Override
    @Transactional
    public PatientDto save(PatientDto patientDto) {
        final Patient patient = new Patient();
        patient.setPatientName(patientDto.getName());
        patient.setPatientAge(patientDto.getAge());
        patient.setComplaint(patientDto.getComplaint());
        patient.setPatientIdentityNumber(patientDto.getIdentityNumber());
        patient.setPatientGender(patientDto.getGender());
        final Patient patientDB = patientRepository.save(patient);

        List<Adress> list = new ArrayList<>();
        //Patient finalPatient = patient;
        patientDto.getAdresses().forEach(item -> {
            Adress adress = new Adress();
            adress.setAdress(item);
            adress.setPatient(patientDB);
            list.add(adress);
        });

        adressRepository.saveAll(list);

        patientDto.setId(patientDB.getPatientId());
        return patientDto;

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PatientDto> getAll() {
        List<Patient> patientList = patientRepository.findAll();

        List<PatientDto> patientDtos = new ArrayList<>();

        patientList.forEach(i -> {
            PatientDto patientDto = new PatientDto();
            patientDto.setId(i.getPatientId());
            patientDto.setName(i.getPatientName());
            patientDto.setSurname(i.getPatientSurname());
            patientDto.setAge(i.getPatientAge());
            patientDto.setComplaint(i.getComplaint());
            patientDto.setGender(i.getPatientGender());
            patientDto.setAdresses(i.getPatientAdresses().stream()
                    .map(Adress::getAdress).collect(Collectors.toList()));
            patientDtos.add(patientDto);
        });
        return patientDtos;
    }

    @Override
    public Page<PatientDto> getAll(Pageable pageable) {
        return null;
    }
}
