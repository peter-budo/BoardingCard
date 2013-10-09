package com.petermiklosko.wam.sort;

import com.petermiklosko.wam.BoardingCard;
import com.petermiklosko.wam.BusCard;
import com.petermiklosko.wam.FlightCard;
import com.petermiklosko.wam.TrainCard;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class SortAlgorithmTest {

    private final BusCard busCard = new BusCard("Barcelona", "Gerona Airport", "No seat assigned");
    private final FlightCard flightCardNY = new FlightCard("London", "New York", "SK22", "22", "7B", "Other message");
    private final FlightCard flightCardLon = new FlightCard("Gerona Airport", "London", "SK455", "45B", "3A", "Some message here");
    private final TrainCard trainCard = new TrainCard("Madrid", "Barcelona", "78A", "45B");
    private List<BoardingCard> list = new ArrayList<BoardingCard>();

    @Before
    public void setUp() throws Exception {
        list.add(busCard);
        list.add(flightCardNY);
        list.add(flightCardLon);
        list.add(trainCard);
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void tripShouldByFullJourney() {
        SortAlgorithm sort = new SortAlgorithm(list);
        assertTrue(sort.isFullJourney());
    }

    @Test
    public void tripShouldBeBrokenJourney() {
        list.add(busCard);
        SortAlgorithm sort = new SortAlgorithm(list);
        assertEquals(false, sort.isFullJourney());
    }

    @Test
    public void shouldSortBoardingCards() {
        SortAlgorithm sort = new SortAlgorithm(list);
        sort.isFullJourney();
        List<BoardingCard> sortedList = sort.sort();
        assertTrue(sortedList.get(0).getDeparture().equals("Madrid") && sortedList.get(0).getArrival().equals("Barcelona"));
        assertTrue(sortedList.get(1).getDeparture().equals("Barcelona") && sortedList.get(1).getArrival().equals("Gerona Airport"));
        assertTrue(sortedList.get(2).getDeparture().equals("Gerona Airport") && sortedList.get(2).getArrival().equals("London"));
        assertTrue(sortedList.get(3).getDeparture().equals("London") && sortedList.get(3).getArrival().equals("New York"));
    }
}
