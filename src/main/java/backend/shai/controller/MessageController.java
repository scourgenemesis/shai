package backend.shai.controller;


import backend.shai.dto.MessageDto;
import backend.shai.model.Message;
import backend.shai.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message sendMessage(@RequestBody MessageDto messageDto) {
        return messageService.sendMessage(messageDto);
    }


    @GetMapping("/chat/{chatId}")
    public List<Message> getMessages(
            @PathVariable Long chatId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        return messageService.getMessages(messageService);
    }
}
