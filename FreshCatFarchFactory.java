package hm12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.SortedMap;

public class FreshCatFarchFactory {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public void Factory(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            Class c = cats[i].getClass();
            Method[] methods = c.getMethods();

            CatAnno field = (CatAnno) c.getAnnotation(CatAnno.class);
            System.out.print("Cat " + cats[i].getName()+" have: \n"+
                    methods.length + " methods\n" + "he is a " + field.catProperties()+ "\nhis colour is: "+
                    field.catColour()+"\n");

            if((field.catProperties().equals("normal")&&(!field.catColour().equals("red")&&(methods.length<12)))){
                System.out.println(ANSI_RED +"Na FArCH!!" + ANSI_RESET);
            }else {
                System.out.println(ANSI_GREEN +"Negoden" + ANSI_RESET);
            }

        }
    }
}
