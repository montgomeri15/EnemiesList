package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DbManager {

    protected static Connection conn;
    protected static PreparedStatement ps;
    protected static ResultSet resultSet;

    /** Подключение БД */
    protected static Connection connectionTable(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location", "root", "root");
            System.out.println("База данных подключена.");
        } catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    /** Создание таблицы */
    public static void createTable(){
        try {
            connectionTable();
            ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS enemies(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, status BOOLEAN DEFAULT TRUE)");
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            System.out.println("Создание таблицы завершено.");
        }
    }

    /** Добавление информации */
    public static void fillTable(){
        try {
            connectionTable();
            //ps = conn.prepareStatement("ALTER TABLE enemies AUTO_INCREMENT=0");
            ps = conn.prepareStatement("INSERT INTO enemies(name) VALUE('me')");
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            System.out.println("Заполнение таблицы завершено.");
        }
    }

    /** Вывод таблицы */
    public static ArrayList<String> showTable(){
        try {
            connectionTable();
            ps = conn.prepareStatement("SELECT * FROM enemies");
            resultSet = ps.executeQuery();

            ArrayList<String> tableList = new ArrayList<String>();

            while (resultSet.next()){
                System.out.print(resultSet.getString("id"));
                System.out.print(" ");
                System.out.print(resultSet.getString("name"));
                System.out.print(" ");
                System.out.println(resultSet.getString("status"));

                tableList.add(resultSet.getString("name"));
            }
            return tableList;

        } catch (Exception e){
            System.out.println(e);
        } finally {
            System.out.println("Вывод данных таблицы завершен.");
        }
        return null;
    }
}
