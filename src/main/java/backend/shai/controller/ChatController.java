package backend.shai.controller;

import backend.shai.dto.ChatDto;
import backend.shai.model.Chat;
import backend.shai.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public Chat createChat(@RequestBody ChatDto chatDto) {
        return chatService.crea
    }
}
