package org.ganza.note;

public class Note {
	
	private int _id;
	private String _text;
	
	public Note(){
		
		_id = -1;
		_text = "";
	}
	
	public Note(int id, String text){
		
		_text = text;
		_id = id;
	}
	
	public void setId(int id){
		
		_id = id;
	}
	
	public void setText(String text){
		
		_text = text;
	}
	
	public int getId(){
		
		return _id;
	}
	
	public String getText(){
		
		return _text;
	}
}
