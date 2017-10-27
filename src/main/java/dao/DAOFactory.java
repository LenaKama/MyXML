package dao;

import dao.ParsingDAO;
import dao.impl.ParsingDAOImpl;


public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ParsingDAO parsingDAO = new ParsingDAOImpl();

    private DAOFactory() {}

    public ParsingDAO getParsingDAO() {
        return parsingDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
