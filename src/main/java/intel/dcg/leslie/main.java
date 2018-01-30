package intel.dcg.leslie;
import java.util.*;

public class main {
    public static void main(String[] args) {
        System.out.println("Test Begin");
        //test part1
        //new TestAnimal().test();

        //test part2
//        TestSort myTestSort = new TestSort();
//        myTestSort.test();
//        System.out.println(myTestSort.songList);
//        System.out.println(myTestSort.songAuthorList);
//
//        Collections.sort(myTestSort.songList);
//        Collections.sort(myTestSort.songAuthorList);
//        System.out.println(myTestSort.songList);
//        System.out.println(myTestSort.songAuthorList);

        //test part3
        TestSort myTestSort = new TestSort();
        myTestSort.test2();
        //System.out.println(myTestSort.songObjectList.get(0).getName());
        for(Song i:myTestSort.songObjectList){
            System.out.println(i.getName());
        }
        Collections.sort(myTestSort.songObjectList);
        for(Song i:myTestSort.songObjectList){
            System.out.println(i.getName());
        }
    }
}