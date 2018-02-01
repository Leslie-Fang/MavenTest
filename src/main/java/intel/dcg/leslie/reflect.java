package intel.dcg.leslie;
import java.lang.reflect.*;

//reference
//http://www.importnew.com/21235.html

public class reflect {
    public void test(){
        //System.out.println("Hello world!");
        try{
            Class<?> classObj = Class.forName("intel.dcg.leslie.cat"); //创建类对象，有三种方法创建类对象
            //获得类名
            String className = classObj.getSimpleName();
            System.out.println(String.format("The class name is: %s",className));

            //获得modifier
            int modifiers = classObj.getModifiers();
            System.out.println(String.format("The class modifier is: %d",modifiers));


            //通过类对象生成实例对象
            Object obj = classObj.newInstance(); //生成实例对象1
            cat myCat = (cat) classObj.newInstance();//生成实例对象2
            Constructor[] constructors = classObj.getConstructors();//获得所有构造函数
            Constructor cons2 = classObj.getConstructor(new Class[]{String.class});//获得特定构造函数
            cat myCat2 = (cat) cons2.newInstance("hhh");//生成实例对象3

            myCat.sayName();
            myCat2.sayName();
            Field[] fileds1 = classObj.getFields();//获得所有公有的fields
            Field[] fileds2 = classObj.getDeclaredFields();//获得所有的fileds
            for(Field myField : fileds1){
                System.out.println(myField);
            }
            for(Field myField : fileds2){
                System.out.println(myField);
            }
            Field catNumber = classObj.getDeclaredField("catNumber");//获得特定的field
            myCat2.sayNumber();
            catNumber.setAccessible(true);//修改私有变量
            catNumber.set(myCat2,100);
            myCat2.sayNumber();

            //get methods
            Method[] methods = classObj.getMethods();//获得所有方法，包括父类
            for(Method myMethod : methods){
                System.out.println(myMethod);
            }
            Method myEat = classObj.getMethod("eat",new Class[]{String.class});
            Object returnValue = myEat.invoke(myCat2, "mango");
            System.out.println(returnValue);

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
