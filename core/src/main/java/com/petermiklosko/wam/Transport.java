package com.petermiklosko.wam;

public enum Transport {
    FLIGHT("flight"),
    BUS("bus"),
    TRAIN("train");

    private String description;

    Transport(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
