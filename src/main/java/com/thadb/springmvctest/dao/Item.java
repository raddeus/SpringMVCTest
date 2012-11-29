package com.thadb.springmvctest.dao;

import com.thadb.springmvctest.enums.ItemType;

public class Item {

    private int itemCode;
    private String name;
    private String displayName;
    private boolean selected;
    
	public Item(ItemType i) {
		setName(i.name());
		setDisplayName(i.getDisplayName());
		setItemCode(i.getItemCode());
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
