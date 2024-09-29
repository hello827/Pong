package Objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Ball {

    public Rectangle rectangle;
    public float speedx = 5f, speedy = 0f, direction = 1f;


    public Ball() {
        rectangle = new Rectangle();
        rectangle.setSize(8f,8f);
        rectangle.x = Gdx.graphics.getWidth() / 2f;
        rectangle.y = Gdx.graphics.getHeight() / 2f;
    }

    public void render() {

    }

    public void update() {
        rectangle.x += speedx * direction;
        rectangle.y += speedy;

        if(rectangle.overlaps(Player1.rectangle)) {
            direction = 1f;
        }
        if(rectangle.overlaps(Player2.rectangle)) {
            direction = -1f;
        }

        if(Player1.up && rectangle.overlaps(Player1.rectangle)) {
            //speedy += 5f;
            speedy = 5f;
        }
        if(Player1.down && rectangle.overlaps(Player1.rectangle)) {
            //speedy -= 5f;
            speedy = -5f;
        }
        if(Player2.up && rectangle.overlaps(Player2.rectangle)) {
            //speedy += 5f;
            speedy = 5f;

        }
        if(Player2.down && rectangle.overlaps(Player2.rectangle)) {
            //speedy -= 5f;
            speedy = -5f;
        }

        if(rectangle.y >= 480) {
            //speedy -= 5f;
            speedy = -5f;
        }
        if(rectangle.y <= 0) {
            //speedy += 5f;
            speedy = 5f;
        }


    }
}
