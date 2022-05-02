package com.evoteam.eatsave.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clients", schema = "public")
public class Client {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull @NotBlank
    @Column(unique = true)
    private String businessName;

    @OneToMany
    private Collection<Restaurant> restaurants = new ArrayList<>();

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
