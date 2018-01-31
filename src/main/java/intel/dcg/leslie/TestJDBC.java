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
        private final String url = "jdbc:mysql://localhost:3306/express2react";
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
            Connection conn = DriverManager.getConnection(this.url, this.name,this.password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM users" );
            while ( rs.next() ) {
                int numColumns = rs.getMetaData().getColumnCount();
                for ( int i = 1 ; i <= numColumns ; i++ ) {
                    System.out.println( "COLUMN " + i + " = " + rs.getObject(i) );
                }
            }
            rs.close();
            stmt.close();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void test2(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(this.url, this.name,this.password);
            ps = conn.prepareStatement( "SELECT first,last FROM users WHERE first=? AND id =?" );
            ps.setString(1, "Bucky");
            ps.setInt(2, 1);
            rs = ps.executeQuery();
            while ( rs.next() ) {
                int numColumns = rs.getMetaData().getColumnCount();
                for ( int i = 1 ; i <= numColumns ; i++ ) {
                    System.out.println( "COLUMN " + i + " = " + rs.getObject(i) );
                }
            }
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            try{
                rs.close();
                ps.close();
            }catch( SQLException e){}
        }
    }

    public void testInsert(){
        Connection conn = null;
        boolean autoCommitDefault = true;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.url, this.name,this.password);
            autoCommitDefault = conn.getAutoCommit();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement( "insert into users values(?,?,?,?,'hhh','hhh2')" );
            ps.setInt(1, 5);
            ps.setString(2, "mango");
            ps.setString(3, "liu");
            ps.setInt(4, 18);
            ps.executeUpdate();
            conn.commit();
        }catch(ClassNotFoundException ex){
            try { conn.rollback(); } catch (Throwable ignore) {}
            ex.printStackTrace();
        }catch(SQLException ex){
            try { conn.rollback(); } catch (Throwable ignore) {}
            ex.printStackTrace();
        }finally {
            try { conn.setAutoCommit(autoCommitDefault); }
            catch (Throwable ignore) {}
        }
    }

}
