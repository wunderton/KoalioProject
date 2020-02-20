/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Personajes.Koala;
import Personajes.KoalaMalo;
import Personajes.KoalaMaloSaltador;
import Personajes.KoalaMaloSaltadorRapido;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import net.sekao.superkoalio.MyGdxGame;
import Screen.PantallaGanar2;
import Screen.pantallaPerder;

/**
 *
 * @author Wunderton
 */
public class World2 implements Screen{
    Stage stage;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;
    Koala koala;
    int vidas = 100;
    int puntos;
    KoalaMalo koalaMalo;
    KoalaMalo koalaMalo2;
    KoalaMaloSaltador koalaSaltador;
    KoalaMaloSaltadorRapido koalaSaltador2;
    KoalaMaloSaltador koalaSaltador3;
    KoalaMaloSaltadorRapido koalaSaltador4;
    KoalaMaloSaltador koalaSaltador5;
    MyGdxGame game;
    Music music_level2;

    public World2 (MyGdxGame game, int puntos) {
        this.game=game;
        this.puntos = puntos;
    }

    public void show() {
        map = new TmxMapLoader().load("level1.tmx");
        final float pixelsPerTile = 16;
        renderer = new OrthogonalTiledMapRenderer(map, 1 / pixelsPerTile);
        camera = new OrthographicCamera();

        stage = new Stage();
        stage.getViewport().setCamera(camera);
        
        music_level2 = Gdx.audio.newMusic(Gdx.files.internal("level2.ogg"));
        music_level2.setLooping(true);
        music_level2.play();

        koala = new Koala(game);
        koala.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koala.layer2 = (TiledMapTileLayer) map.getLayers().get("puntos");
        koala.layer3 = (TiledMapTileLayer) map.getLayers().get("final");
        koala.layer4 = (TiledMapTileLayer) map.getLayers().get("final2");
        koala.layer5 = (TiledMapTileLayer) map.getLayers().get("velocidad");
        koala.setPosition(10, 10);
        stage.addActor(koala);
        
        koalaMalo = new KoalaMalo();
        koalaMalo.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo.setPosition(41, 2);
        stage.addActor(koalaMalo);
        
        koalaMalo2 = new KoalaMalo();
        koalaMalo2.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo2.setPosition(60, 2);
        stage.addActor(koalaMalo2);
        
        koalaSaltador = new KoalaMaloSaltador();
        koalaSaltador.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador.setPosition(15, 2);
        stage.addActor(koalaSaltador);
        
        koalaSaltador2 = new KoalaMaloSaltadorRapido();
        koalaSaltador2.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador2.setPosition(18,45);
        stage.addActor(koalaSaltador2);
        
        koalaSaltador3 = new KoalaMaloSaltador();
        koalaSaltador3.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador3.setPosition(31, 2);
        stage.addActor(koalaSaltador3);
        
        koalaSaltador4 = new KoalaMaloSaltadorRapido();
        koalaSaltador4.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador4.setPosition(34, 45);
        stage.addActor(koalaSaltador4);
        
        koalaSaltador5 = new KoalaMaloSaltador();
        koalaSaltador5.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador5.setPosition(50, 2);
        stage.addActor(koalaSaltador5);
        
        
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.x = koala.getX();
        //camera.position.x = koalaMalo.getX();
        camera.update();
        puntos = koala.getPuntos();

        renderer.setView(camera);
        renderer.render();

        stage.act(delta);
        stage.draw();
        game.batch.begin();
        game.font.draw(game.batch, "Puntos de vida:" + vidas, 20, 450);
        game.font.draw(game.batch, "Puntos:" + koala.getPuntos(), 20, 420);
        game.batch.end();
        
        if (koala.getY()<0) {
            game.setScreen(new pantallaPerder(game,puntos));
            music_level2.stop();
        }
        
        if (koala.getX() > 204) {
            game.setScreen(new PantallaGanar2(game,puntos));
        }
        
        if (koala.getX() > 210) {
            game.setScreen(new pantallaPerder(game,puntos));
            music_level2.stop();
        }
        
        if (koala.getX() < 10) {
            game.setScreen(new pantallaPerder(game,puntos));
            music_level2.stop();
        }
        
        if(koala.getBounds().overlaps(koalaMalo.getBounds())){
             //vidas--;
             koalaMalo.remove();
        }
        
        if(koala.getBounds().overlaps(koalaMalo2.getBounds())){
             //vidas--;
             koalaMalo2.remove();
        }
        
        if(koala.getBounds().overlaps(koalaSaltador.getBounds())){
             vidas--;
             //koalaSaltador.remove();
        }
        
        if(koala.getBounds().overlaps(koalaSaltador2.getBounds())){
             vidas--;
             //koalaSaltador2.remove();
        }
        
        if(koala.getBounds().overlaps(koalaSaltador3.getBounds())){
             vidas--;
             //koalaSaltador3.remove();
        }
        
        if(koala.getBounds().overlaps(koalaSaltador4.getBounds())){
             vidas--;
             //koalaSaltador4.remove();
        }
        
        if(koala.getBounds().overlaps(koalaSaltador5.getBounds())){
             vidas--;
             //koalaSaltador5.remove();
        }
        
        if(vidas == 0){
            game.setScreen(new pantallaPerder(game,puntos));
            music_level2.stop();
        }
        
        
    }

    public void dispose() {
    }

    public void hide() {
    }

    public void pause() {
    }

    public void resize(int width, int height) {
        camera.setToOrtho(false, 20 * width / height, 20);
    }

    public void resume() {
    }
}
