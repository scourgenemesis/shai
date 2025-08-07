package backend.shai.repository;


import backend.shai.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findByChatId(Long chatId, Pageable pageable);
    Page<Message> findByContentContainingIgnoreCase(Long chatId, String content, Pageable pageable);
    Page<Message> searchAllChats(String content, Pageable pageable);
    Page<Message> findByFileNameContaining(Long chatId, String filename);
}
