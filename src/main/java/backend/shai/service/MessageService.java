package backend.shai.service;


import backend.shai.dto.MessageDto;
import backend.shai.model.Message;
import backend.shai.repository.ChatRepository;
import backend.shai.repository.MessageRepository;
import backend.shai.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageRepository messageRepo;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSocketService webSocketService;

    public Message sendMessage(MessageDto messageDto) {

    }

    public Message getMessages(MessageDto messageDto) {
        
    }
}
