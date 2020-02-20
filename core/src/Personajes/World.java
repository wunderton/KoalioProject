package Personajes;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.*;
import com.badlogic.gdx.scenes.scene2d.*;
import Personajes.Koala;
import Personajes.KoalaMalo;
import Personajes.KoalaMaloPerseguidor;
import Personajes.KoalaMaloSaltador;
import Personajes.KoalaMaloSaltadorRapido;
import net.sekao.superkoalio.MyGdxGame;
import Screen.pantallaPerder;
import Personajes.*;
import Personajes.Koala;
import Personajes.KoalaMalo;
import Personajes.KoalaMaloPerseguidor;
import Personajes.KoalaMaloSaltador;
import Personajes.KoalaMaloSaltadorRapido;


public class World implements Screen {
    Stage stage;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;
    Koala koala;
    int vidas = 100;
    int puntos;
    
    //koalas con desplazamiento lateral
    KoalaMalo koalaMalo;
    KoalaMalo koalaMalo2;
    KoalaMalo koalaMalo3;
    KoalaMalo koalaMalo4;
    KoalaMalo koalaMalo5;
    KoalaMalo koalaMalo6;
    KoalaMalo koalaMalo7;
    KoalaMalo koalaMalo8;

    //koalas salto lento
    KoalaMaloSaltador koalaSaltador;
    KoalaMaloSaltador koalaSaltador3;
    KoalaMaloSaltador koalaSaltador5;
    KoalaMaloSaltador koalaSaltador6;
    KoalaMaloSaltador koalaSaltador8;
    
    //koalas salto rapido
    KoalaMaloSaltadorRapido koalaSaltador2;
    KoalaMaloSaltadorRapido koalaSaltador4;
    KoalaMaloSaltadorRapido koalaSaltador7;
    KoalaMaloSaltadorRapido koalaSaltador9;
    
    //koala perseguidor    
    KoalaMaloPerseguidor koalaPerseguidor;
    
    
    MyGdxGame game;
    Music music_level1;

    public World (MyGdxGame game, int puntos) {
        this.game=game;
        this.puntos = puntos;
    }

    public void show() {
        map = new TmxMapLoader().load("level2.tmx");
        final float pixelsPerTile = 16;
        renderer = new OrthogonalTiledMapRenderer(map, 1 / pixelsPerTile);
        camera = new OrthographicCamera();

        stage = new Stage();
        stage.getViewport().setCamera(camera);
        
        music_level1 = Gdx.audio.newMusic(Gdx.files.internal("level1.ogg"));
        music_level1.setLooping(true);
        music_level1.play();
        
        koala = new Koala(game);
        koala.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koala.layer2 = (TiledMapTileLayer) map.getLayers().get("puntos");
        koala.layer3 = (TiledMapTileLayer) map.getLayers().get("final");
        koala.layer4 = (TiledMapTileLayer) map.getLayers().get("final2");
        koala.layer5 = (TiledMapTileLayer) map.getLayers().get("velocidad");
        koala.setPosition(151, 10);
        stage.addActor(koala);
        
        
        //koalas con desplazamiento lateral
        koalaMalo = new KoalaMalo();
        koalaMalo.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo.setPosition(41, 2);
        stage.addActor(koalaMalo);
        
        koalaMalo2 = new KoalaMalo();
        koalaMalo2.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo2.setPosition(60, 2);
        stage.addActor(koalaMalo2);
        
        koalaMalo3 = new KoalaMalo();
        koalaMalo3.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo3.setPosition(155, 2);
        stage.addActor(koalaMalo3);
        
        koalaMalo4 = new KoalaMalo();
        koalaMalo4.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo4.setPosition(162, 2);
        stage.addActor(koalaMalo4);
        
        koalaMalo5 = new KoalaMalo();
        koalaMalo5.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo5.setPosition(169, 2);
        stage.addActor(koalaMalo5);
        
        koalaMalo6 = new KoalaMalo();
        koalaMalo6.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo6.setPosition(178, 2);
        stage.addActor(koalaMalo6);
        
        koalaMalo7 = new KoalaMalo();
        koalaMalo7.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo7.setPosition(185, 2);
        stage.addActor(koalaMalo7);
        
        koalaMalo8 = new KoalaMalo();
        koalaMalo8.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaMalo8.setPosition(192, 2);
        stage.addActor(koalaMalo8);
        
        
        
        koalaSaltador = new KoalaMaloSaltador();
        koalaSaltador.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador.setPosition(25, 2);
        stage.addActor(koalaSaltador);
        
        koalaSaltador6 = new KoalaMaloSaltador();
        koalaSaltador6.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador6.setPosition((float) 159.5, 4);
        stage.addActor(koalaSaltador6);
        
        koalaSaltador7 = new KoalaMaloSaltadorRapido();
        koalaSaltador7.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador7.setPosition((float) 166.5,4);
        stage.addActor(koalaSaltador7);
        
        koalaSaltador8 = new KoalaMaloSaltador();
        koalaSaltador8.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador8.setPosition((float) 173.5, 4);
        stage.addActor(koalaSaltador8);
        
        koalaSaltador9 = new KoalaMaloSaltadorRapido();
        koalaSaltador9.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador9.setPosition((float) 180.5,4);
        stage.addActor(koalaSaltador9);
        
        koalaSaltador2 = new KoalaMaloSaltadorRapido();
        koalaSaltador2.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaSaltador2.setPosition(28,45);
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
        
        //koala perseguidor
        koalaPerseguidor = new KoalaMaloPerseguidor(koala);
        koalaPerseguidor.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koalaPerseguidor.setPosition(100, 2);
        stage.addActor(koalaPerseguidor);
        
        
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
            music_level1.stop();
        }
        
        if (koala.getX() > 210) {
            game.setScreen(new pantallaPerder(game,puntos));
            music_level1.stop();
        }
        
        if(koala.getX() > 207){
            music_level1.stop();
        }
        
        if (koala.getX() < 10) {
            game.setScreen(new pantallaPerder(game,puntos));
            music_level1.stop();
        }
        
        if(koala.getBounds().overlaps(koalaMalo.getBounds())){
             vidas--;
             //koalaMalo.remove();
             puntos++;
        }
        
        if(koala.getBounds().overlaps(koalaMalo2.getBounds())){
            vidas--;
            puntos++;
        }
        
        if(koala.getBounds().overlaps(koalaMalo3.getBounds())){
            vidas--;
            puntos++;
        }
        
        if(koala.getBounds().overlaps(koalaMalo4.getBounds())){
            vidas--;
            puntos++;
        }
        
        if(koala.getBounds().overlaps(koalaMalo5.getBounds())){
            vidas--;
            puntos++;
        }
        
        if(koala.getBounds().overlaps(koalaMalo6.getBounds())){
            vidas--;
            puntos++;
        }
        
        if(koala.getBounds().overlaps(koalaMalo7.getBounds())){
            vidas--;
            puntos++;
        }
        
        if(koala.getBounds().overlaps(koalaMalo8.getBounds())){
            vidas--;
            puntos++;
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
        
        if(koala.getBounds().overlaps(koalaPerseguidor.getBounds())){
             vidas--;
             
        }
        
        if(vidas == 0){
            game.setScreen(new pantallaPerder(game,puntos));
            music_level1.stop();
        }
        
        
    }
    
    public void paraMusica(){
        music_level1.stop();
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
