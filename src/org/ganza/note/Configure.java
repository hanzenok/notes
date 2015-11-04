package org.ganza.note;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class Configure extends Activity {
	
	private int widgetId;
	
	private AppWidgetManager widgetManager;
	private RemoteViews views;
	
	private EditText editText;
	private Button button;
	
	private NotesDBHandler dbHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configure);
		
		setResult(RESULT_CANCELED);
		dbHandler = new NotesDBHandler(this, null, null, 0);
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			
			widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
			System.out.println("(Configure.java)widget ID: " + widgetId);
			widgetManager = AppWidgetManager.getInstance(this);
			views = new RemoteViews(this.getPackageName(), R.layout.widget);
			
			editText = (EditText) findViewById(R.id.editText1);
			button = (Button) findViewById(R.id.button1);
			button.setOnClickListener(new OnClickListener(){
				
				@Override
				public void onClick(View v){
					
					Note note = new Note(widgetId, editText.getText().toString());
					dbHandler.addNote(note);
					
					views.setTextViewText(R.id.widget_textview, note.getText());
					
					widgetManager.updateAppWidget(widgetId, views);
					
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
					setResult(RESULT_OK, resultValue);
					
					finish();
				}
			});
			
		}
	}
}
