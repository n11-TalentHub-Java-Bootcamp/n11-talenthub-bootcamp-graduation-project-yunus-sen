package com.yunussen.graduation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "identity_number" , length = 11,nullable =false,unique = true)
    private String identityNumber;
    @Column(name = "name_surname" , length = 150,nullable =false)
    private String nameSurname;
    @Column(name = "phone_number" , length = 12,nullable =false,unique = true)
    private String phoneNumber;
    @Column(name = "monthly_income" , scale=3,nullable =false)
    private Double monthlyIncome;
    @Temporal(TemporalType.DATE)
    @Column(name = "bithdate")
    private Date birthDate;
    @Column(name = "assurance",scale = 3)
    private Double assurance;
}
