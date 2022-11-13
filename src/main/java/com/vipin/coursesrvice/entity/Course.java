package com.vipin.coursesrvice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Course {

    @Id @GeneratedValue
    private int id;
    private String name;

    private String description;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Coursestudent> coursestudents;
}
