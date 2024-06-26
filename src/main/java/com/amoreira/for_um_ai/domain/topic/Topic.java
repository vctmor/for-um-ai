package com.amoreira.for_um_ai.domain.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "topics")

public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @Column(name="creation_date")
    @CreationTimestamp
    private LocalDate creationDate;
    @Column(name="topic_status")
    private Boolean topicStatus;
    private String author;
    private String course;

    public Topic(DataTopic topic){

        this.id = topic.id();
        this.topicStatus = true;
        this.title = topic.title();
        this.author = topic.author();
        this.message = topic.message();
        this.course = topic.course();
    }

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

    public boolean getTopicStatus() {
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



    public void dataUpdate(DataUpdateTopic data) {

        Optional<DataUpdateTopic> topic = Optional.ofNullable(data);

        if (topic.isEmpty()) {

            System.out.println("Tópico não encontrado no banco de dados.");

        }else{

            if (data.title() != null)
                this.title = data.title();

            if (data.author() != null)
                this.author = data.author();

            if (data.message() != null)
                this.message = data.message();

            if (data.topicStatus() != null)
                this.topicStatus = data.topicStatus();

            if (data.creationDate() != null)
                this.creationDate = data.creationDate();

            if (data.course() != null)
                this.message = data.course();
        }

    }
        public void logicalDeletion(){

        this.topicStatus = false;

        }



//        try {
//
//            if (topic.isPresent()) {
//
//                if (data.title() != null)
//                    this.title = data.title();
//
//                if (data.author() != null)
//                    this.author = data.author();
//
//                if (data.message() != null)
//                    this.message = data.message();
//
//                if (data.course() != null)
//                    this.message = data.course();
//            }
//
//        }catch (EntityNotFoundException e){
//
//            System.out.println("Tópico não encontrado no banco de dados: " + e);
//        }



}