package com.frknshnklksz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "PATIENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Patient {

    @Id
    @SequenceGenerator(name = "seq_patient", allocationSize = 1)
    @GeneratedValue(generator = "seq_patient", strategy = GenerationType.SEQUENCE)
    private Long patientId;

    @Column(name = "PATIENT_NAME")
    private String patientName;

    @Column(name = "PATIENT_SURNAME")
    private String patientSurname;

    @Column(name = "PATIENT_AGE")
    private Integer patientAge;

    @Column(name = "PATIENT_BIRTHDAY")
    private Date patientBirthDay;

    @Column(name = "PATIENT_IDENTITY_NUMBER", length = 11, unique = true,
    nullable = false)
    private String patientIdentityNumber;

    @OneToMany
    @JoinColumn(name = "PATIENT_ADRESS_ID")
    private List<Adress> patientAdresses;

    @Column(name = "PATIENT_GENDER", length = 1)
    private String patientGender;

    @Column(name = "TYPE_OF_PATIENT")
    @Enumerated(EnumType.STRING)
    private TypeOfPatient typeOfPatient;

    @Column(name = "COMPLAINT", length = 550)
    private String complaint;

}
