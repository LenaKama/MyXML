package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {
    private String name;
    private String content;
    private Map<String, String> attributes = new HashMap<>();
    private int layer;
    private List<Entity> list = new ArrayList<>();

    public Entity(){}

    public List<Entity> getList(){
        return this.list;
    }

    public void setList(Entity entity){
        this.list.add(entity);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getContent(){
        return this.content;
    }

     public void setContent(String content){
         this.content = content;
     }

    public Map getAttributes(){
        return this.attributes;
    }

    public void setAttributes(Map attributes){
        this.attributes = attributes;
    }

    public int getLayer(){
        return this.layer;
    }

    public void setLayer(int layer){
        this.layer = layer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){ return false;}

        Entity entity = (Entity) o;

        if (!name.equals(entity.name)) {return false;}
        if (!content.equals(entity.content)){return false;}
        if (layer != entity.layer) {return false;}
        if (!list.equals(entity.list)) {return false;}

        return attributes.equals(entity.attributes);
    }

    @Override
    public String toString() {
        if (this.attributes != null) {
            return this.name + " " + this.attributes + " " + this.content + " " + this.layer + " " + this.list;
        }
        else return this.name+" "+this.list;
    }

    @Override
    public int hashCode() {
        int result = getLayer();
        result = 31 * result + (int)Math.round(getLayer());
        result = 31 * result + (getAttributes() == null ? 0 : getAttributes().hashCode());
        result = 31 * result + (getList() == null ? 0 : getList().hashCode());
        result = 31 * result + (getContent() == null ? 0 : getContent().hashCode());
        return result;
    }
}
