package com.evoteam.eatsave.api.domain.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

public class Consultancy {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
}
