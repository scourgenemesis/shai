package backend.shai.service;


import backend.shai.dto.MessageDto;
import backend.shai.model.Message;
import backend.shai.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepo;

    public Message sendMessage(MessageDto messageDto) {

    }

    public Message getMessages(MessageDto messageDto) {
        
    }
}
