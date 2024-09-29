package com.RivelWorks;

import Objects.Ai;
import Objects.Ball;
import Objects.BallAi;
import Objects.Player1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.rivelbop.rivelworks.g2d.graphics.ShapeBatch;
import com.rivelbop.rivelworks.ui.Font;
import com.rivelbop.rivelworks.util.Utils;


public class AiCore implements Screen {

    private Player1 player1;
    private Ai ai;
    private BallAi ball;
    private OrthographicCamera camera;
    private ShapeBatch shapeBatch;
    private SpriteBatch batch;
    private Font font;
    private int player1Score,aiScore;
    private boolean score1, aiScored;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        player1 = new Player1();
        ai = new Ai();
        ball = new BallAi();
        shapeBatch = new ShapeBatch();
        batch = new SpriteBatch();
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
        camera.update(true);
        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
        shapeBatch.setColor(Color.WHITE);
        shapeBatch.rect(player1.rectangle.x, player1.rectangle.y,player1.rectangle.width,player1.rectangle.height);
        shapeBatch.end();

        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
        shapeBatch.setColor(Color.WHITE);
        shapeBatch.rect(ai.rectangle.x, ai.rectangle.y,ai.rectangle.width,ai.rectangle.height);
        shapeBatch.end();

        shapeBatch.begin(ShapeRenderer.ShapeType.Filled);
        shapeBatch.setColor(Color.WHITE);
        shapeBatch.rect(ball.rectangle.x, ball.rectangle.y,ball.rectangle.width,ball.rectangle.height);
        shapeBatch.end();

        if(ball.rectangle.x < 0 && !score1) {
            player1Score ++;
            score1 = true;
            ball.rectangle.x = Gdx.graphics.getWidth() / 2f;
            ball.rectangle.y = Gdx.graphics.getHeight() / 2f;
            ball.speedy = 0f;
            Player1.rectangle.y = Gdx.graphics.getHeight() / 2f;
            Ai.rectangle.y = Gdx.graphics.getHeight() / 2f;
        }

        if(ball.rectangle.x > 640 && !aiScored) {
            aiScore ++;
            aiScored = true;
            ball.rectangle.x = Gdx.graphics.getWidth() / 2f;
            ball.rectangle.y = Gdx.graphics.getHeight() / 2f;
            ball.speedy = 0f;
            Player1.rectangle.y = Gdx.graphics.getHeight() / 2f;
            Ai.rectangle.y = Gdx.graphics.getHeight() / 2f;
        }

        score1 = false;
        aiScored = false;

        batch.begin();
        font.drawCenter(batch, String.valueOf(player1Score), Gdx.graphics.getWidth() / 2f + 25f, Gdx.graphics.getHeight() / 2f + 200f);
        font.drawCenter(batch, String.valueOf(aiScore), Gdx.graphics.getWidth() / 2f - 25f, Gdx.graphics.getHeight() / 2f + 200f);
        batch.end();

        player1.update();
        ai.update();
        ball.update();
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
