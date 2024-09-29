package Objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class BallAi {

    public Rectangle rectangle;
    public float speedx = 5f, speedy = 0f, direction = 1f;


    public BallAi() {
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
        if(rectangle.overlaps(Ai.rectangle)) {
            direction = -1f;
        }

        if(Player1.up && rectangle.overlaps(Player1.rectangle)) {
            //speedy += 5f;
            speedy = 150f * Gdx.graphics.getDeltaTime();
        }
        if(Player1.down && rectangle.overlaps(Player1.rectangle)) {
            //speedy -= 5f;
            speedy = -150f * Gdx.graphics.getDeltaTime();
        }


        if(Ai.rectangle.y < rectangle.y) {
            Ai.rectangle.y += 140f * Gdx.graphics.getDeltaTime();
        }

        if(Ai.rectangle.y > rectangle.y) {
            Ai.rectangle.y -= 140f * Gdx.graphics.getDeltaTime();
        }



        if(Player2.up && rectangle.overlaps(Player2.rectangle)) {
            //speedy += 5f;
            speedy = 150f * Gdx.graphics.getDeltaTime();

        }
        if(Player2.down && rectangle.overlaps(Player2.rectangle)) {
            //speedy -= 5f;
            speedy = -150f * Gdx.graphics.getDeltaTime();
        }

        if(rectangle.y >= 480) {
            //speedy -= 5f;
            speedy = -150f * Gdx.graphics.getDeltaTime();
        }
        if(rectangle.y <= 0) {
            //speedy += 5f;
            speedy = 150f * Gdx.graphics.getDeltaTime();
        }


    }
}
