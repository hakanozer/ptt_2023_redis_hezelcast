package com.works;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastInitializer {
    public HazelcastInitializer(){
        HazelcastListener hazelcastListener = new HazelcastListener();
        HazelcastInstance hz= Hazelcast.newHazelcastInstance();
        ITopic<String> iTopic = hz.getTopic("ptt_topic");
        iTopic.addMessageListener(hazelcastListener);
    }

}