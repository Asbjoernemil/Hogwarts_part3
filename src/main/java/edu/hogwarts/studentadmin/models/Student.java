package edu.hogwarts.studentadmin.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private boolean prefect;
    private int enrollmentYear;
    private int graduationYear;
    private boolean graduated;
    @ManyToOne
    private House house;

    public Student( String firstName, String middleName, String lastName, LocalDate dateOfBirth, boolean prefect, int enrollmentYear, int graduationYear, boolean graduated,House house) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.prefect = prefect;
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
        this.house = house;
    }

    public Student() {
    }

    public Student(Student otherStudent) {
        this.firstName = otherStudent.getFirstName();
        this.middleName = otherStudent.getMiddleName();
        this.lastName = otherStudent.getLastName();
        this.dateOfBirth = otherStudent.getDateOfBirth();
        this.prefect = otherStudent.isPrefect();
        this.enrollmentYear = otherStudent.getEnrollmentYear();
        this.graduationYear = otherStudent.getGraduationYear();
        this.graduated = otherStudent.isGraduated();
        this.house = otherStudent.getHouse();
    }

    public void copyFrom(Student otherStudent) {
        this.setFirstName(otherStudent.getFirstName());
        this.setMiddleName(otherStudent.getMiddleName());
        this.setLastName(otherStudent.getLastName());
        this.setDateOfBirth(otherStudent.getDateOfBirth());
        this.setPrefect(otherStudent.isPrefect());
        this.setEnrollmentYear(otherStudent.getEnrollmentYear());
        this.setGraduationYear(otherStudent.getGraduationYear());
        this.setGraduated(otherStudent.isGraduated());
        this.setHouse(otherStudent.getHouse());
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

    public boolean isPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
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
