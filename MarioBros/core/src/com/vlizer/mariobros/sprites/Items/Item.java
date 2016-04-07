package com.vlizer.mariobros.sprites.Items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.vlizer.mariobros.MarioBros;
import com.vlizer.mariobros.screens.PlayScreen;
import com.vlizer.mariobros.sprites.Mario;

/**
 * Created by Mateusz on 2016-04-07.
 */
public abstract class Item extends Sprite{
    protected PlayScreen screen;
    protected World world;
    protected Vector2 velocity;
    protected boolean toDestroy;
    protected boolean destoyed;
    protected Body body;


    public Item(PlayScreen screen, float x, float y){
        this.screen = screen;
        this.world = screen.getWorld();
        setPosition(x,y);
        setBounds(getX(),getY(),16/ MarioBros.PPM,16/ MarioBros.PPM);
        defineItem();
        toDestroy = false;
        destoyed = false;

    }

    public abstract void defineItem();
    public abstract void  use(Mario mario);


    public void update(float dt){
        if(toDestroy && !destoyed){
            world.destroyBody(body);
            destoyed = true;
        }
    }
    public void draw(Batch batch){
        if(!destoyed)
            super.draw(batch);
    }

    public void destroy(){
        toDestroy = true;
    }
    public void reverseVelocity(boolean x, boolean y){
        if(x){
            velocity.x = - velocity.x;
        }
        if(y){
            velocity.y = -velocity.y;
        }
    }

}
