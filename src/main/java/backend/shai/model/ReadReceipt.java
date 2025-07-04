package backend.shai.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

public class ReadReceipt {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime readAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Message message;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public Message getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getReadAt() {
        return readAt;
    }

    public ReadReceipt(Message message, User user) {
        this.message = message;
        this.user = user;
    }
}