package com.catan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.catan.objects.Tile;
import com.catan.objects.TileDeck;


public class BoardBuilder {

	private Map<Integer, List> neighborIndex = new HashMap();
	
	//create a new deck
	TileDeck deck = new TileDeck();
	
	public BoardBuilder(){
		
		//build neighbor tile relationships
		neighborIndex.put(1, Arrays.asList(12, 13, 2));
		neighborIndex.put(2, Arrays.asList(1, 3, 13, 14));
		neighborIndex.put(3, Arrays.asList(2, 14, 4));
		neighborIndex.put(4, Arrays.asList(3, 14, 15, 5));
		neighborIndex.put(5, Arrays.asList(4, 15, 6));
		neighborIndex.put(6, Arrays.asList(5, 15, 16, 7));
		neighborIndex.put(7, Arrays.asList(16, 8, 6));
		neighborIndex.put(8, Arrays.asList(16, 17, 19));
		neighborIndex.put(9, Arrays.asList(10, 17, 18));
		neighborIndex.put(10, Arrays.asList(11, 18, 17, 9));
		neighborIndex.put(11, Arrays.asList(12, 10, 18));
		neighborIndex.put(12, Arrays.asList(11, 18, 1, 13));
		neighborIndex.put(13, Arrays.asList(1, 2, 14, 19, 18, 12));
		neighborIndex.put(14, Arrays.asList(2, 3, 4, 15, 19, 13));
		neighborIndex.put(15, Arrays.asList(4, 5, 6, 16, 19, 14));
		neighborIndex.put(16, Arrays.asList(19, 15, 6, 7, 8, 17));
		neighborIndex.put(17, Arrays.asList(8, 9, 10, 18, 19, 16));
		neighborIndex.put(18, Arrays.asList(17, 10, 11, 12, 13, 19));
		neighborIndex.put(19, Arrays.asList(13, 14, 15, 16, 17, 18));
		
		//shuffle tiles
		deck.shuffle();
		
		
		//Choose a resource type
		
		//set the number tokens
		deck.setNumberTokens(true);
		
		//place the tile on the board
		deck.setTileLocations(true);
		
		for(Tile tile : deck.getTiles()){
			System.out.println(tile);
		}
	}
	
	
	//returns null if no file is found
	public Tile getTileAtLocation(int loc){
		Tile[] tiles = deck.getTiles();
//		Tile tile = new Tile(null); 
		
		for(Tile tile : tiles){
			if(tile.getTileLocation() == loc){
				return tile;
			}
		}
		
		return null;
	}
	
}
