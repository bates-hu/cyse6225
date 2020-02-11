package com.csye6225.spring2020.courseservice.datamodel;

import java.util.List;

public class Course {
    private Long id;
    private String board;
//    private List<String> roaster;
    private List<Long> enrolledStudents;
    private Long associatedProfessor;
    private Long teachAssistant;

    public Course() {}

    public Course(String board, Long associatedProfessor, Long teachAssistant) {
        this.board = board;
        this.associatedProfessor = associatedProfessor;
        this.teachAssistant = teachAssistant;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", board='" + board + '\'' +
                ", enrolledStudents=" + enrolledStudents +
                ", associatedProfessor='" + associatedProfessor + '\'' +
                ", teachAssistant='" + teachAssistant + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public List<Long> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Long> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Long getAssociatedProfessor() {
        return associatedProfessor;
    }

    public void setAssociatedProfessor(Long associatedProfessor) {
        this.associatedProfessor = associatedProfessor;
    }

    public Long getTeachAssistant() {
        return teachAssistant;
    }

    public void setTeachAssistant(Long teachAssistant) {
        this.teachAssistant = teachAssistant;
    }
}
