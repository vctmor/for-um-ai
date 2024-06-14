package com.amoreira.for_um_ai.controller;

import com.amoreira.for_um_ai.repository.TopicRepository;
import com.amoreira.for_um_ai.topic.DataTopic;
import com.amoreira.for_um_ai.topic.DataListTopic;
import com.amoreira.for_um_ai.topic.Topic;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    TopicRepository repository;


    @PostMapping
    @Transactional
    public void add(@RequestBody @Valid DataTopic data){

        repository.save(new Topic(data));
    }

    @GetMapping
    public Page<DataListTopic> list(
            @PageableDefault(size = 10, sort = {"author"})
            Pageable pagination){

        return repository.findAll(pagination)
                .map(DataListTopic::new);

    }

//    @GetMapping
//    public List<DataListTopic> list(){
//
//        return repository.findAll()
//                .stream().map(DataListTopic::new).toList();
//    }

}
