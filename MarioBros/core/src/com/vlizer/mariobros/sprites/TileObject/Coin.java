package com.vlizer.mariobros.sprites.TileObject;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.vlizer.mariobros.MarioBros;
import com.vlizer.mariobros.scenes.Hud;
import com.vlizer.mariobros.screens.PlayScreen;
import com.vlizer.mariobros.sprites.Items.ItemDef;
import com.vlizer.mariobros.sprites.Items.Mushroom;


/**
 * Created by Mateusz on 2016-04-06.
 */
public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;
    public Coin(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);
    }

    @Override
    public void onHeadHit() {
        if(getCell().getTile().getId() == BLANK_COIN)
            MarioBros.manager.get("audio/sounds/bump.wav",Sound.class).play();
        else{
            MarioBros.manager.get("audio/sounds/coin.wav",Sound.class).play();
            screen.spawnItem(new ItemDef(new Vector2(body.getPosition().x,body.getPosition().y + 16/ MarioBros.PPM), Mushroom.class));
            Hud.addScore(100);
            getCell().setTile(tileSet.getTile(BLANK_COIN));
        }


    }
}
