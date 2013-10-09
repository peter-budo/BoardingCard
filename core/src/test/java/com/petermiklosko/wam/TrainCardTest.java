package com.petermiklosko.wam;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrainCardTest {

    private String departure = "Madrid";
    private String arrival = "Barcelona";
    private Transport transport = Transport.TRAIN;
    private String trainNumber = "78A";
    private String seatAssigned = "45B";
    private TrainCard boardingCard = new TrainCard(departure, arrival, trainNumber, seatAssigned);

    @Test
    public void constructorShouldSetValues() {
        assertEquals(departure, boardingCard.getDeparture());
        assertEquals(arrival, boardingCard.getArrival());
        assertEquals(transport, boardingCard.getTransport());
        assertEquals(trainNumber, boardingCard.getTrainNumber());
        assertEquals(seatAssigned, boardingCard.getSeatAssigned());
    }

    @Test
    public void shouldReturnMatchingStringRepresentation() {
        String expected = "Take " + "train" + " " + trainNumber
                + " from " + departure
                + " to " + arrival
                + ". Sit in seat " + seatAssigned;

        assertEquals(expected, boardingCard.toString());
    }
}
