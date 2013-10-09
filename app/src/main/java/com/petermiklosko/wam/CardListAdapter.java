package com.petermiklosko.wam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CardListAdapter extends BaseAdapter {

    private final Context context;
    private final List<BoardingCard> cards;

    public CardListAdapter(Context context, List<BoardingCard> cards) {
        this.context = context;
        this.cards = cards;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.boarding_card_item, parent, false);
        TextView transportType = (TextView) view.findViewById(R.id.transportation_type);
        TextView departure = (TextView) view.findViewById(R.id.departure);
        TextView arrival = (TextView) view.findViewById(R.id.arrival);

        transportType.setText(cards.get(position).getTransport().toString());
        departure.setText(cards.get(position).getDeparture());
        arrival.setText(cards.get(position).getArrival());
        return view;
    }
}
