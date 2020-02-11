package com.csye6225.spring2020.courseservice.service;

import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Lecture;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class LecturesService {
    static HashMap<Long, Lecture> lectureDB = InMemoryDatabase.getLectureDB();

    public LecturesService() {
    }

    // Getting a list of all professor
    // GET "..webapi/lectures"
    public List<Lecture> getAllLectures() {
        //Getting the list
        ArrayList<Lecture> list = new ArrayList<>();
        for (Lecture lecture : lectureDB.values()) {
            list.add(lecture);
        }
        return list ;
    }

    public Lecture addLecture(Lecture lecture) {
        // Next Id
        long nextAvailableId = lectureDB.size() + 1;
        lecture.setId(nextAvailableId);
        lectureDB.put(nextAvailableId, lecture);

        return lecture;
    }


    public Lecture getLecture(Long lectureID) {

        //Simple HashKey Load
        Lecture lecture = lectureDB.get(lectureID);
        System.out.println("Item retrieved:");
        System.out.println(lecture.toString());

        return lecture;
    }

    public Lecture deleteLecture(Long lectureID) {
        Lecture deletedLectureDetails = lectureDB.get(lectureID);
        lectureDB.remove(lectureID);
        return deletedLectureDetails;
    }

    public Lecture updateLectureInformation(Long lectureID, Lecture lecture) {
        lecture.setId(lectureID);
        lectureDB.put(lectureID, lecture);
        return lecture;
    }
}
