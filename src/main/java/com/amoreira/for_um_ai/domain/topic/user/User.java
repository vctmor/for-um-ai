package com.amoreira.for_um_ai.domain.topic.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="User")
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String passwd;

}
