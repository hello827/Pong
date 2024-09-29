package Objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

public class Player1 {

    public static Rectangle rectangle;
    public static boolean up, down;

    public Player1() {
        rectangle = new Rectangle();
        rectangle.setSize(8f,32f);
        rectangle.x = 15f;
        rectangle.y = Gdx.graphics.getHeight() / 2f;
    }


    public void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            rectangle.y += 150f * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            rectangle.y -= 150f * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            up = true;
        } else up = false;
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            down = true;
        } else down = false;
    }
}
