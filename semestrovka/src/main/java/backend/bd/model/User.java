package backend.bd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    UUID id;
    String name;
    String description;
    String login;
    String password;
    String mail;
    String registrationDate;
    UUID pictureId;
    List<Presentation> presentationList;
}
