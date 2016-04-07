package com.vlizer.mariobros.Tools;

import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.vlizer.mariobros.MarioBros;
import com.vlizer.mariobros.screens.PlayScreen;
import com.vlizer.mariobros.sprites.TileObject.Brick;
import com.vlizer.mariobros.sprites.TileObject.Coin;
import com.vlizer.mariobros.sprites.Enemies.Goomba;

/**
 * Created by Mateusz on 2016-04-06.
 */
public class B2WorldCreator {

        private Array<Goomba> goombas;

    public Array<Goomba> getGoombas() {
        return goombas;
    }

    public B2WorldCreator(PlayScreen screen){
        World world = screen.getWorld();
        Map map = screen.getMap();
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //Ground
        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect  = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM, (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);

            body = world.createBody(bdef);
            shape.setAsBox((rect.getWidth() / 2) / MarioBros.PPM,(rect.getHeight() / 2)/MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        //Pipes
        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect  = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM, (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);

            body = world.createBody(bdef);
            shape.setAsBox(rect.getWidth() / 2 / MarioBros.PPM,rect.getHeight() / 2 /MarioBros.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = MarioBros.OBJECT_BIT;
            body.createFixture(fdef);

        }

        //Bricks
        for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect  = ((RectangleMapObject) object).getRectangle();
            new Brick(screen,rect);

        }

        //Coins
        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect  = ((RectangleMapObject) object).getRectangle();
            new Coin(screen,rect);

        }
        //goombas
        goombas = new Array<Goomba>();
        for(MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect  = ((RectangleMapObject) object).getRectangle();
            goombas.add(new Goomba(screen,rect.getX()/ MarioBros.PPM, rect.getY() / MarioBros.PPM));

        }



    }

}
