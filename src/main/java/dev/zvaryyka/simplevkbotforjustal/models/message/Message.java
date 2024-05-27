package dev.zvaryyka.simplevkbotforjustal.models.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

    private long date;

    @JsonProperty("from_id")
    private int fromId;

    private int id;

    private int out;

    @JsonProperty("peer_id")
    private int peerId;


    private String text;

    @JsonProperty("conversation_message_id")
    private int conversationMessageId;

    @JsonProperty("fwd_messages")
    private Object[] fwdMessages;

    private boolean important;

    @JsonProperty("random_id")
    private int randomId;

    private Object[] attachments;

    @JsonProperty("is_hidden")
    private boolean isHidden;
}
