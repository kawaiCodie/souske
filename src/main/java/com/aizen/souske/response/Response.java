package com.aizen.souske.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String status;
    private Object data;
}
