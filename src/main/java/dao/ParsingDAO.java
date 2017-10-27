package dao;

import entity.Entity;

import java.io.File;
import java.io.IOException;

public interface ParsingDAO {
    Entity create(File file)throws IOException;
}
