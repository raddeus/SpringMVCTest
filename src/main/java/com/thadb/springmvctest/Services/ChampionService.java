package com.thadb.springmvctest.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thadb.springmvctest.dao.Champion;
import com.thadb.springmvctest.enums.ChampionType;


@Service
public class ChampionService {
	private List<ChampionType> championTypes;
	private List<Champion> champions = new ArrayList<Champion>();
	

	public ChampionService(){
		championTypes = new ArrayList<ChampionType>(Arrays.asList(ChampionType.values()));
		for(ChampionType champType : championTypes){
			champions.add(new Champion(champType));
		}
	}
	
	public List<Champion> getChampions() {
		return champions;
	}

	public void setChampions(ArrayList<Champion> champions) {
		this.champions = champions;
	}
	
	public List<ChampionType> getChampionTypes() {
		return championTypes;
	}
	
	public void setChampionTypes(ArrayList<ChampionType> championTypes) {
		this.championTypes = championTypes;
	}


	

	
}
