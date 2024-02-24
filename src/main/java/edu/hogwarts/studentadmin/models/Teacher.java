package edu.hogwarts.studentadmin.models;

import edu.hogwarts.studentadmin.EmpType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean headOfHouse;
    @Enumerated(EnumType.STRING)
    private EmpType employmentType;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;
    @ManyToOne
    private House house;

    public Teacher(String firstName, String middleName, String lastName, LocalDate dateOfBirth, boolean headOfHouse, EmpType employmentType, LocalDate employmentStart, LocalDate employmentEnd, House house) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.headOfHouse = headOfHouse;
        this.employmentType = employmentType;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
        this.house = house;
    }

    public Teacher(){
    }

    public Teacher(Teacher otherTeacher) {
        this.firstName = otherTeacher.getFirstName();
        this.middleName = otherTeacher.getMiddleName();
        this.lastName = otherTeacher.getLastName();
        this.dateOfBirth = otherTeacher.getDateOfBirth();
        this.headOfHouse = otherTeacher.isHeadOfHouse();
        this.employmentType = otherTeacher.getEmploymentType();
        this.employmentStart = otherTeacher.getEmploymentStart();
        this.employmentEnd = otherTeacher.getEmploymentEnd();
        this.house = otherTeacher.getHouse();

    }

    public void copyFrom(Teacher otherTeacher) {
        this.setFirstName(otherTeacher.getFirstName());
        this.setMiddleName(otherTeacher.getMiddleName());
        this.setLastName(otherTeacher.getLastName());
        this.setDateOfBirth(otherTeacher.getDateOfBirth());
        this.setHeadOfHouse(otherTeacher.isHeadOfHouse());
        this.setEmploymentType(otherTeacher.getEmploymentType());
        this.setEmploymentStart(otherTeacher.getEmploymentStart());
        this.setEmploymentEnd(otherTeacher.getEmploymentEnd());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(boolean headOfHouse) {
        this.headOfHouse = headOfHouse;
    }

    public EmpType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmpType employmentType) {
        this.employmentType = employmentType;
    }

    public LocalDate getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(LocalDate employmentStart) {
        this.employmentStart = employmentStart;
    }

    public LocalDate getEmploymentEnd() {
        return employmentEnd;
    }

    public void setEmploymentEnd(LocalDate employmentEnd) {
        this.employmentEnd = employmentEnd;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return firstName + middleName + lastName + " ";
    }
}
