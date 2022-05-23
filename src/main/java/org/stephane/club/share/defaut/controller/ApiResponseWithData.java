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
public class ApiResponseWithData extends ApiResponseMessage implements Serializable {

    private Object data;

    public ApiResponseWithData(ResponseCode responseCode, Object data) {
        super(responseCode);

        this.data = data;
    }
}
