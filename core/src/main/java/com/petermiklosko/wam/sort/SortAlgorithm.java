package com.petermiklosko.wam.sort;

import com.petermiklosko.wam.BoardingCard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SortAlgorithm {

    private List<BoardingCard> cards;
    private List<String> departures;
    private int departureIndex = -1;

    public SortAlgorithm(List<BoardingCard> cards) {
        this.cards = new ArrayList<BoardingCard>(cards);
    }

    public List<BoardingCard> sort() {
        List<BoardingCard> sortedCards = new ArrayList<BoardingCard>();
        do {
            BoardingCard card = cards.get(departureIndex);
            sortedCards.add(card);
            departureIndex = departures.lastIndexOf(card.getArrival());
        } while (departureIndex > -1);
        return sortedCards;
    }

    public boolean isFullJourney() {
        departures = new ArrayList<String>();
        List<String> arrivals = new ArrayList<String>();
        for (BoardingCard card : cards) {
            departures.add(card.getDeparture());
            arrivals.add(card.getArrival());
        }

        if (departures.size() != new HashSet<String>(departures).size() && arrivals.size() != new HashSet<String>(arrivals).size()) {
            return false;
        } else {
            List<String> noPairDepartures = new ArrayList<String>(departures);
            List<String> noPairArrivals = new ArrayList<String>(arrivals);

            noPairDepartures.removeAll(arrivals);
            noPairArrivals.removeAll(departures);
            departureIndex = departures.lastIndexOf(noPairDepartures.get(0));
            return noPairDepartures.size() == 1 && noPairArrivals.size() == 1;
        }
    }
}

