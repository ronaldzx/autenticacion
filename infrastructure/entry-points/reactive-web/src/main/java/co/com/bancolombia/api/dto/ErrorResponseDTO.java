package co.com.bancolombia.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Error response for API operations")
public class ErrorResponseDTO {
    @Schema(example = "400", description = "Error code")
    private String code;

    @Schema(example = "Invalid email format", description = "Detailed error message")
    private String message;

    public ErrorResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
