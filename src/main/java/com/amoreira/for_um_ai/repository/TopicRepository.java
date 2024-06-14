package com.amoreira.for_um_ai.repository;

import com.amoreira.for_um_ai.topic.Topic;
import org.springframework.data.repository.Repository;
;

public interface TopicRepository extends Repository<Topic,Long> {

    Topic save(Topic data);

}
