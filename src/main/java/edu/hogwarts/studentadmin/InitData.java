package edu.hogwarts.studentadmin;

import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitData implements CommandLineRunner {

    private StudentRepository studentRepository;

    public InitData(){}

    @Autowired
    public InitData(StudentRepository studentRepository){
        this.studentRepository = studentRepository;

    }
    public void run(String...args){
        System.out.println("INITDATA HEYOO");

        //STUDENTS
        Student harryPotter = new Student("Harry", "James", "Potter",
                LocalDate.of(1980, 7, 31),
                true, 1991, 1998, true);

        Student dracoMalfoy = new Student("Draco", "Lucius", "Malfoy",
                LocalDate.of(1980, 6, 5),
                false, 1991, 1998, true);

        studentRepository.save(harryPotter);
        studentRepository.save(dracoMalfoy);


    }
}
