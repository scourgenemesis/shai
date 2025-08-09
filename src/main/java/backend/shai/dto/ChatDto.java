package backend.shai.dto;

import java.util.List;

public class ChatDto {
    private String name;
    private String type;
    private List<Long> userIds;

    private ChatDto(String name, String type, List<Long> userIds) {
        this.name = name;
        this.type = type;
        this.userIds = userIds;
    }
}