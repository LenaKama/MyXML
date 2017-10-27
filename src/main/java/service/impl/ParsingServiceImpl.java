package service.impl;

import dao.DAOFactory;
import dao.ParsingDAO;
import entity.Entity;
import service.ParsingService;

import java.io.File;
import java.io.IOException;

public class ParsingServiceImpl implements ParsingService{
    @Override
    public Entity create(File file) throws IOException {

        DAOFactory factory = DAOFactory.getInstance();
        ParsingDAO parsingDAO = factory.getParsingDAO();

        Entity entity = parsingDAO.create(file);

        return entity;
    }

    public ParsingServiceImpl(){}
}
