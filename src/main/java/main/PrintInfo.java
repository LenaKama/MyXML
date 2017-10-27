package main;

import entity.Entity;

public class PrintInfo {
    public String print(Entity entity){
        if(entity == null){
            return null;
        }
        if(entity.getList()!=null) {
            System.out.println("\t");
        }
        //System.out.println(entity.toString());
       /* if(entity.getList()!=null){
            for(Entity en: entity.getList()){
                en.toString();
                System.out.println("vyhj");
            }
        }*/
      //  Entity en = new Entity();
return entity.toString();
    }
}
