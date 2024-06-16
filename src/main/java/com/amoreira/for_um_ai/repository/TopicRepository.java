package com.amoreira.for_um_ai.repository;

import com.amoreira.for_um_ai.domain.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
;

public interface TopicRepository extends JpaRepository<Topic,Long> {

    Topic save(Topic data);

    //Page<DataListTopic> findAll();

}
