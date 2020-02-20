package net.sekao.superkoalio;

import Screen.PantallaInicial;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Personajes.World;

public class MyGdxGame extends Game {
    public SpriteBatch batch;
    public BitmapFont font;
    

    @Override
    public void create() {
        int puntos = 0;
        batch = new SpriteBatch();
    font = new BitmapFont();
        this.setScreen(new PantallaInicial(this));
    }

    @Override
    public void render () {
    super.render();
    }

    @Override
    public void dispose () {
    batch.dispose();
        font.dispose();
    }
}
