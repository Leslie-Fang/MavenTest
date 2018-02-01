package intel.dcg.leslie;

public class cat extends felidae{
    private static int catNumber;
    public cat(){
        catNumber++;
    }
    public cat(String myName){
        super(myName);
        catNumber++;
    }
    public void sayNumber(){
        super.sayNumber();
        System.out.println(String.format("There are %d cats",catNumber));
    }
    public boolean eat(String food){
        System.out.println("cat is eating:"+food);
        return true;
    }
}
