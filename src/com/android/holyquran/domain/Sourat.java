package com.android.holyquran.domain;

public class Sourat {

	Integer _id;
	String name;
	String content;
	Integer numAyats;

	public Sourat(Integer id, String name, String content, Integer numAyats) {
		super();
		_id = id;
		this.name = name;
		this.content = content;
		this.numAyats = numAyats;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer id) {
		_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getNumAyats() {
		return numAyats;
	}

	public void setNumAyats(Integer numAyats) {
		this.numAyats = numAyats;
	}

}
