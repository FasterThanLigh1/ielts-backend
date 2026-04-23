package com.fasterthanligh1.ielts_backend.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(name = "RegisterRequest", description = "Payload for registering a new user")
public record RegisterRequest(

        @Schema(description = "Valid email address", example = "test@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @Email(message = "Email should be valid")
        String email,

        @Schema(description = "Password must be at least 9 characters long and contain at least one special character", example = "SuperS3cret!", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @Size(min = 9, message = "Password must be more than 8 characters")
        @Pattern(
                regexp = "^(?=.*[!@#$%^&*(),.?\":{}|<>]).*$",
                message = "Password must contain at least one special character"
        )
        String password,

        @Schema(description = "User's first name, letters only", example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
        String firstName,

        @Schema(description = "User's last name, letters only", example = "Doe", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters")
        String lastName
) {
}