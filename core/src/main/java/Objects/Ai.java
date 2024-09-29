package Objects;


import Scene.Pong;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

public class Ai {

    public static Rectangle rectangle;
    public static boolean up, down;
    private BallAi ball;

    public Ai() {
        ball = new BallAi();
        rectangle = new Rectangle();
        rectangle.setSize(8f,32f);
        rectangle.x = 625f;
        rectangle.y = Gdx.graphics.getHeight() / 2f;
    }


    public void update() {

    }
}
