package org.vertexarmy.gravity.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import org.vertexarmy.gravity.game.input.GravityInputListener;
import org.vertexarmy.gravity.game.physics.FixtureDefBuilder;

public class GravityGame extends Game {

    private OrthographicCamera camera;
    private World world;
    private Box2DDebugRenderer debugRenderer;

    public OrthographicCamera getCamera() {
        return camera;
    }

    public World getWorld() {
        return world;
    }

    @Override
    public void create() {
        System.out.println("Application started");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.21f, 1.0f);

        world = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();

        Gdx.input.setInputProcessor(new GravityInputListener(this));

        createBall();
        createWall();
    }

    private void createWall() {
        BodyDef wallBodyDef = new BodyDef();
        wallBodyDef.position.set(new Vector2(1, 10));

        Body wallBody = world.createBody(wallBodyDef);

        PolygonShape box = new PolygonShape();
        box.setAsBox(camera.viewportWidth, 9.0f);

        wallBody.createFixture(box, 0.0f);

        box.dispose();
    }

    private void createBall() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(100, 300);

        Body ballBody = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(10);

        ballBody.createFixture(FixtureDefBuilder.instance()
                .shape(circleShape)
                .density(20000.5f)
                .friction(0.4f)
                .restitution(0.6f)
                .build());

        circleShape.dispose();
    }

    @Override
    public void render() {
        update();
        draw();
    }

    private void update() {
        world.step(1 / 12f, 6, 1);
    }

    private void draw() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        debugRenderer.render(world, camera.combined);
    }
}
