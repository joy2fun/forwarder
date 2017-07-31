package com.example.forwarder;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// $.$.$(); /* getIntent(); */
		setContentView(R.layout.activity_main);

		SharedPreferences prefs = getSharedPreferences(Config.ENDPOINT_NAME, MODE_PRIVATE);
		String savedUrl = prefs.getString("url", Config.ENDPOINT_URL);
		final SharedPreferences.Editor editor = prefs.edit();
		final EditText editUrl = (EditText) findViewById(R.id.link);
		editUrl.setText(savedUrl);

		editUrl.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				Log.i("EditText", editUrl.getText().toString());
				editor.putString("url", editUrl.getText().toString());
				editor.apply();
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

			public void onTextChanged(CharSequence s, int start, int before, int count) {}
		});
	}


}
