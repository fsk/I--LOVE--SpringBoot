package com.frknshnklksz.dto;

import com.frknshnklksz.entities.Adress;
import lombok.Data;

import java.util.List;

@Data
public class PatientDto {

    private Long id;
    private String name;
    private String surname;
    private String identityNumber;
    private String complaint;
    private List<String> adresses;
    private Integer age;
    private String gender;

}
