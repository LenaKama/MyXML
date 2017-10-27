package main;

import entity.Entity;

import java.util.List;

public class PrintInfo {

    public void print(Entity entity) {
        if (entity == null) {
            System.out.println("No entity.");
        } else {

            printTab(entity);
            System.out.print(entity.getName());

            if (!entity.getAttributes().isEmpty()) {
                System.out.print(entity.getAttributes() + ": ");
            }

            if (entity.getContent() != null) {
                System.out.print(" - " + entity.getContent());
            }

            System.out.println();

            if (!entity.getList().isEmpty()) {
                List<Entity> list = entity.getList();
                for (Entity e : list) {
                    print(e);
                }
            }
        }
    }

    public void printTab(Entity entity) {
        for (int i = 2; i <= entity.getLayer(); i++) {
            System.out.print("\t");
        }
    }
}
