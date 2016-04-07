package com.vlizer.mariobros.sprites.Items;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Mateusz on 2016-04-07.
 */
public class ItemDef {
    public Vector2 position;
    public Class<?> type;
    public ItemDef(Vector2 position, Class<?> type){
        this.position = position;
        this.type = type;
    }
}
