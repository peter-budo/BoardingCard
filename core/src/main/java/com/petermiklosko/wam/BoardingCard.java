package com.petermiklosko.wam;

public abstract class BoardingCard {

    private final String departure;
    private final String arrival;
    private final Transport transport;
    private final String seatAssigned;

    public BoardingCard(String departure, String arrival, Transport transport, String seatAssigned) {
        this.departure = departure;
        this.arrival = arrival;
        this.transport = transport;
        this.seatAssigned = seatAssigned;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public Transport getTransport() {
        return transport;
    }

    public String getSeatAssigned() {
        return seatAssigned;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
