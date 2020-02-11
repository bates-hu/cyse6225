package com.csye6225.spring2020.courseservice.datamodel;
//     - Every Course has Lectures, and each lecture will have notes, and associated material

import java.util.List;

public class Lecture {
    private Long id;
    private List<String> notes;
    private String material;
    private String publishDate;

    public Lecture() {}

    public Lecture(List<String> notes, String material, String publishDate) {
        this.notes = notes;
        this.material = material;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", notes=" + notes +
                ", material='" + material + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
