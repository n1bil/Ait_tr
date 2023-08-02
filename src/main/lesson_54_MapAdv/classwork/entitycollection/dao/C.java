package main.lesson_54_MapAdv.classwork.entitycollection.dao;

import main.lesson_54_MapAdv.classwork.entitycollection.interfaces.Entity;
import main.lesson_54_MapAdv.classwork.entitycollection.interfaces.EntityCollection;

import java.util.PriorityQueue;

public class C implements EntityCollection {

    PriorityQueue<Entity> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

    // 0(n)
    @Override
    public void add(Entity entity) {
        if (entity != null && !priorityQueue.contains(entity)) {
            priorityQueue.add(entity);
        }

    }

    // 0(1)
    @Override
    public Entity removeMaxValue() {
        if (priorityQueue.isEmpty()) {
            return null;
        }
        return priorityQueue.poll();
    }
}
