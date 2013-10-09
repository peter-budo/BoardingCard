package com.petermiklosko.wam;

public class FlightCard extends BoardingCard {

    private String flightNumber;
    private String departureGate;
    private String message;

    public FlightCard(String departure, String arrival, String flightNumber, String departureGate, String seatAssigned, String message) {
        this(departure, arrival, Transport.FLIGHT, seatAssigned);
        this.flightNumber = flightNumber;
        this.departureGate = departureGate;
        this.message = message;
    }

    private FlightCard(String departure, String arrival, Transport transport, String seatAssigned) {
        super(departure, arrival, transport, seatAssigned);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureGate() {
        return departureGate;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return new StringBuilder("From " + getDeparture())
                .append(", take " + getTransport().toString() + " " + flightNumber)
                .append(" to " + getArrival())
                .append(". Gate " + departureGate + ", seat " + getSeatAssigned())
                .append(". " + message)
                .toString();
    }
}
