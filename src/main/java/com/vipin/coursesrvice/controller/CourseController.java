package com.vipin.coursesrvice.controller;

import com.vipin.coursesrvice.entity.Course;
import com.vipin.coursesrvice.request.CourseRequest;
import com.vipin.coursesrvice.request.CourseStudentRequest;
import com.vipin.coursesrvice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public ResponseEntity<Object> getCourses(){
        if(courseService.getCourses()!=null){
            return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Records not found",HttpStatus.OK);
        }
    }

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody CourseRequest courseRequest){
       courseService.createCourse(courseRequest);
       return new ResponseEntity<>("Successfully created course",HttpStatus.OK);
    }

    @PostMapping("/course/enroll")
    public ResponseEntity<String> enrollForCourse(@RequestBody CourseStudentRequest courseStudentRequest){
        courseService.enrollForCourse(courseStudentRequest);
        return new ResponseEntity<>("Enrolled Successfully",HttpStatus.OK);
    }

    @GetMapping("/course/student/{id}")
    public ResponseEntity<List<Course>> listCoursesByStudentId(@PathVariable("id") int id) {

        return new ResponseEntity<>(courseService.getCoursesByStudentId(id),HttpStatus.OK);
    }
}
