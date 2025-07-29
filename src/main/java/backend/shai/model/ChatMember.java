package backend.shai.model;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Set;

@Entity
public class ChatMember {
    @Id private String id;
    @ManyToOne private Chat chat;
    @ManyToOne private User user;

    @ElementCollection
    private Set<Chat.ChatPermissions> permissions;

    public Set<Chat.ChatPermissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Chat.ChatPermissions> permissions) {
        this.permissions = permissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
