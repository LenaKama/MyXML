package dao.impl;

import dao.ParsingDAO;
import entity.Entity;

import java.io.*;

public class ParsingDAOImpl implements ParsingDAO {

    public ParsingDAOImpl(){}

    public Entity create(File file) throws IOException {

        MyParser parserLine = new MyParser();

        StringBuilder sb = new StringBuilder();
        String line;
        try ( BufferedReader reader = new BufferedReader(new FileReader(file)) ){
            while ((line = reader.readLine()) != null) {
                sb.append(line.trim());
            }
            line = sb.toString();
            parserLine.parseLine(line);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return parserLine.getRootObject();
    }
}
