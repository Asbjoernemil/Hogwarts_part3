package edu.hogwarts.studentadmin.controllers;

import edu.hogwarts.studentadmin.models.Course;
import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.models.Teacher;
import edu.hogwarts.studentadmin.repositories.CourseRepository;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import edu.hogwarts.studentadmin.repositories.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public CourseController(CourseRepository courseRepository, TeacherRepository teacherRepository,
                            StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;

    }


    @PutMapping("courses/{id}/teacher")
    public ResponseEntity<Course> updateCourseTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        Optional<Course> course = courseRepository.findById(id);
        Optional<Teacher> newTeacher = teacherRepository.findById(teacher.getId());

        if (course.isPresent() && newTeacher.isPresent()) {
            Course existingCourse = course.get();
            Teacher existingTeacher = newTeacher.get();

            existingCourse.setTeacher(existingTeacher);

            courseRepository.save(existingCourse);
            return ResponseEntity.ok().body(existingCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("courses/{id}/students")
    public ResponseEntity<Course> addStudentToCourse(@PathVariable int id, @RequestBody Student student) {
        Optional<Course> course = courseRepository.findById(id);

        if(course.isPresent()) {
            Course existingCourse = course.get();
            existingCourse.setStudentToCourse(student);

            courseRepository.save(existingCourse);
            return ResponseEntity.ok().body(existingCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("courses/{id}/students")
    public ResponseEntity<List<Student>> getCourseStudents(@PathVariable int id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);

        if (optionalCourse.isPresent()) {
            List<Student> courseStudents = optionalCourse.get().getStudents();
            return ResponseEntity.ok(courseStudents);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("courses/{id}/teacher")
    public ResponseEntity<Teacher> getCourseTeacher(@PathVariable int id) {
        Optional<Course> course = courseRepository.findById(id);

        if(course.isPresent()) {
            Teacher teacher = course.get().getTeacher();

            return ResponseEntity.ok().body(teacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id) {
        Optional<Course> course = courseRepository.findById(id);

        return ResponseEntity.of(course);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();

        return courses;
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Optional<Course> original = courseRepository.findById(id);

        if(original.isPresent()) {
            Course originalCourse = original.get();
            originalCourse.copyFrom(course);

            Course updatedCourse = courseRepository.save(originalCourse);
            return ResponseEntity.ok().body(updatedCourse);
        } else {
            Course newCourse = new Course(course);

            Course savedCourse = courseRepository.save(newCourse);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
        }
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable int id) {
        Optional<Course> courseToDelete = courseRepository.findById(id);

        if (courseToDelete.isPresent()) {
            courseToDelete.get().getStudents().clear();
        }

        courseRepository.deleteById(id);

        return ResponseEntity.of(courseToDelete);
    }

    @DeleteMapping("/courses/{id}/teacher")
    public ResponseEntity<Course> deleteTeacherFromCourse(@PathVariable int id, @RequestBody Teacher teacher) {
        Optional<Teacher> teacherToDeleteFromCourse = teacherRepository.findById(teacher.getId());
        Optional<Course> courseToDeleteTeacherFrom = courseRepository.findById(id);

        if (teacherToDeleteFromCourse.isPresent() && courseToDeleteTeacherFrom.isPresent()) {
            Course existingCourse = courseToDeleteTeacherFrom.get();
            existingCourse.setTeacher(null);

            courseRepository.save(existingCourse);
            return ResponseEntity.ok().body(existingCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("courses/{id}/students")
    public ResponseEntity<Course> deleteStudentFromCourse(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> studentToDelete = studentRepository.findById(student.getId());
        Optional<Course> courseToDeleteStudentFrom = courseRepository.findById(id);

        if (studentToDelete.isPresent() && courseToDeleteStudentFrom.isPresent()) {
            Course existingCourse = courseToDeleteStudentFrom.get();
            Student existingStudent = studentToDelete.get();

            existingCourse.getStudents().remove(existingStudent);

            courseRepository.save(existingCourse);
            return ResponseEntity.ok().body(existingCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
