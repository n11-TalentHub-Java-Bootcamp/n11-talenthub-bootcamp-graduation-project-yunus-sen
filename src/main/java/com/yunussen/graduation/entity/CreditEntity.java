package com.yunussen.graduation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "credit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CreditEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id",nullable = false)
    private Long userId;
    @Column(name = "total_credit",scale = 4)
    private Double totalCredit;
    @Column(name = "credit_result")
    @Enumerated(EnumType.STRING)
    private CreditResult creditResult;
}
