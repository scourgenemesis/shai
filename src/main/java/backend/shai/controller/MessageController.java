package backend.shai.controller;


import backend.shai.dto.MessageDto;
import backend.shai.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public MessageDto sendMessage(@RequestBody MessageDto messageDto) {
        return messageService.sendMessage(messageDto);
    }


    @GetMapping("/chat/{chatId}")
    public Page<MessageDto> getMessages(
            @PathVariable Long chatId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return messageService.getMessagesByChatId(chatId, page, size);
    }

    @PostMapping
    public MessageDto deleteMessage(@RequestBody MessageDto messageDto) {

    }


}
