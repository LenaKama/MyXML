package dao;

import entity.Entity;

import java.io.IOException;

public interface ParsingDAO {
    Entity create()throws IOException;
}
