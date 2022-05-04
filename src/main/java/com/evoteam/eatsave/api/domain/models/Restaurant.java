package com.evoteam.eatsave.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurants", schema = "public")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String internalId;

    private String description;

    @Column
    private String address;

    @NotBlank @NotNull
    @DecimalMin("-90.0") @Max(90L)
    private Double latitude;

    @NotBlank @NotNull
    @Min(-180L) @Max(180L)
    private Double longitude;

    @ManyToOne
    private District district;
}
