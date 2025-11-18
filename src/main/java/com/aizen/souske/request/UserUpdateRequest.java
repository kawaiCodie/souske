package com.aizen.souske.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
@Data
public class UserUpdateRequest {
    @Length(max =10,message="Username should not exceed 10 characters")
    private String userName;

    @Email(message = "Email must be valid and contain @")
    private String email;
}
