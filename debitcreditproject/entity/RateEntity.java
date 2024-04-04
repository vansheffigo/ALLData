package com.example.debitcreditproject.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="oldRate")
    private Long oldRate;

    @Column(name ="newRate")
    private Long newRate;


    @Column(name="RateDate")
    private Date date;

    @OneToOne
    @JoinColumn(name="poitems")
    private PoItem poitems;
    
}
