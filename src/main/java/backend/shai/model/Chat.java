package backend.shai.model;

public class Chat {
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private ChatType type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "chat_participants",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> participants = Collections.synchronizedSet(new HashSet<>());

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Message> messages = Collections.synchronizedSet(new HashSet<>());

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    private LocalDateTime createdAt;

    private String avatarUrl;

    private boolean isArchived;
    private String description;

    public enum ChatType {
        PRIVATE, GROUP, CHANNEL
    }
}
