package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Professor;

public class ProfessorsService {

    static HashMap<Long, Professor> prof_Map = InMemoryDatabase.getProfessorDB();

    public ProfessorsService() {
    }

    // Getting a list of all professor
    // GET "..webapi/professors"
    public List<Professor> getAllProfessors() {
        //Getting the list
        ArrayList<Professor> list = new ArrayList<>();
        for (Professor prof : prof_Map.values()) {
            list.add(prof);
        }
        return list ;
    }

//    // Adding a professor
//    public Professor addProfessor(String firstName, String lastName, String department, Date joiningDate) {
//        // Next Id
//        return addProfessor(new Professor(firstName, lastName,
//                department, joiningDate.toString()));
//    }

    public Professor addProfessor(Professor prof) {
        // Next Id
        long nextAvailableId = prof_Map.size() + 1;
        prof.setId(nextAvailableId);
        prof_Map.put(nextAvailableId, prof);
        return prof;
    }


    // Getting One Professor
    public Professor getProfessor(Long profId) {

        //Simple HashKey Load
        Professor prof2 = prof_Map.get(profId);
        System.out.println("Item retrieved:");
        System.out.println(prof2.toString());

        return prof2;
    }

    // Deleting a professor
    public Professor deleteProfessor(Long profId) {
        Professor deletedProfDetails = prof_Map.get(profId);
        prof_Map.remove(profId);
        return deletedProfDetails;
    }

    // Updating Professor Info
    public Professor updateProfessorInformation(Long profId, Professor prof) {
        prof.setId(profId);
        prof_Map.put(profId, prof);
        return prof;
    }

    // Get professors in a department
    public List<Professor> getProfessorsByDepartment(String department) {
        //Getting the list
        return prof_Map.values().stream()
                .filter(prof -> department.equals(prof.getDepartment())).collect(Collectors.toList());
    }

    // Get professors for a year with a size limit

}

