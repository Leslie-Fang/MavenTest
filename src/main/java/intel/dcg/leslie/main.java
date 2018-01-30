package intel.dcg.leslie;
import java.util.*;

public class main {
    public static void main(String[] args) {
        System.out.println("Test Begin");
        cat a = new cat();
        a.sayName();
        a.sayNumber();
        a.eat("apple");

        felidae b = new cat("mango");
        b.sayName();
        b.sayNumber();
        b.eat("apple");


        felidae[] felidaeList=new felidae[3];
        felidaeList[0] = a;
        felidaeList[1] = b;
        felidaeList[0].eat("apple");


        ArrayList<cat> myList = new ArrayList<cat>();
        myList.add(a);
        myList.get(0).eat("apple");

        ArrayList<felidae> myList2 = new ArrayList<felidae>();
        myList2.add(new cat());
        myList2.get(0).eat("apple");
    }
}