package backend.shai.service;


import backend.shai.dto.MessageDto;
import backend.shai.model.Message;
import backend.shai.repository.ChatRepository;
import backend.shai.repository.MessageRepository;
import backend.shai.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Autowired
    private MessageDto dto;


    @Transactional
    public MessageDto sendMessage(MessageDto messageDto) {
        Message msg = new Message();
        msg.setContent(dto.getContent());
        msg.setTimestamp(LocalDateTime.now());
        msg = messageRepo.save(msg);
        return MessageDto.fro
    }


    @Transactional
    public Message getMessages(MessageDto messageDto) {

    }
}
