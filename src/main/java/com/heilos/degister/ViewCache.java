package com.heilos.degister;

import java.util.ArrayList;
import java.util.List;

public class ViewCache {
	private List<Area> areaList =new ArrayList<Area>();

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	// 供Digester调用的方法
	public void addArea(Area area) {
		this.areaList.add(area);
	}

	@Override
	public String toString() {
		return "ViewCache:" + areaList;
	}
}