package backend.shai.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class DeletedMessage {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    private Message originalMessage;

    private final LocalDateTime deletedAt = LocalDateTime.now();

    private boolean deletedForEveryone;

    public Long getId() {
        return id;
    }

    public Message getOriginalMessage() {
        return originalMessage;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public boolean isDeletedForEveryone() {
        return deletedForEveryone;
    }

    public void setDeletedForEveryone(boolean deletedForEveryone) {
        this.deletedForEveryone = deletedForEveryone;
    }
}
