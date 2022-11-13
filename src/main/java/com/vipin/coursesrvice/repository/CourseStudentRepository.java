package com.vipin.coursesrvice.repository;

import com.vipin.coursesrvice.entity.Coursestudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<Coursestudent,Integer> {
}
