package com.switchfully.til.api.dto;

public class TilDTO {

    private String tid;
    private String temployee;
    private String til;

    public TilDTO(String tid, String temployee, String til) {
        this.tid = tid;
        this.temployee = temployee;
        this.til = til;
    }

    public String getTid() {
        return tid;
    }

    public String getTemployee() {
        return temployee;
    }

    public String getTil() {
        return til;
    }
}
