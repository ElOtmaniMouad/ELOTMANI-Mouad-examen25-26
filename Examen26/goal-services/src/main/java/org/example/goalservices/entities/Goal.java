package org.example.goalservices.entities;


import org.example.goalservices.modele.Activity;
import org.example.goalservices.modele.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Goal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGoal;
    private  Long idUser;
    @Transient
    private User user;
    private Long idActivity;
    @Transient
    private Activity activity;
    private Long targetDuree;
    private  String statut  ;
}
