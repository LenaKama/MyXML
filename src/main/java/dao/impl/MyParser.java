package dao.impl;

import entity.Entity;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyParser {

    final Pattern TAGS = Pattern.compile("(<(?<name>[^<>\\s/]+)\\s?(?<attributes>\\w+=\"\\w+\")?>)?(?<content>[^<>]+)?(</(?<closename>[^<>]+)>)?");
    final Pattern ATTRIBUTES = Pattern.compile("(?<name>\\w+)=\"(?<value>\\w+)\"");
    private ArrayDeque<Entity> unfullObjectStack = new ArrayDeque<>();
    private ArrayDeque<Entity> fullObjectStack = new ArrayDeque<>();

    public MyParser() {
    }

    public void parseLine(String line) {
        //System.out.println(line);
        Matcher tags = TAGS.matcher(line);

        while (tags.find()) {
            if (tags.group("name") != null) {
                Entity entity = new Entity();
                entity.setName(tags.group("name"));
                if (tags.group("attributes") != null) {
                    entity.setAttributes(parseAttributes(tags.group("attributes")));
                }
                unfullObjectStack.push(entity);
            }
            if (tags.group("closename") != null) {
                Entity entity = unfullObjectStack.pop();
                entity.setLayer(unfullObjectStack.size() + 1);
                entity.setContent(tags.group("content"));

                while (!fullObjectStack.isEmpty() && fullObjectStack.peek().getLayer() > entity.getLayer()) {
                    entity.setList(fullObjectStack.pop());
                }
                fullObjectStack.push(entity);
            }
        }
    }

    public ArrayDeque<Entity> getUnFullObjectStack() {
        return this.unfullObjectStack;
    }

    public void setUnFullObjectStack(ArrayDeque unfullObjectStack) {
        this.unfullObjectStack = unfullObjectStack;
    }

    public ArrayDeque<Entity> getFullObjectStack() {
        return this.fullObjectStack;
    }

    public void setFullObjectStack(ArrayDeque fullObjectStack) {
        this.fullObjectStack = fullObjectStack;
    }

    public Map<String, String> parseAttributes(String attributesLine) {
        Map<String, String> attributesMap = new HashMap<String, String>();

        Matcher attributes = ATTRIBUTES.matcher(attributesLine);
        while (attributes.find()) {
            attributesMap.put(attributes.group("name"), attributes.group("value"));
        }
        return attributesMap;
    }

    public Entity getRootObject() {
        return this.getFullObjectStack().peek();
    }
}
