package backend.shai.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class ChatInvitation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    private String token;

    private final LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime expiresAt;

    private boolean isUsed;

    public Long getId() {
        return id;
    }

    public Chat getChat() {
        return chat;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
