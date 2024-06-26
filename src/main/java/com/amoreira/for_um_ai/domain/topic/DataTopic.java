package com.amoreira.for_um_ai.domain.topic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataTopic(@Valid
        @NotNull Long id,
        @NotBlank String author,
        @NotBlank String title,
        @NotBlank String message,
        @NotBlank String course
) { }
