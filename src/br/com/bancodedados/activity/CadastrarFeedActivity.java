package br.com.bancodedados.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.bancodedados.dao.FeedDao;
import br.com.bancodedados.model.Feed;

public class CadastrarFeedActivity extends Activity {
	private EditText title;
	private EditText subtitle;
	private EditText content;

	private Button cadastrar;
	private Button listar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar_feed);

		title = (EditText) findViewById(R.id.textTitle);
		subtitle = (EditText) findViewById(R.id.textSubTitle);
		content = (EditText) findViewById(R.id.textContent);
		cadastrar = (Button) findViewById(R.id.btnCadastrar);
		listar = (Button) findViewById(R.id.btnListar);
		
		cadastrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cadastrar();
			}
		});
		
		listar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(), ListarFeedActivity.class));
			}
		});
		
	}

	private void cadastrar() {
		FeedDao dao = new FeedDao(getBaseContext());
		Feed f = new Feed();
		f.setTitle(title.getText().toString());
		f.setSubtitle(subtitle.getText().toString());
		f.setContent(content.getText().toString());
		long id = dao.insert(f);

		if (id != -1) {
			Toast.makeText(this, "Registro inserido com sucesso! ID=" + id,
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Registro não pode ser inserido!",
					Toast.LENGTH_SHORT).show();
		}
	}
}
