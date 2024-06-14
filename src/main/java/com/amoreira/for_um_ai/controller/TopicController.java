package com.amoreira.for_um_ai.controller;

import com.amoreira.for_um_ai.repository.TopicRepository;
import com.amoreira.for_um_ai.topic.DataTopic;
import com.amoreira.for_um_ai.topic.Topic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("new")
public class TopicController {

    @Autowired
    TopicRepository repository;


    @PostMapping
    @Transactional
    public void add(@RequestBody @Valid DataTopic data){

        repository.save(new Topic(data));

    }

}
