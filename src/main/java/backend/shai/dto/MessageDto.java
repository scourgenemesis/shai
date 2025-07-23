package backend.shai.dto;

import backend.shai.model.Message;

import java.time.LocalDateTime;

public class MessageDto {
    private Long senderId;
    private Long chatId;
    private String content;
    private LocalDateTime timestamp;

    public MessageDto(Long senderId, Long chatId, String content, LocalDateTime timestamp) {
        this.senderId = senderId;
        this.chatId = chatId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public static MessageDto fromEntity(Message msg) {
        MessageDto dto = new MessageDto();
        dto
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
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
