package dev.zvaryyka.simplevkbotforjustal.models.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VkMessageRequest {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("random_id")
    private int randomId;

    private String message;

    private String accessToken;

    @JsonProperty("v")
    private String version;
}