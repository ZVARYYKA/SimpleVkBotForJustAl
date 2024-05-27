package dev.zvaryyka.simplevkbotforjustal.models.event;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Event {
    private String type;

    @JsonProperty("event_id")
    private int eventId;

    private String v;

    private EventObject object;

    @JsonProperty("group_id")
    private int groupId;
}
