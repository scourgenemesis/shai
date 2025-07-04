package backend.shai.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class PinnedMessage {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Message message;

    @ManyToOne(fetch = FetchType.LAZY)
    private User pinnedBy;

    private LocalDateTime pinnedAt;

    private LocalDateTime expiresAt;

    public Long getId() {
        return id;
    }

    public Message getMessage() {
        return message;
    }

    public LocalDateTime getPinnedAt() {
        return pinnedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
