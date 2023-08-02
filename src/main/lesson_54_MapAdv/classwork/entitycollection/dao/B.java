package main.lesson_54_MapAdv.classwork.entitycollection.dao;

import main.lesson_54_MapAdv.classwork.entitycollection.interfaces.Entity;
import main.lesson_54_MapAdv.classwork.entitycollection.interfaces.EntityCollection;

import java.util.ArrayList;
import java.util.Collections;
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
/*

    ArrayList<Entity> arrayList = new ArrayList<>();

    @Override
    public void add(Entity entity) {
        if (entity != null) {
            int insertIndex = Collections.binarySearch(arrayList, entity, (a, b) -> Integer.compare(b.getValue(), a.getValue()));
        }
    }

    @Override
    public Entity removeMaxValue() {
        if (arrayList.isEmpty()) {
            return null;
        }

        Entity maxEntity = arrayList.get(0);
        int maxValue = maxEntity.getValue();

        for (Entity entity : arrayList) {
            if (entity.getValue() > maxValue) {
                maxEntity = entity;
                maxValue = entity.getValue();
            }
        }

        arrayList.remove(maxEntity);
        return maxEntity;
    }
 */