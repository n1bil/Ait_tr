package main.lesson_54_MapAdv.homework.entitycollection.dao;

import main.lesson_54_MapAdv.homework.entitycollection.interfaces.Entity;
import main.lesson_54_MapAdv.homework.entitycollection.interfaces.EntityCollection;

import java.util.HashSet;

public class A implements EntityCollection {

    HashSet<Entity> set = new HashSet<>();

    // 0(1)
    @Override
    public void add(Entity entity) {
        if (entity != null) {
            set.add(entity);
        }
    }

    // 0(n)
    @Override
    public Entity removeMaxValue() {
        if (set.isEmpty()) {
            return null;
        }

        Entity maxEntity = null;
        for (Entity current : set) {
            if (maxEntity == null || current.getValue() > maxEntity.getValue()) {
                maxEntity = current;
            }
        }

        set.remove(maxEntity);
        return maxEntity;
    }
}