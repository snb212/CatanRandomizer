package com.catan;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CatanRandomizer extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		
		font = new BitmapFont();
		font.setColor(Color.WHITE);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		String message = "Testing 123";
		TextBounds txt = font.getBounds(message);
		
		font.draw(batch, Float.toString(txt.width), Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/4);
		
		System.out.println("Actual height: " + Gdx.graphics.getWidth() + " : " + Gdx.graphics.getHeight());
		System.out.println("Adjusted height: " + (Gdx.graphics.getWidth() - txt.width) + " : " + (Gdx.graphics.getHeight() - txt.height));
		System.out.println("Txt loc: " + ((Gdx.graphics.getWidth()/2) - txt.width) + " : " + ((Gdx.graphics.getHeight()/2) - txt.height ));
		font.draw(batch, message, (Gdx.graphics.getWidth()/2) - txt.width, (Gdx.graphics.getHeight()/2) - txt.height );
		//batch.draw(img, 0, 0);
		batch.end();
	}
}
