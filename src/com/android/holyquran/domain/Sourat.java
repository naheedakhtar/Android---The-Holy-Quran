package com.android.holyquran.domain;

import java.util.List;

public class Sourat {

	private Integer _id;
	private String name;
	private Integer numAyats;
	private List<Ayat> ayatList;

	public Sourat(Integer id, String name, String content, Integer numAyats, List<Ayat> ayatList) {
		super();
		_id = id;
		this.name = name;
		this.numAyats = numAyats;
		this.ayatList = ayatList;
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

	public Integer getNumAyats() {
		return numAyats;
	}

	public void setNumAyats(Integer numAyats) {
		this.numAyats = numAyats;
	}

	public List<Ayat> getAyatList() {
		return ayatList;
	}

	public void setAyatList(List<Ayat> ayatList) {
		this.ayatList = ayatList;
	}
	
	public String getAyats (){
		String text ="";
		for (Ayat ayat : ayatList) {
			text +=  ayat.getSouratId() + "." + ayat.getAyat() + ". " + ayat.getContent() + "\n" + "\n";
		}
		return text;
	}

}
