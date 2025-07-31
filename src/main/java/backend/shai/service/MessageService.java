package backend.shai.service;


import backend.shai.dto.MessageDto;
import backend.shai.model.Message;
import backend.shai.repository.MessageRepository;
import backend.shai.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {
    @Autowired
    private MessageRepository messageRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSocketService webSocketService;


    @Transactional
    public MessageDto sendMessage(MessageDto messageDto) {
        Message msg = new Message();
        msg.setContent(messageDto.getContent());
        msg.setTimestamp(LocalDateTime.now());
        msg = messageRepo.save(msg);
       return MessageDto.fromEntity(msg);
    }


    @Transactional
    public List<MessageDto> getMessagesByChatId(Long chatId) {
        List<Message> messages = messageRepo.findByChatIdOrderByTimestampAsc(chatId);
        return messages.stream().map(MessageDto::fromEntity).toList();
    }

    @Transactional
    public MessageDto getMessagesById(Long id) {
       Message message = messageRepo.findById(id).orElseThrow(() -> new RuntimeException("Message not found!"));
       return MessageDto.fromEntity(message);
    }

    @Transactional
    public void deleteMessage(Long id) {
        messageRepo.deleteById(id);
    }

    @Transactional
    public MessageDto editMessage(Long id, String newContent) {
        Message msg = messageRepo.findById(id).orElseThrow(() -> new RuntimeException("Message not found!"));
        msg.setContent(newContent);
        msg.setTimestamp(LocalDateTime.now());
        return MessageDto.fromEntity(msg);
    }
}
