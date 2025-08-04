package backend.shai.dto;

import backend.shai.model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;


@Data
public class MessageDto {
    @Getter
    private String sender;
    @Getter
    private Long senderId;
    private Long chatId;
    private String content;
    private LocalDateTime timestamp;

    public MessageDto(String username, Long senderId, Long id1, String content, LocalDateTime timestamp) {

    }

    public static MessageDto fromEntity(Message msg) {
        return new MessageDto(msg.getSender().getUsername(), msg.getSender().getId(), msg.getChat().getId(), msg.getContent(), msg.getTimestamp());
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
