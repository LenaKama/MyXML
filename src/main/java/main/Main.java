package main;

import entity.Entity;
import service.ParsingService;
import service.ServiceFactory;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Entity entity;

       ServiceFactory factory = ServiceFactory.getInstance();
       ParsingService service = factory.getParsingService();

        entity = service.create();

        PrintInfo printInfo = new PrintInfo();
        System.out.println(printInfo.print(entity));
    }
}