package backend.bd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Slide {
    UUID id;
    UUID presentationID;
    String title;
    String text;
    List<String> imgIdList;
    String setting;
    int numSlide;

}
