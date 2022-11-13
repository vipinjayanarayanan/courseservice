package com.vipin.coursesrvice.service;

import com.vipin.coursesrvice.entity.Course;
import com.vipin.coursesrvice.entity.Coursestudent;
import com.vipin.coursesrvice.repository.CourseRepository;
import com.vipin.coursesrvice.repository.CourseStudentRepository;
import com.vipin.coursesrvice.request.CourseRequest;
import com.vipin.coursesrvice.request.CourseStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseStudentRepository courseStudentRepository;

    public List<Course> getCourses(){
        if(!courseRepository.findAll().isEmpty()){
            return courseRepository.findAll();
        }
        else{
            return null;
        }
    }

    public List<Course> getCoursesByStudentId(int id){
        List<Course> c = courseRepository.findCoursesByStudentId(id);
        if(!courseRepository.findCoursesByStudentId(id).isEmpty()){
            return courseRepository.findCoursesByStudentId(id);
        }
        else{
            return null;
        }
    }

    public void createCourse(CourseRequest courseRequest){
        Course course = new Course();
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        courseRepository.save(course);
    }

    public void enrollForCourse(CourseStudentRequest courseStudentRequest){
        Course course = courseRepository.findById(courseStudentRequest.getCourseId()).get();
        Coursestudent coursestudent = new Coursestudent();
        coursestudent.setCourse(course);
        coursestudent.setStudentId(courseStudentRequest.getStudentId());
        courseStudentRepository.save(coursestudent);
    }
}
