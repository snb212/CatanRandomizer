package com.catan.objects;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tile {
	
	public enum Type {Brick, Ore, Sheep, Wheat, Wood, Desert}
	
	private Map neighborIndex = new HashMap(); 
	
	private Type resourceType;
	private int tileLocation; 
	private int numberToken;
	private Set neighborTiles = new HashSet();
	
	public Tile(){
	}
	
	public Tile(Type resourceType){
		this.resourceType = resourceType;
		//this.diceRoll = diceRoll;
	}

	private Collection getNeighbors(int tileLocation2) {
		
		return null;
	}

	public Type getResourceType() {
		return resourceType;
	}

	public void setResourceType(Type resourceType) {
		this.resourceType = resourceType;
	}

	public int getTileLocation() {
		return tileLocation;
	}

	public void setTileLocation(int tileLocation) {
		this.tileLocation = tileLocation;
	}

	public int getNumberToken() {
		return numberToken;
	}

	public void setNumberToken(int diceRoll) {
		this.numberToken = diceRoll;
	}

	public Set getNeighborTiles() {
		return neighborTiles;
	}

	public void setNeighborTiles(Set neighborTiles) {
		this.neighborTiles = neighborTiles;
	}
	
	@Override
	public String toString(){
		String output = "Tile: resource - " + this.resourceType;
		
		if(Integer.valueOf(numberToken) != null){
			output += " - roll - " + numberToken;
		}
		
		if(Integer.valueOf(tileLocation) != null){
			output += " - loc - " + tileLocation;
		}
		
		return output;
	}
}
