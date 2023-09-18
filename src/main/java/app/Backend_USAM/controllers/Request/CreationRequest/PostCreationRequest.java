package app.Backend_USAM.controllers.Request.CreationRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
public class PostCreationRequest {
    private String postTitle;
    private String postContent;
    private int ownerId;
}
