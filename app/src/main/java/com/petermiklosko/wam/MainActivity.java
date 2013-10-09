package com.petermiklosko.wam;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.petermiklosko.wam.sort.SortAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

    private ListView list;
    private List<BoardingCard> cards;
    private Button sortBtn;
    private View.OnClickListener sortListener;
    private TextView sortingMsg;
    private SortAlgorithm sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        populateList();
        sortListener();
        sortButton();
        sortingMsg = (TextView) findViewById(R.id.sorting_message);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                refreshScreen();
        }
        return super.onOptionsItemSelected(item);
    }

    private void refreshScreen() {
        sortingMsg.setTextColor(getResources().getColor(R.color.white));
        sortingMsg.setText(getResources().getText(R.string.unsorted_msg));
        sortBtn.setVisibility(View.VISIBLE);
        populateList();
    }

    private void populateList() {
        if (list == null) {
            list = (ListView) findViewById(R.id.cards_list);
        }
        cards = fetchCards();
        list.setAdapter(getAdapter(cards));
    }

    private void sortButton() {
        sortBtn = (Button) findViewById(R.id.sort_button);
        sortBtn.setOnClickListener(sortListener);
    }

    private void sortListener() {
        sortListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort = new SortAlgorithm(cards);
                if (sort.isFullJourney()) {
                    sortCards();
                } else {
                    sortingMsg.setTextColor(Color.RED);
                    sortingMsg.setText(getResources().getText(R.string.broken_journey_msg));
                }
            }
        };
    }

    private BaseAdapter getAdapter(List<BoardingCard> list) {
        return new CardListAdapter(this, list);
    }

    private List<BoardingCard> fetchCards() {
        return new Random().nextInt(100) % 2 == 0 ? fullJourney() : brokenJourney();
    }

    private void sortCards() {
        cards = new ArrayList<BoardingCard>(sort.sort());
        list.setAdapter(getAdapter(cards));
        sortBtn.setVisibility(View.GONE);
        sortingMsg.setText(getResources().getText(R.string.sorted_msg));
    }

    private List<BoardingCard> fullJourney() {
        return new ArrayList<BoardingCard>() {{
            add(new BusCard("Barcelona", "Gerona Airport", "No seat assigned"));
            add(new FlightCard("London", "New York", "SK22", "22", "7B", "Other message"));
            add(new FlightCard("Gerona Airport", "London", "SK455", "45B", "3A", "Some message here"));
            add(new TrainCard("Madrid", "Barcelona", "78A", "45B"));
        }};
    }

    private List<BoardingCard> brokenJourney() {
        return new ArrayList<BoardingCard>() {{
            add(new BusCard("Barcelona", "Madrid", "No seat assigned"));
            add(new BusCard("Barcelona", "Gerona Airport", "No seat assigned"));
            add(new FlightCard("London", "New York", "SK22", "22", "7B", "Other message"));
            add(new FlightCard("Gerona Airport", "London", "SK455", "45B", "3A", "Some message here"));
            add(new TrainCard("Madrid", "Barcelona", "78A", "45B"));
        }};
    }
}
