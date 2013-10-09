package com.petermiklosko.wam;

public class BusCard extends BoardingCard {

    public BusCard(String departure, String arrival, String seatAssigned) {
        this(departure, arrival, Transport.BUS, seatAssigned);
    }

    private BusCard(String departure, String arrival, Transport transport, String seatAssigned) {
        super(departure, arrival, transport, seatAssigned);
    }

    @Override
    public String toString() {
        return new StringBuilder("Take ")
                .append(getTransport().toString())
                .append(" from ")
                .append(getDeparture())
                .append(" to ")
                .append(getArrival())
                .append(", seat ")
                .append(getSeatAssigned())
                .toString();
    }
}
