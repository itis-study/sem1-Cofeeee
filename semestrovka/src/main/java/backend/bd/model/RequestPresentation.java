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
public class RequestPresentation {
    UUID id;
    UUID userId;
    String template;
    String request;
    String numberOfSlide;
    String typeGeneration;
    UUID presentationUUID;
}
