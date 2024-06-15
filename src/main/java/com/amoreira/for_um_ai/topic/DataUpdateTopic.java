package com.amoreira.for_um_ai.topic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataUpdateTopic(@Valid
                              @NotNull Long id,
                               String author,
                               String title,
                               LocalDate creationDate,
                               Boolean topicStatus,
                               String message,
                               String course) {
}
