package com.example.hellol10n;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// assign flag.png to the button, loading correct flag image for current locale
		Button b = (Button) findViewById(R.id.flag_button);
		b.setBackground(this.getResources().getDrawable(R.drawable.flag));

		// build dialog box to display when user clicks the flag
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.dialog_text)
				.setCancelable(false)
				.setTitle(R.string.dialog_title)
				.setPositiveButton("Done",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();
							}
						});
		final AlertDialog alert = builder.create();

		// set click listener on the flag to show the dialog box
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				alert.show();
			}
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
