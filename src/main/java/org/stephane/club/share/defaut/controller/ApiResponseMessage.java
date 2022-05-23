package org.stephane.club.share.defaut.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ApiResponseMessage implements Serializable {
    private String code;
    private String message;

    public ApiResponseMessage(ResponseCode responseCode) {
        this.code = responseCode.getKey();
        this.message = responseCode.getTitle();
    }

    public ApiResponseMessage(ResponseCode responseCode, String message) {
        this.code = responseCode.getKey();
        this.message = message;
    }
}
