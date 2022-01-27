package com.yunussen.graduation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "credit_score")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CreditScoreEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "credit_score",scale = 3,nullable = false)
    private Double assurance;
    @Column(name = "user_id",nullable = false)
    private Long userId;

}
