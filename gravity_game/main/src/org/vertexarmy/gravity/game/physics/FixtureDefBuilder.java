package org.vertexarmy.gravity.game.physics;

import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;

/**
* Created by Alex on 4/5/2014.
*/
public class FixtureDefBuilder {
    private static FixtureDefBuilder INSTANCE;
    private final static FixtureDef blueprint = new FixtureDef();

    FixtureDefBuilder() {
    }

    public static FixtureDefBuilder instance() {
        if (INSTANCE == null) {
            INSTANCE = new FixtureDefBuilder();
        }
        return INSTANCE;
    }

    public FixtureDefBuilder shape(Shape shape) {
        blueprint.shape = shape;
        return this;
    }

    public FixtureDefBuilder density(float density){
        blueprint.density = density;
        return this;
    }

    public FixtureDefBuilder friction(float friction) {
        blueprint.friction = friction;
        return this;
    }

    public FixtureDefBuilder restitution(float restitution) {
        blueprint.restitution = restitution;
        return this;
    }

    public FixtureDef build() {
        return blueprint;
    }
}
