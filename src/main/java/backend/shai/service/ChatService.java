package backend.shai.service;


import backend.shai.model.Chat;
import backend.shai.repository.ChatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepo;

    @Transactional
    private Chat createChat(@RequestBody String chatName, String type) {
        chatRepo
    }
}
