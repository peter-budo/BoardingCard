package com.petermiklosko.wam;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusCardTest {

    private String departure = "Barcelona";
    private String arrival = "Gerona Airport";
    private Transport transport = Transport.BUS;
    private String seatAssigned = "45";
    private BusCard boardingCard = new BusCard(departure, arrival, seatAssigned);

    @Test
    public void constructorShouldSetValues() {
        assertEquals(departure, boardingCard.getDeparture());
        assertEquals(arrival, boardingCard.getArrival());
        assertEquals(transport, boardingCard.getTransport());
        assertEquals(seatAssigned, boardingCard.getSeatAssigned());
    }

    @Test
    public void shouldReturnMatchingStringRepresentation() {
        String expected = "Take " + "bus" + " from " + departure + " to " + arrival + ", seat " + seatAssigned;

        assertEquals(expected, boardingCard.toString());
    }
}
