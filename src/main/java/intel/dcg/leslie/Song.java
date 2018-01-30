package intel.dcg.leslie;

public class Song implements Comparable<Song>{
    private String name,author;
    public Song(String name,String author){
        this.name = name;
        this.author = author;
    }
    public String getName(){
        return this.name;
    }
    public String getAuthor(){
        return this.author;
    }
    public int compareTo(Song s){
        return this.name.compareTo(s.getName());
    }
}
