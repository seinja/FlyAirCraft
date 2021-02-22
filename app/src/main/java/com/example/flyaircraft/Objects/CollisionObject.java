package com.example.flyaircraft.Objects;

public abstract class CollisionObject implements Collision {
    protected float x;
    protected float y;
    protected float size;


    public CollisionObject(float x, float y,  float size){
        this.size = size;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean onCollisionEnter(CollisionObject object) {
        return object.x < object.x + object.size && object.x > object.x- object.size &&
                object.y < object.y + object.size && object.y > object.y - object.size;
    }
}
