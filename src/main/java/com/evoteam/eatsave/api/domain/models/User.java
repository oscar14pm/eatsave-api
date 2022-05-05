package com.evoteam.eatsave.api.domain.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users", schema = "public")
public class User {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull @NotBlank
    private String firstName;

    @NotNull @NotBlank
    private String lastName;

    @NotNull @NotBlank
    @Column(unique = true)
    private String username;

    @NotNull @NotBlank
    private String password;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

}
