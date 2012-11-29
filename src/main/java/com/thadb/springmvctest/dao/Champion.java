package com.thadb.springmvctest.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import com.thadb.springmvctest.enums.ChampionType;
import com.thadb.springmvctest.enums.ItemType;



public class Champion {

	private List<Item> items = new CopyOnWriteArrayList<Item>();
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Champion(ChampionType c) {
		this.name = c.name();
		this.championType = c;
		this.displayName = c.getDisplayName();
		for(ItemType i : Arrays.asList(ItemType.values())){
			Item item = new Item(i);
			item.setSelected(false);
			items.add(item);
		}
	}
	
	public void addItem(String itemName){
		for (Item i : items){
			if(i.getName().equalsIgnoreCase(itemName)){
				if (getSelectedItemCount() < 6){
					i.setSelected(true);
				}
			}
		}
	}
	
	public int getSelectedItemCount() {
		return getSelectedItems().size();
	}

	public void deleteItem(String itemName){
		for (Item i : items){
			if(i.getName().equalsIgnoreCase(itemName)){
				i.setSelected(false);
			}
		}
	}

	
	
	@Override
	public String toString() {
		return this.getName();
	}


	@Override
	public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() != getClass())
            return false;

        Champion otherChamp = (Champion) obj;
        if (this.getName().equalsIgnoreCase(otherChamp.getName())){
        	return true;
        }else{
        	return false;
        }
	}


	private String name;
	private String displayName;
	private ChampionType championType;
	
	public String getDisplayName() {
		return displayName;
	}

	public String getFolderName(){
		String folderName = this.getDisplayName();
		if (this.championType == ChampionType.WUKONG){
			folderName = "MonkeyKing";
		}else{
			folderName = folderName.replace(" ", "");
			folderName = folderName.replace("'", "");
			folderName = folderName.replace(".", "");
		}
		return folderName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getSelectedItems() {
		List<Item> selectedItems = new CopyOnWriteArrayList<Item>();
		for (Item i:items){
			if (i.isSelected()){
				selectedItems.add(i);
			}
		}
		return selectedItems;
	}








	
	
}
