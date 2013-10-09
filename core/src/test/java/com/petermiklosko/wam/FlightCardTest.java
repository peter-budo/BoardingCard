package com.petermiklosko.wam;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightCardTest {

    private String departure = "Madrid";
    private String arrival = "Barcelona";
    private String flightNumber = "SK455";
    private Transport transport = Transport.FLIGHT;
    private String departureGate = "45B";
    private String seatAssigned = "3A";
    private String message = "Baggage drop at ticket counter 344.";
    private FlightCard boardingCard = new FlightCard(departure, arrival, flightNumber, departureGate, seatAssigned, message);

    @Test
    public void constructorShouldSetValues() {
        assertEquals(departure, boardingCard.getDeparture());
        assertEquals(arrival, boardingCard.getArrival());
        assertEquals(transport, boardingCard.getTransport());
        assertEquals(flightNumber, boardingCard.getFlightNumber());
        assertEquals(departureGate, boardingCard.getDepartureGate());
        assertEquals(seatAssigned, boardingCard.getSeatAssigned());
        assertEquals(message, boardingCard.getMessage());
    }

    @Test
    public void shouldReturnMatchingStringRepresentation() {
        String expected = "From " + departure
                + ", take " + Transport.FLIGHT + " " + flightNumber
                + " to " + arrival
                + ". Gate " + departureGate + ", seat " + seatAssigned
                + ". " + message;

        assertEquals(expected, boardingCard.toString());
    }
}
