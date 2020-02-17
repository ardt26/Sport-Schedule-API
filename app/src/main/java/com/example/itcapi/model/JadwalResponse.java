package com.example.itcapi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class JadwalResponse{

	@SerializedName("events")
	private List<EventsItem> events;

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}

	@Override
 	public String toString(){
		return 
			"JadwalResponse{" + 
			"events = '" + events + '\'' + 
			"}";
		}
}