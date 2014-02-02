package com.elementalgeeks.helloglass.v1;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Card card1 = new Card(this);
		card1.setText(R.string.hello_world);
		card1.setFootnote("@ykro");
		//View card1View = card1.toView();
				
		Card card2 = new Card(this);
		card2.setText("Con imagen de fondo");
		card2.setImageLayout(Card.ImageLayout.FULL);
		card2.addImage(R.drawable.ic_launcher);
		//View card2View = card2.toView();		
		
		Card card3 = new Card(this);
		card3.setText("So images. Such art. Amazing");
		card3.setImageLayout(Card.ImageLayout.LEFT);
		card3.addImage(R.drawable.eg);
		card3.addImage(R.drawable.culturaandroid);
		card3.addImage(R.drawable.gdg);
		//View card3View = card3.toView();		
			
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		
		CardScrollView scrollView = new CardScrollView(this);
		CustomCardScrollAdapter adapter = new CustomCardScrollAdapter(cards);
		scrollView.setAdapter(adapter);
		scrollView.activate();
		setContentView(scrollView);
	}

	class CustomCardScrollAdapter extends CardScrollAdapter {
		private ArrayList<Card> cards;
		public CustomCardScrollAdapter(ArrayList<Card> cards) {
			super();
			this.cards = cards;
		}
		
		@Override
		public int findIdPosition(Object arg0) {
			return -1;
		}

		@Override
		public int findItemPosition(Object arg0) {
			return cards.indexOf(arg0);
		}

		@Override
		public int getCount() {
			return cards.size();
		}

		@Override
		public Object getItem(int arg0) {
			return cards.get(arg0);
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			return cards.get(arg0).toView();
		}
		
	}
}
