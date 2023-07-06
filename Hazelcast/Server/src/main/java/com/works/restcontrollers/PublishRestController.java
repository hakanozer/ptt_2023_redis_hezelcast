package com.works.restcontrollers;

import com.works.services.HazelcastService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PublishRestController {

    final HazelcastService hazelcastService;

    @GetMapping("/publish")
    public String publish() {
        String uuid = UUID.randomUUID().toString();
        hazelcastService.send(uuid);
        return "send..";
    }

}
