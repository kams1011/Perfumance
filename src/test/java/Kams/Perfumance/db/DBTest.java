package Kams.Perfumance.db;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {

    private static final String DRIVER =
            "org.mariadb.jdbc.Driver";
    private static final String URL =
            "jdbc:mariadb://localhost:3306/Perfumance";
    private static final String USER =
            "root";
    private static final String PW =
            "1234";

    @Test
    public void testConnection() throws Exception{
        Class.forName(DRIVER);
        try(Connection con = DriverManager.getConnection(URL, USER, PW)){
            System.out.println(con);
        } catch (Exception e){
            e.printStackTrace();
        }
    }



}
