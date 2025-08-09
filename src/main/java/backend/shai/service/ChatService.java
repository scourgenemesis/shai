package backend.shai.service;


import backend.shai.model.Chat;
import backend.shai.model.User;
import backend.shai.repository.ChatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepo;

    @Transactional
    private Chat createChat(@RequestBody String chatName, Chat.ChatType type, Set<User> participants, String avatarUrl) {
        Chat chat = new Chat();
        chat.setName(chatName);
        chat.setParticipants(participants);
        chat.setType(type);
        chat.setAvatarUrl(avatarUrl);
        return chatRepo.save(chat);
    }
}
