package com.aizen.souske.request;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
