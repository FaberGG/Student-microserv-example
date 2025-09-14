package co.unicauca.apireststudent.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "students")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="studentId", unique = true )
    private int studentId;
    @Column(name="name")
    private String name;
    @Column(name="program")
    @Enumerated(EnumType.STRING)
    private enumProgram program;
    @Column(name="email", unique = true)
    private String email;



}
