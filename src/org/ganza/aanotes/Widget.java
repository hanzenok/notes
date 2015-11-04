package org.ganza.aanotes;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class Widget extends AppWidgetProvider {

	private RemoteViews views;
	private NotesDBHandler dbHandler;
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
	
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		dbHandler = new NotesDBHandler(context, null, null, 0);
		
		int i, widgetId, n=appWidgetIds.length;
		
		for(i=0; i<n; i++){
			
			widgetId = appWidgetIds[i];
			Note note = dbHandler.getNote(widgetId);
			
			views = new RemoteViews(context.getPackageName(), R.layout.widget);
			views.setTextViewText(R.id.widget_textview, note.getText());
			
			appWidgetManager.updateAppWidget(widgetId, views);
		}
		
	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		
		super.onDeleted(context, appWidgetIds);
		dbHandler = new NotesDBHandler(context, null, null, 0);
		
		int i, widgetId, n=appWidgetIds.length;
		
		for(i=0; i<n; i++){
			
			widgetId = appWidgetIds[i];
			dbHandler.deleteNote(widgetId);
		}
	}

}
