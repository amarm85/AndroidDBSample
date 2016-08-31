package com.example.dbapp4.model;



public abstract class Model {

	private long _id;
	
	public Model(){}
	
	public Model(long _id) {
		super();
		this._id = _id;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		this._id = id;
	}
	
	
	
	
}
