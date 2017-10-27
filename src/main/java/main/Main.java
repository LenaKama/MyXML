package main;

import entity.Entity;
import service.ParsingService;
import service.ServiceFactory;

import java.io.*;

public class Main {

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("task02.xml").getFile());

    public static void main(String[] args) throws IOException {
        Entity entity;

       ServiceFactory factory = ServiceFactory.getInstance();
       ParsingService service = factory.getParsingService();

        entity = service.create(new Main().file);

        PrintInfo printInfo = new PrintInfo();
        printInfo.print(entity);
    }
}