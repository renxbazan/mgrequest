package com.renx.mg.request.model;

public enum RequestStatusType {
	PENDING("Pending"),DONE("Done");
	
	 private final String name;

	 RequestStatusType(String name) {
	    this.name = name;
	  }

	  public String getName() {
	    return name;
	  }
	
	
}
