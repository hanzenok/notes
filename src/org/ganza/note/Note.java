package org.ganza.note;

public class Note {
	
	private int _widgetid;
	private String _text;
	
	public Note(){
	}
	
	public Note(int widgetid, String text){
		
		_text = text;
		_widgetid = widgetid;
	}
	
	public void set_widgetid(int widgetid){
		
		_widgetid = widgetid;
	}
	
	public void set_text(String text){
		
		_text = text;
	}
	
	public int get_widgetid(){
		
		return _widgetid;
	}
	
	public String get_text(){
		
		return _text;
	}
}
