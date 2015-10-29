package org.ganza.note;

public class Note {
	
	private int _id;
	private String _text;
	
	public Note(){
	}
	
	public Note(int id, String text){
		
		_text = text;
		_id = id;
	}
	
	public void setId(int id){
		
		_id = id;
	}
	
	public void seText(String text){
		
		_text = text;
	}
	
	public int getId(){
		
		return _id;
	}
	
	public String getText(){
		
		return _text;
	}
}
