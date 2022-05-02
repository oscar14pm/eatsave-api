package com.evoteam.eatsave.api.domain.models;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="consultants", schema = "public")
public class Consultant {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
