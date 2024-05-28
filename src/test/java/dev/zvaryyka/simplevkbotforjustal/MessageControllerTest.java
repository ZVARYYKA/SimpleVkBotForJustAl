package dev.zvaryyka.simplevkbotforjustal;

import dev.zvaryyka.simplevkbotforjustal.controllers.MessageController;
import dev.zvaryyka.simplevkbotforjustal.models.message.VkMessageRequest;
import dev.zvaryyka.simplevkbotforjustal.services.SendMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

    @Mock
    private SendMessageService sendMessageService;

    @InjectMocks
    private MessageController messageController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
    }

    @Test
    public void testReceiveNewMessageAndGiveResponse() throws Exception {
        Mockito.doNothing().when(sendMessageService).sendMessage(Mockito.any(VkMessageRequest.class));
        // Пример JSON для входящего события
        String messageNewEventJson = "{ \"type\": \"message_new\", \"object\": { \"message\": { \"from_id\": 123456, \"text\": \"Hello\" } } }";

        // Отправляем POST запрос к нашему контроллеру
        mockMvc.perform(MockMvcRequestBuilders.post("/newMessage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(messageNewEventJson))
                .andExpect(status().isOk());

        // Проверяем, что метод sendMessage был вызван один раз с правильными параметрами
        Mockito.verify(sendMessageService,
                Mockito.times(1))
                .sendMessage(Mockito.any(VkMessageRequest.class));
    }

}
