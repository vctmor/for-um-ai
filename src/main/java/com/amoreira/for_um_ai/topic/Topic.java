package com.amoreira.for_um_ai.topic;

import java.time.LocalDate;

public class Topic {

    private Long id;
    private String title;
    private String message;
    private LocalDate creationDate;
    private boolean topicStatus;
    private String author;
    private String course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(boolean topicStatus) {
        this.topicStatus = topicStatus;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
