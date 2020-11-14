package com.frknshnklksz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ADRESS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
    @Id
    @SequenceGenerator(name = "seq_adress", allocationSize = 1)
    @GeneratedValue(generator = "seq_adress", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ADRESS", length = 500)
    private String adress;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ADRESS_ID")
    private Patient patient;

}
