package com.example.flyaircraft.Objects;

public abstract class CollisionObject implements Collision {
    protected float x;
    protected float y;
    protected float size;


    public CollisionObject(float x, float y, float size) {
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public CollisionObject(int size) {
        this.size = size;
    }

    @Override
    public boolean onCollisionEnter(CollisionObject object) {
        return this.x - size < object.x - object.size && this.x + size > object.x + object.size &&
                this.y + size < object.y + object.size && this.y - size > object.y - object.size;
    }
}
