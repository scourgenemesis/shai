package backend.shai.dto;

public class MessageDto {
    private Long senderId;
    private Long chatId;
    private String content;

    public MessageDto(Long senderId, Long chatId, String content) {
        this.senderId = senderId;
        this.chatId = chatId;
        this.content = content;
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
}
