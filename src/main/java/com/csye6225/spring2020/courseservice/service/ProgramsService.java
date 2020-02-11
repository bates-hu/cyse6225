package com.csye6225.spring2020.courseservice.service;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramsService {
    static HashMap<Long, Program> programDB = InMemoryDatabase.getProgramDB();

    public ProgramsService() {
    }

    // GET "..webapi/programs"
    public List<Program> getAllPrograms() {
        //Getting the list
        ArrayList<Program> list = new ArrayList<>();
        for (Program program : programDB.values()) {
            list.add(program);
        }
        return list ;
    }

    public Program addProgram(Program program) {
        // Next Id
        long nextAvailableId = programDB.size() + 1;
        program.setId(nextAvailableId);
        programDB.put(nextAvailableId, program);

        return program;
    }


    public Program getProgram(Long programID) {

        //Simple HashKey Load
        Program program = programDB.get(programID);
        System.out.println("Item retrieved:");
        System.out.println(program.toString());

        return program;
    }

    public Program deleteProgram(Long programID) {
        Program deletedProgramDetails = programDB.get(programID);
        programDB.remove(programID);
        return deletedProgramDetails;
    }

    public Program updateProgramInformation(Long programID, Program program) {
        program.setId(programID);
        programDB.put(programID, program);
        return program;
    }
}
