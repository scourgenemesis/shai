package backend.shai.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Attachment {
    @Id
    @GeneratedValue
    private Long id;

    private String fileUrl;
    private String mimetype;
    private long fileSize;
    private LocalDateTime uploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private Message message;
}
