package com.heilos.degister;

public class Area {
	private String idBak;
	private String name;
	private String areaType;
	private int parentId;
	private int ordering;
	private String zip;

	private String phoneArea;

	public int getOrdering() {
		return ordering;
	}

	public void setOrdering(int ordering) {
		this.ordering = ordering;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}


	public String getIdBak() {
		return idBak;
	}

	public void setIdBak(String idBak) {
		this.idBak = idBak;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneArea() {
		return phoneArea;
	}

	public void setPhoneArea(String phoneArea) {
		this.phoneArea = phoneArea;
	}

	@Override
	public String toString() {
		return "id= " + this.getIdBak() + " name=" + this.getName() + " areaType=" + this.getAreaType() + " parentId="
				+ this.getParentId() + " ordering=" + this.getOrdering() + " zip=" + this.getZip() +"\n";
	}
}
