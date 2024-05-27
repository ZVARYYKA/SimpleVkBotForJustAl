package dev.zvaryyka.simplevkbotforjustal.models.message;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageObject {
    private Message message;

    @JsonProperty("client_info")
    private ClientInfo clientInfo;

}
