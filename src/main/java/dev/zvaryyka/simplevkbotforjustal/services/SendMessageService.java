package dev.zvaryyka.simplevkbotforjustal.services;

import dev.zvaryyka.simplevkbotforjustal.models.message.VkMessageRequest;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class SendMessageService {

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendMessage(VkMessageRequest vkMessageRequest) {
        String encodedMessage;
        try {
            encodedMessage = URLEncoder.encode(vkMessageRequest.getMessage(), StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            log.error("Failed to encode message: {}", vkMessageRequest.getMessage(), e);
            return;
        }

        String url = UriComponentsBuilder.fromHttpUrl("https://api.vk.com/method/messages.send")
                .queryParam("user_id", vkMessageRequest.getUserId())
                .queryParam("message", encodedMessage)
                .queryParam("random_id", vkMessageRequest.getRandomId())
                .queryParam("access_token", vkMessageRequest.getAccessToken())
                .queryParam("v", vkMessageRequest.getVersion())
                .toUriString();

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        log.info("Response from Vk Server: {}", response.getBody());
    }
}
