package dev.zvaryyka.simplevkbotforjustal.controllers;

import dev.zvaryyka.simplevkbotforjustal.models.message.MessageNewEvent;
import dev.zvaryyka.simplevkbotforjustal.models.message.VkMessageRequest;
import dev.zvaryyka.simplevkbotforjustal.services.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
public class MessageController {

    private final SendMessageService sendMessageService;

    @Value("${vk.api.token}")
    private String vkApiToken;

    @Value("${vk.api.version}")
    private String vkApiVersion;

    @Autowired
    public MessageController(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @PostMapping("/newMessage")
    public String receiveNewMessageAndGiveResponse(@RequestBody MessageNewEvent event) {
        log.info("Received event: {}", event);

        String messageText = event.getObject().getMessage().getText();
        int userId = event.getObject().getMessage().getFromId();
        log.info("Message text: {}", messageText);

        VkMessageRequest vkMessageRequest = new VkMessageRequest(
                userId,
                ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE),
                "You say " + messageText,
                vkApiToken,
                vkApiVersion
        );

        sendMessageService.sendMessage(vkMessageRequest);

        return "ok";
    }
}
