package com.RivelWorks;

import Objects.Ball;
import Objects.Player1;
import Objects.Player2;
import Scene.Pong;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.rivelbop.rivelworks.g2d.graphics.ShapeBatch;
import com.rivelbop.rivelworks.ui.Font;
import com.rivelbop.rivelworks.util.Utils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Core implements Screen {
    private Player1 player1;
    private Player2 player2;
    private Ball ball;
    private OrthographicCamera camera;
    private ShapeBatch shapeBatch;
    private Font font;
    private SpriteBatch batch;
    private int player1Score,player2Score;
    private boolean score1, score2;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        player1 = new Player1();
        player2 = new Player2();
        ball = new Ball();
        shapeBatch = new ShapeBatch();
        camera.update(true);
        Font.FontBuilder builder = new Font.FontBuilder();
        font = builder.
            setFont(Gdx.files.internal("pixel.ttf")).
            setSize(35).
            build();
        builder.dispose();
    }

    @Override
    public void render(float delta) {
        Utils.clearScreen2D();
        camera.update();
        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
        shapeBatch.setColor(Color.WHITE);
        shapeBatch.rect(player1.rectangle.x, player1.rectangle.y,player1.rectangle.width,player1.rectangle.height);
        shapeBatch.end();

        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
        shapeBatch.setColor(Color.WHITE);
        shapeBatch.rect(player2.rectangle.x, player2.rectangle.y,player2.rectangle.width,player2.rectangle.height);
        shapeBatch.end();

        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
        shapeBatch.setColor(Color.WHITE);
        shapeBatch.ellipse(ball.rectangle.x, ball.rectangle.y,ball.rectangle.getWidth(),ball.rectangle.getHeight());
        shapeBatch.end();

        if(ball.rectangle.x < 0 && !score1) {
            player1Score ++;
            score1 = true;
            ball.rectangle.x = Gdx.graphics.getWidth() / 2f;
            ball.rectangle.y = Gdx.graphics.getHeight() / 2f;
        }

        if(ball.rectangle.x > 640 && !score2) {
            player2Score ++;
            score2 = true;
            ball.rectangle.x = Gdx.graphics.getWidth() / 2f;
            ball.rectangle.y = Gdx.graphics.getHeight() / 2f;
        }

        score1 = false;
        score2 = false;

        player1.update();
        player2.update();
        ball.update();
        batch.begin();
        font.drawCenter(batch, String.valueOf(player2Score), Gdx.graphics.getWidth() / 2f + 25, Gdx.graphics.getHeight() / 2f + 200);
        font.drawCenter(batch, String.valueOf(player1Score), Gdx.graphics.getWidth() / 2f - 25, Gdx.graphics.getHeight() / 2f + 200);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
