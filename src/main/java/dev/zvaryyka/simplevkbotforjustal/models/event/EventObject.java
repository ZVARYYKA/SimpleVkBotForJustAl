package dev.zvaryyka.simplevkbotforjustal.models.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public  class EventObject {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("join_type")
    private String joinType;
}
