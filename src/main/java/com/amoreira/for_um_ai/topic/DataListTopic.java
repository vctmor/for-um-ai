package com.amoreira.for_um_ai.topic;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DataListTopic(
        String title,
        String message,
        LocalDate creationDate,
        Boolean status,
        String author,
        String course) {

    public DataListTopic(Topic topic){

        this(
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getTopicStatus(),
                topic.getAuthor(),
                topic.getCourse()
        );
    }

}
