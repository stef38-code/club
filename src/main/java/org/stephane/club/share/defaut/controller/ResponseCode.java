package org.stephane.club.share.defaut.controller;

import lombok.Getter;

@Getter
public enum ResponseCode {
    OK("00", "SUCCESS"), FAILED("01", "FAILED");
    private String key;
    private String title;

    ResponseCode(String key, String title) {
        this.key = key;
        this.title = title;
    }
}
