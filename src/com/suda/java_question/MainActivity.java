package com.suda.java_question;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question);

		String[] title = getResources().getStringArray(R.array.title);

		ListView listView = (ListView) findViewById(R.id.que);

		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, title);

		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent intent = new Intent(MainActivity.this, Main.class);
				Bundle bundle = new Bundle();

				bundle.putInt("typeId", position);

				intent.putExtras(bundle);
				startActivity(intent);
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 1, "����");
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 1) {
			AlertDialog.Builder ad = new AlertDialog.Builder(this);
			ad.setMessage("��������Suda����\n��Ŀ����Դ�ڻ�����");
			ad.setPositiveButton("ȷ��", null);
			ad.show();
		}
		return super.onOptionsItemSelected(item);
	}
}
