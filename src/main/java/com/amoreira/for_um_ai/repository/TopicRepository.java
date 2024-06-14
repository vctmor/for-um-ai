package com.amoreira.for_um_ai.repository;

import com.amoreira.for_um_ai.topic.DataListTopic;
import com.amoreira.for_um_ai.topic.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
;

public interface TopicRepository extends JpaRepository<Topic,Long> {

    Topic save(Topic data);

    //Page<DataListTopic> findAll();

}
