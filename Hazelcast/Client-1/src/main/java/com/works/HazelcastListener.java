package com.works;

import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;

public class HazelcastListener implements MessageListener<String> {
    @Override
    public void onMessage(Message message) {
        System.out.println("Pull message:"+message.getMessageObject());
    }
}
