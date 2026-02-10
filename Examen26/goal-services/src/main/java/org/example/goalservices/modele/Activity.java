package org.example.goalservices.modele;

import lombok.*;

@Getter @Setter
@ToString @NoArgsConstructor @AllArgsConstructor
@Builder


public class Activity {
    private Long idActivity;
    private String type;
    private Integer duree;
    private String calories;

}
