package com.vlizer.mariobros.sprites.TileObject;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.vlizer.mariobros.MarioBros;
import com.vlizer.mariobros.scenes.Hud;
import com.vlizer.mariobros.screens.PlayScreen;

/**
 * Created by Mateusz on 2016-04-06.
 */
public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.BRICK_BIT);
    }

    @Override
    public void onHeadHit() {
        setCategoryFilter(MarioBros.DESTROYED_BIT);
        getCell().setTile(null);
        Hud.addScore(200);
        MarioBros.manager.get("audio/sounds/breakblock.wav",Sound.class).play();
    }
}
