package com.csye6225.spring2020.courseservice.service;

import com.csye6225.spring2020.courseservice.datamodel.Board;
import com.csye6225.spring2020.courseservice.utils.ResponseWrapper;

public class BoardService extends RestService<Board>{
    private CoursesService coursesService;
    public BoardService() {
        super(Board.class);
        this.coursesService = new CoursesService();
    }

    @Override
    public ResponseWrapper addWithGeneratedId(Board model) {
        if (model.getCourseId() == null) {
            return ResponseWrapper.ofErr(10, "no course Id");
        }

        if (coursesService.get(model.getCourseId()).getBody() != null) {
            return ResponseWrapper.ofErr(11, "course was created");
        }

        return super.addWithGeneratedId(model);
    }
}
