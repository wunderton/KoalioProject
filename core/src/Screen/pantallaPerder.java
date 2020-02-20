 package Screen;

import Personajes.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import net.sekao.superkoalio.MyGdxGame;



/**
 *
 * @author Wunderton
 */
public class pantallaPerder implements Screen {
    MyGdxGame game;
    Texture fondo2;
    int puntos;
    
    OrthographicCamera camera;

    public pantallaPerder(MyGdxGame game, int puntos) {
        this.puntos  = puntos;
        fondo2 =  new Texture(Gdx.files.internal("game over.jpg"));
        this.game = game;

    camera = new OrthographicCamera();
    camera.setToOrtho(false, 800, 480);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(fondo2, 0, 0);
        game.font.draw(game.batch, "¡¡¡Has perdido!!! ", 100, 150);
        game.font.draw(game.batch, "Puntos: " + puntos, 100, 125);
        game.font.draw(game.batch, "¡Toca en cualquier lugar para volver a jugar!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
                game.setScreen(new World(game,puntos));
                dispose();
        }
    }

    @Override
    public void show() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resize(int width, int height) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
