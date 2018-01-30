package intel.dcg.leslie;
import java.util.*;

public class main {
    public static void main(String[] args) {
        System.out.println("Test Begin");
        //new TestAnimal().test();
        TestSort myTestSort = new TestSort();
        myTestSort.test();
        System.out.println(myTestSort.songList);
        System.out.println(myTestSort.songAuthorList);
    }
}