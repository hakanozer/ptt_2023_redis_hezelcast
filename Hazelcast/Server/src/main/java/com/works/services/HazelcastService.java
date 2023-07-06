package com.works.services;

import com.google.gson.Gson;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;
import com.works.models.UserMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HazelcastService implements MessageListener<String> {



    private HazelcastInstance hz;//= Hazelcast.newHazelcastInstance();
    public void send(String message){
        hz= Hazelcast.newHazelcastInstance();
        ITopic<String> iTopic = hz.getTopic("ptt_topic");
        iTopic.addMessageListener(new HazelcastService());

        UserMessage userMessage = new UserMessage();
        userMessage.setUid(100);
        userMessage.setName("Ali Bilmem");
        userMessage.setMessage("Selam Ali");

        UserMessage userMessage1 = new UserMessage();
        userMessage1.setUid(101);
        userMessage1.setName("Erklan Bilmem");
        userMessage1.setMessage("Erkan Ali");

        List<UserMessage> userMessages = new ArrayList<>();
        userMessages.add(userMessage);
        userMessages.add(userMessage1);


        Gson gson = new Gson();

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            long end = System.currentTimeMillis();
            userMessage.setTime(end);
            userMessage.setBegin(begin);
            String data = gson.toJson(userMessages);
            iTopic.publish(data);
            System.out.println( data );
        }
        //hz.shutdown();
    }

    @Override
    public void onMessage(Message<String> message) {
        String pullData = message.getMessageObject();
        Gson gson = new Gson();
        com.works.model.UserMessage[] userMessages = gson.fromJson(pullData,com.works.model.UserMessage[].class );
        System.out.println( userMessages );
        for( com.works.model.UserMessage item : userMessages ) {
            System.out.println( "item : " + item );
        }
    }
}
