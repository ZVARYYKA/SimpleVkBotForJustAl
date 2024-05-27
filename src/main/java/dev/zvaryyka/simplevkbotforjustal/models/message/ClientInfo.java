package dev.zvaryyka.simplevkbotforjustal.models.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public  class ClientInfo {
    @JsonProperty("button_actions")
    private String[] buttonActions;

    private boolean keyboard;

    @JsonProperty("inline_keyboard")
    private boolean inlineKeyboard;

    @JsonProperty("lang_id")
    private int langId;
}