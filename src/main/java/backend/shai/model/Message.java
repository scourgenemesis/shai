package backend.shai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity(name = "message")
public class Message {
    private String content;
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private Chat chat;

    @ManyToOne
    private User recipient;
    private LocalDateTime timestamp;
    private MessageStatus MessageStatus;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public Chat getChat() {
        return chat;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public MessageStatus getMessageStatus() {
        return MessageStatus;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        MessageStatus = messageStatus;
    }

    public enum MessageStatus {
        SENT, DELIVERED, READ
    }
}
