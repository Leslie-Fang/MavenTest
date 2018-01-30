package intel.dcg.leslie;
//抽象类可以有构造函数
//抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。

public abstract class felidae implements animal{
    private String name;
    private static int number;
    public felidae(){
        this.name="leslie";
        number++;
    }
    public felidae(String myName){
        this.name=myName;
        number++;
    }
    public void sayName(){
        System.out.println(name);
    };
    public void sayNumber(){
        System.out.println(String.format("There are %d felidaes",number));
    };
    public boolean eat(String food){
        System.out.println("felidae is eating:"+food);
        return true;
    };
}
