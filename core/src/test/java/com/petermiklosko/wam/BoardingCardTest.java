package com.petermiklosko.wam;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardingCardTest {

    private String departure = "Madrid";
    private String arrival = "Barcelona";
    private Transport transport = Transport.BUS;
    private String seatAssigned = "45B";
    private BoardingCard boardingCard = new BoardingCard(departure, arrival, transport, seatAssigned);

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
