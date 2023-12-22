package backend.presentationGeneration.main;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PresentationGenerationSetting {
    String gptModel;
    String genType;
    String template;
}
