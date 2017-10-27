package service;

import entity.Entity;

import java.io.File;
import java.io.IOException;

public interface ParsingService {
    Entity create(File file)throws IOException;
}
