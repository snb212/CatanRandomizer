package com.catan.objects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class TileDeck {

	private Tile[] tiles;
	// private Tile.Type[] resources;

	private Map<Tile.Type, Integer> resources = new HashMap();
	int[] numberToken = { 2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11,
			11, 12 };
	int[] tileLocation = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
			16, 17, 18, 19 };

	private int totalTiles;

	public TileDeck() {
		resources.put(Tile.Type.Brick, 3);
		resources.put(Tile.Type.Desert, 1);
		resources.put(Tile.Type.Ore, 3);
		resources.put(Tile.Type.Sheep, 4);
		resources.put(Tile.Type.Wheat, 4);
		resources.put(Tile.Type.Wood, 4);

		totalTiles = 0;

		for (Map.Entry<Tile.Type, Integer> resource : resources.entrySet()) {
			System.out.println(resource.getKey() + " : " + resource.getValue());
			totalTiles += resource.getValue();
		}

		System.out.println("Resources: " + resources.entrySet());
		System.out.println("Total Tiles: " + totalTiles);

		tiles = new Tile[totalTiles];

		// build initial tiles without number tokens or tile location
		int i = 0;
		int resourceTypeLeft;
		for (Tile.Type type : Tile.Type.values()) {

			resourceTypeLeft = resources.get(type);
			System.out.println(type);

			while (resourceTypeLeft - 1 >= 0) {

				tiles[i] = new Tile(type);
				resources.remove(type);
				resources.put(type, (resourceTypeLeft - 1));

				i++;
				resourceTypeLeft = resources.get(type);

			}
			System.out.println(resources.entrySet());
		}
	}

	// can probably abstract shuffle/shuffleArray to work for object arrays
	public void shuffle() {
		int randI;
		Tile temp;
		Random randIndex = new Random();

		for (int i = 0; i < totalTiles; i++) {

			// pick a random index between 0 and cardsInDeck - 1
			randI = randIndex.nextInt(totalTiles);

			// swap cards[i] and cards[newI]
			temp = tiles[i];
			tiles[i] = tiles[randI];
			tiles[randI] = temp;
		}
	}

	public void setNumberTokens(boolean shuffle) {
		if (shuffle) {
			this.shuffle();
		}

		// shuffle tiles
		shuffleArray(numberToken);
		System.out.println("number tokens shuffled");
		int count = 0;
		for (Tile tile : tiles) {
			if (tile.getResourceType() != Tile.Type.Desert) {
				tile.setNumberToken(numberToken[count]);
				count++;
			}
		}
	}

	public void setTileLocations(boolean shuffle) {
		if (shuffle) {
			this.shuffle();
		}

		// shuffle tiles
		shuffleArray(tileLocation);
		System.out.println("tile locations shuffled");
		int count = 0;
		for (Tile tile : tiles) {
			tile.setTileLocation(tileLocation[count]);
			count++;
		}

	}

	// implementation of the Fisher-Yates shuffle
	private void shuffleArray(int[] array) {
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);

			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}

	}

	public Tile[] getTiles() {
		return this.tiles;
	}
}
