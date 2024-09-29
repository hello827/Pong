package Objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

public class Player2 {

    public static Rectangle rectangle;
    public static boolean up, down;

    public Player2() {
        rectangle = new Rectangle();
        rectangle.setSize(8f,32f);
        rectangle.x = 625f;
        rectangle.y = Gdx.graphics.getHeight() / 2f;
    }


    public void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            rectangle.y += 150f * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rectangle.y -= 150f * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            up = true;
        } else up = false;
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            down = true;
        } else down = false;
    }
}
