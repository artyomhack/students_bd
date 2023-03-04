package com.hibernate.code.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String phonetic;

    @Column
    private String teaches_lesson;

    @ManyToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_student",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    public List<Student> students;

    public Teacher() {

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.firstname).append(' ').append(this.lastname);
        return builder.toString();
    }
}
