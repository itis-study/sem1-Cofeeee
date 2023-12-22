package backend.bd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.RequestingUserName;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Presentation {
    UUID presentationId;
    UUID userId;
    String name;
    String folder_Id;
    String template_name;
    UUID requestPresentationId;
    Double cost;
    String status;
    String creationDate;
    String dataChange;
    List<Slide> slideList;
}
