package intel.dcg.leslie;
import java.lang.reflect.*;

//reference
//http://www.importnew.com/21235.html

public class reflect {
    public void test(){
        //System.out.println("Hello world!");
        try{
            Class<?> classObj = Class.forName("intel.dcg.leslie.cat"); //创建类对象，有三种方法创建类对象
            Object obj = classObj.newInstance(); //生成实例对象1
            cat myCat = (cat) classObj.newInstance();//生成实例对象2
            Constructor[] constructors = classObj.getConstructors();//获得所有构造函数
            Constructor cons2 = classObj.getConstructor(new Class[]{String.class});//生成实例对象3
            cat myCat2 = (cat) cons2.newInstance("hhh");
            myCat.sayName();
            myCat2.sayName();
//            Field[] fileds = classObj.getDeclaredFields();//get fileds
//            Field name = classObj.getDeclaredField("name");//get fileds
//            name.setAccessible(true);
//            name.set(myCat2,"hhh2");
//            myCat2.sayName();
            
            //get methods
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(InstantiationException ex){
            ex.printStackTrace();
        }catch(IllegalAccessException ex){
            ex.printStackTrace();
        }catch(NoSuchMethodException ex){
            ex.printStackTrace();
        }catch(InvocationTargetException ex){
            ex.printStackTrace();
        }catch(NoSuchFieldException ex){
            ex.printStackTrace();
        }

    }
}
