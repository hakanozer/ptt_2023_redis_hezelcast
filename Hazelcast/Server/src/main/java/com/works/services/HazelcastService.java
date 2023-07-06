package com.works.services;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class HazelcastService {

    private HazelcastInstance hz = Hazelcast.newHazelcastInstance();

    public void send( String messsage ) {
        ITopic iTopic = hz.getTopic("ptt_topic");
        iTopic.publish(messsage);
        //hz.shutdown();
    }

}
