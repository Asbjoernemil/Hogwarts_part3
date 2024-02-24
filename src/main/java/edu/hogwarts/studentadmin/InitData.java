package edu.hogwarts.studentadmin;

import edu.hogwarts.studentadmin.models.House;
import edu.hogwarts.studentadmin.models.HouseColor;
import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.models.Teacher;
import edu.hogwarts.studentadmin.repositories.HouseRepository;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import edu.hogwarts.studentadmin.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private HouseRepository houseRepository;


    public InitData(){}

    @Autowired
    public InitData(StudentRepository studentRepository, TeacherRepository teacherRepository, HouseRepository houseRepository){
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.houseRepository = houseRepository;

    }
    public void run(String...args){
        System.out.println("INITDATA HEYOO");

        //HOUSE
        House slytherin = new House("Slytherin","Salazar Slytherin",
                List.of(new HouseColor("Green"), new HouseColor("Silver")));

        House gryffindor = new House("Gryffindor","Godric Gryffindor",
                List.of(new HouseColor("Red"), new HouseColor("Gold")));

        House hufflepuff = new House("Hufflepuff","Helga Hufflepuff",
                List.of(new HouseColor("Yellow"), new HouseColor("Black")));

        House ravenclaw = new House("Ravenclaw","Rowena Ravenclaw",
                List.of(new HouseColor("Blue"), new HouseColor("Bronze")));

        houseRepository.save(gryffindor);
        houseRepository.save(hufflepuff);
        houseRepository.save(ravenclaw);
        houseRepository.save(slytherin);

        //STUDENTS
        Student harryPotter = new Student("Harry", "James", "Potter",
                LocalDate.of(1980, 7, 31),
                true, 1991, 1998, true,gryffindor);

        Student dracoMalfoy = new Student("Draco", "Lucius", "Malfoy",
                LocalDate.of(1980, 6, 5),
                false, 1991, 1998, true, slytherin);

        studentRepository.save(harryPotter);
        studentRepository.save(dracoMalfoy);

        //TEACHERS
        Teacher severusSnape = new Teacher("Severus", "Hilm", "Snape", LocalDate.of(1960, 1, 9),
                true, EmpType.TENURED, LocalDate.of(1981, 9, 1), null);

        teacherRepository.save(severusSnape);


    }
}
