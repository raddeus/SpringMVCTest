package com.thadb.springmvctest.dao;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.thadb.springmvctest.enums.ChampionType;

public class User {

	private List<Champion> selectedChamps = new CopyOnWriteArrayList<Champion>();
	private List<Champion> availableChamps = new CopyOnWriteArrayList<Champion>();
	
	
	public User(){
		for (ChampionType c : Arrays.asList(ChampionType.values())){
			Champion champ = new Champion(c);
			availableChamps.add(champ);
		}
		
		
	}
	public List<Champion> getSelectedChamps() {
		return selectedChamps;
	}

	public void setSelectedChamps(List<Champion> selectedChamps) {
		this.selectedChamps = selectedChamps;
	}
	


	public boolean isChampSelected(String champName) {
		for (Champion c : selectedChamps){
			if(c.getName().equalsIgnoreCase(champName)){
				return true;
			}
		}
		return false;
	}

	public List<Champion> getAvailableChamps() {
		return availableChamps;
	}

	public void setAvailableChamps(List<Champion> availableChamps) {
		this.availableChamps = availableChamps;
	}

	public void deleteChamp(String champName) {
		for (Champion c : selectedChamps){
			if(c.getName().equalsIgnoreCase(champName)){
				availableChamps.add(c);
				selectedChamps.remove(c);
			}
		}
	}

	public void addChamp(String champName) {
		for (Champion c : availableChamps){
			if(c.getName().equalsIgnoreCase(champName)){
				availableChamps.remove(c);
				selectedChamps.add(c);
			}
		}
		
	}
	public Champion getChamp(String champName) {
		for (Champion c : selectedChamps){
			if(c.getName().equalsIgnoreCase(champName)){
				return c;
			}
		}
		return null;
	}
	
	public Champion getAvailableChamp(String champName) {
		for (Champion c : availableChamps){
			if(c.getName().equalsIgnoreCase(champName)){
				return c;
			}
		}
		return null;
	}
	
}
