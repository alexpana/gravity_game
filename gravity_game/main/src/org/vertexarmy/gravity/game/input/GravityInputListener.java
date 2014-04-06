package org.vertexarmy.gravity.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import org.vertexarmy.gravity.game.GravityGame;

/**
 * Created by Alex on 4/6/2014.
 */
public class GravityInputListener extends InputAdapter {
    private GravityGame gravityGame;
    private Vector3 start = new Vector3(0, 0, 0);
    private Vector3 stop = new Vector3(0, 0, 0);
    private Vector2 gravity = new Vector2(0, 0);

    public GravityInputListener(GravityGame gravityGame) {
        this.gravityGame = gravityGame;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        start.set(screenX, screenY, 0);
        Gdx.app.log("start", start.toString());
        gravityGame.getCamera().unproject(start);
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        stop.set(screenX, screenY, 0);
        Gdx.app.log("stop", stop.toString());
        gravityGame.getCamera().unproject(stop);
        stop.sub(start).scl(0.01f);
        gravity.set(stop.x, stop.y);
        Gdx.app.log("INPUT", gravity.toString());
        gravityGame.getWorld().setGravity(gravity);
        return false;
    }

}
