package com.switchfully.til.api.dto;

public class TilCreateDTO {

    private String ownerName;
    private String til;

    public TilCreateDTO(String ownerName, String til) {
        this.ownerName = ownerName;
        this.til = til;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getTil() {
        return til;
    }
}
