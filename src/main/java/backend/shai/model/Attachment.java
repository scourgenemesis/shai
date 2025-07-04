package backend.shai.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileKey;
    private String mimetype;
    private long fileSize;
    private LocalDateTime uploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private Message message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploader_id")
    private final User uploader;


    public Attachment (String filekey, String mimetype, long fileSize, Message message, User uploader) {
        this.fileKey = filekey;
        this.mimetype = mimetype;
        this.fileSize = fileSize;
        this.message = message;
        this.uploader = uploader;
    }

    public Long getId() {
        return id;
    }

    public String getFileKey() {
        return fileKey;
    }

    public String getMimetype() {
        return mimetype;
    }

    public long getFileSize() {
        return fileSize;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public Message getMessage() {
        return message;
    }

    public User getUploader() {
        return uploader;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
