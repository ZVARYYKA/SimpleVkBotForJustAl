package dev.zvaryyka.simplevkbotforjustal.models.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageNewEvent {
    private String type;

    @JsonProperty("group_id")
    private int groupId;

    @JsonProperty("event_id")
    private String eventId;

    private String v;

    private MessageObject object;
}
