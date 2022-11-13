package com.vipin.coursesrvice.repository;

import com.vipin.coursesrvice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Query(value = "select A from Course A join A.coursestudents B where B.studentId=:id")
    public List<Course> findCoursesByStudentId(@Param("id") int id);
}
