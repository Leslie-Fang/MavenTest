package intel.dcg.leslie;

import java.sql.*;

public class TestJDBC {
    private String url;
    private String name;
    private String password;

    public TestJDBC(){
        this.url = new DBconfig().getUrl();
        this.name = new DBconfig().getName();
        this.password = new DBconfig().getPassword();
    }

    class DBconfig{
        private final String url = "jdbc:mysql://localhost:3306";
        private final String name = "sampadm";
        private final String password = "secret";
        public String getUrl(){
            return this.url;
        }
        public String getName(){
            return this.name;
        }
        public String getPassword(){
            return this.password;
        }
    }

    public void test(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting");

        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

    }

}
