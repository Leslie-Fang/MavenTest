package intel.dcg.leslie;

import java.util.ArrayList;
import java.io.*;

public class TestSort {
    ArrayList<String> songList = new ArrayList<String>();
    ArrayList<String> songAuthorList = new ArrayList<String>();
    public void test(){
        String filePath="./data/songList.txt";
        File file = new File(filePath);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while( (line=reader.readLine()) != null){
                //System.out.println(line);
                songList.add(line.split("/")[0]);
                songAuthorList.add(line.split("/")[1]);
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }


    }
}
