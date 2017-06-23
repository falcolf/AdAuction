package com.project.model;

public enum State {
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE");
	
	private String state;
	
	private State(final String state){
		this.state=state;
	}
	public String getState(){
		return this.state;
	}
	public String getName(){
		return this.name();
	}

}
