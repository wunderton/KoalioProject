package Personajes;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import net.sekao.superkoalio.MyGdxGame;
import Screen.PantallaGanar;
import Screen.PantallaGanar2;

public class Koala extends Image {
    TextureRegion stand, jump;
    Animation walk;
    
    
    float time = 0;
    float xVelocity = 0;
    float yVelocity = 0;
    boolean canJump = false;
    boolean isFacingRight = true;
    public TiledMapTileLayer layer;
    public TiledMapTileLayer layer2;
    public TiledMapTileLayer layer3;
    public TiledMapTileLayer layer4;
    public TiledMapTileLayer layer5;

    final float GRAVITY = -2.5f;
    float MAX_VELOCITY = 10f;
    float MAX_VELOCITY2 = 15f;
    final float DAMPING = 0.87f;
    private int puntos;
    MyGdxGame game;

    public Koala(MyGdxGame game) {
        this.game = game;
        final float width = 18;
        final float height = 26;
        this.setSize(1, height / width);

        Texture koalaTexture = new Texture("koalio.png");
        TextureRegion[][] grid = TextureRegion.split(koalaTexture, (int) width, (int) height);

        stand = grid[0][0];
        jump = grid[0][1];
        walk = new Animation(0.15f, grid[0][2], grid[0][3], grid[0][4]);
        walk.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    public void act(float delta) {
        time = time + delta;
        

        boolean upTouched = Gdx.input.isTouched() && Gdx.input.getY() < Gdx.graphics.getHeight() / 2;
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || upTouched) {
            if (canJump) {
                yVelocity = yVelocity + MAX_VELOCITY * 4;
            }
            canJump = false;
        }

        boolean leftTouched = Gdx.input.isTouched() && Gdx.input.getX() < Gdx.graphics.getWidth() / 3;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || leftTouched) {
            xVelocity = -1 * MAX_VELOCITY;
            isFacingRight = false;
        }

        boolean rightTouched = Gdx.input.isTouched() && Gdx.input.getX() > Gdx.graphics.getWidth() * 2 / 3;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || rightTouched) {
            xVelocity = MAX_VELOCITY;
            isFacingRight = true;
        }

        yVelocity = yVelocity + GRAVITY;

        float x = this.getX();
        float y = this.getY();
        float xChange = xVelocity * delta;
        float yChange = yVelocity * delta;

        if (canMoveTo(x + xChange, y, false) == false) {
            xVelocity = xChange = 0;
        }

        if (canMoveTo(x, y + yChange, yVelocity > 0) == false) {
            canJump = yVelocity < 0;
            yVelocity = yChange = 0;
        }

        this.setPosition(x + xChange, y + yChange);

        xVelocity = xVelocity * DAMPING;
        if (Math.abs(xVelocity) < 0.5f) {
            xVelocity = 0;
        }
        
    }

    public void draw(Batch batch, float parentAlpha) {
        TextureRegion frame;

        if (yVelocity != 0) {
            frame = jump;
        } else if (xVelocity != 0) {
            frame = (TextureRegion) walk.getKeyFrame(time);
        } else {
            frame = stand;
        }

        if (isFacingRight) {
            batch.draw(frame, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        } else {
            batch.draw(frame, this.getX() + this.getWidth(), this.getY(), -1 * this.getWidth(), this.getHeight());
        }
    }

    private boolean canMoveTo(float startX, float startY, boolean shouldDestroy) {
        float endX = startX + this.getWidth();
        float endY = startY + this.getHeight();

        int x = (int) startX;
        while (x < endX) {

            int y = (int) startY;
            while (y < endY) {
                if (layer.getCell(x, y) != null) {

                    return false;
                }
                if (layer2.getCell(x, y) != null) {
                    if (shouldDestroy) {
                        layer2.setCell(x, y, null);
                        puntos++;
                    }
                    return false;
                }

                if (layer3.getCell(x, y) != null) {
                    if (shouldDestroy) {
                        layer3.setCell(x, y, null);
                        game.setScreen(new PantallaGanar(game,puntos));
                        
                    }
                    return false;
                }
                
                if (layer4.getCell(x, y) != null) {
                    if (shouldDestroy) {
                        layer4.setCell(x, y, null);
                        game.setScreen(new PantallaGanar2(game,puntos));
                    }
                    return false;
                }
                
                if (layer5.getCell(x, y) != null) {
                    if (shouldDestroy) {
                        layer5.setCell(x, y, null);
                        this.MAX_VELOCITY = this.MAX_VELOCITY2;
                    }
                    return false;
                }
                y = y + 1;
            }
            x = x + 1;
        }

        return true;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(this.getX(), this.getY(),this.getWidth(), this.getHeight());
    }
    
    public int getPuntos(){
        return puntos;
    }
}
