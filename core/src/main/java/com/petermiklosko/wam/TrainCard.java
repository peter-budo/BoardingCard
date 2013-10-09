package com.petermiklosko.wam;

public class TrainCard extends BoardingCard {

    private String trainNumber;

    public TrainCard(String departure, String arrival, String trainNumber, String seatAssigned) {
        this(departure, arrival, Transport.TRAIN, seatAssigned);
        this.trainNumber = trainNumber;
    }

    private TrainCard(String departure, String arrival, Transport transport, String seatAssigned) {
        super(departure, arrival, transport, seatAssigned);
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    @Override
    public String toString() {
        return new StringBuilder("Take " + getTransport().toString() + " " + getTrainNumber())
                .append(" from " + getDeparture())
                .append(" to " + getArrival())
                .append(". Sit in seat " + getSeatAssigned())
                .toString();
    }
}