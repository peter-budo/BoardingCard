package com.petermiklosko.wam;

import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity{

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        populateList();
    }

    private void populateList() {
        list = (ListView) findViewById(R.id.cards_list);
        BaseAdapter adapter = new CardListAdapter(this,fetchCards());
        list.setAdapter(adapter);
    }

    private List<BoardingCard> fetchCards() {
        return new ArrayList<BoardingCard>(){{
        add(new BusCard("Barcelona", "Gerona Airport", "No seat assigned"));
        add(new FlightCard("London", "New York", "SK22", "22", "7B", "Other message"));
        add(new FlightCard("Gerona Airport", "London", "SK455", "45B", "3A", "Some message here"));
        add(new TrainCard("Madrid", "Barcelona", "78A", "45B"));
        }};

    }
}
