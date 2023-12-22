package backend.bd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    UUID commentId;
    UUID authorId;
    String comment;
    UUID presentation;
    String statusUser;
}
