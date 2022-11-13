package com.vipin.coursesrvice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Coursestudent {
    @Id @GeneratedValue
    private int id;
    private int studentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseiId")
    private Course course;
}
