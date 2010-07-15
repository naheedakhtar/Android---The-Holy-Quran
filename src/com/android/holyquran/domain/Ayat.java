package com.android.holyquran.domain;

public class Ayat {

	private Integer _id;
	private Integer id_sourat;
	private Integer ayat;
	private String content;

	public Ayat(Integer id, Integer souratId, Integer ayat, String content) {
		super();
		_id = id;
		id_sourat = souratId;
		this.ayat = ayat;
		this.content = content;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer id) {
		_id = id;
	}	

	public Integer getSouratId() {
		return id_sourat;
	}

	public void setSouratId(Integer idSourat) {
		id_sourat = idSourat;
	}

	public Integer getAyat() {
		return ayat;
	}

	public void setAyat(Integer ayat) {
		this.ayat = ayat;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
