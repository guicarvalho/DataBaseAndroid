package br.com.bancodedados.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.bancodedados.dao.FeedDao;
import br.com.bancodedados.model.Feed;

public class ListarFeedActivity extends Activity {
	private ListView listFeed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listar_feed);
		
		FeedDao dao = new FeedDao(this);
		List<String> objects = new ArrayList<String>();
		
		for (Feed f : dao.selectAll()) {
			objects.add(f.getTitle());
		}
		
		listFeed = (ListView) findViewById(R.id.listFeed);
		listFeed.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, objects));
	}
}
