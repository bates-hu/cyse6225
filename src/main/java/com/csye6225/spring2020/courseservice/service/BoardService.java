package com.csye6225.spring2020.courseservice.service;

import com.csye6225.spring2020.courseservice.datamodel.Board;

public class BoardService extends RestService<Board>{
    public BoardService() {
        super(Board.class);
    }
}
