package main.lesson_54_MapAdv.homework.entitycollection.dao;

import main.lesson_54_MapAdv.homework.entitycollection.interfaces.Entity;
import main.lesson_54_MapAdv.homework.entitycollection.interfaces.EntityCollection;

import java.util.TreeSet;

public class B implements EntityCollection {

    TreeSet<Entity> treeSet = new TreeSet<>((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

    // 0(log n)
    @Override
    public void add(Entity entity) {
        treeSet.add(entity);
    }

    // 0(log n)
    @Override
    public Entity removeMaxValue() {
        if (treeSet.isEmpty()) {
            return null;
        }

        return treeSet.pollFirst();
    }
}
