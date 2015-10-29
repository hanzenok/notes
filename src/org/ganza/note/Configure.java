package org.ganza.note;

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
	
	private int widgetID;
	
	private AppWidgetManager widgetManager;
	private RemoteViews views;
	
	private EditText editText;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configure);
		setResult(RESULT_CANCELED);
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			
			widgetID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
			
			widgetManager = AppWidgetManager.getInstance(this);
			views = new RemoteViews(this.getPackageName(), R.layout.widget);
			
			editText = (EditText) findViewById(R.id.editText1);
			button = (Button) findViewById(R.id.button1);
			button.setOnClickListener(new OnClickListener(){
				
				@Override
				public void onClick(View v){
					
					views.setTextViewText(R.id.widget_textview, editText.getText().toString());
					
					widgetManager.updateAppWidget(widgetID, views);
					
					Intent resultValue = new Intent();
					resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
					setResult(RESULT_OK, resultValue);
					
					finish();
				}
			});
			
		}
	}
}
