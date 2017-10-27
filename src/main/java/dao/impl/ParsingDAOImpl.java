package dao.impl;

import dao.ParsingDAO;
import entity.Entity;

import java.io.*;

public class ParsingDAOImpl implements ParsingDAO {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("task02.xml").getFile());

    public Entity create() throws IOException {

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
