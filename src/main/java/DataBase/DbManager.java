package DataBase;

import java.sql.*;
import java.util.ArrayList;

public class DbManager {

    protected static Connection conn;
    protected static Statement statement;
    protected static PreparedStatement ps;
    protected static ResultSet resultSet;

    /** Подключение БД */
    public static Connection connectionTable(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location", "root", "root");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    /** Создание таблицы */
    public static void createTable(){
        try {
            connectionTable();
            ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS enemies(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, status BOOLEAN DEFAULT TRUE)");
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            System.out.println("Создание таблицы завершено.");
        }
    }

    /** Проверка на заполненность */
    /*public static void checkTable(){
        try {
            connectionTable();
            ps = conn.prepareStatement("SELECT * FROM enemies");
            resultSet = ps.executeQuery();

            if (resultSet.getString("id").equals(null)){
                ps = conn.prepareStatement("TRUNCATE TABLE enemies");
                ps.executeUpdate();
            } else {
            }

        } catch (Exception e){
            System.out.println(e);
        }

    }*/

    /** Добавление информации */
    public static void fillTable(){
        try {
            connectionTable();
            ps = conn.prepareStatement("INSERT INTO enemies(name) VALUE('me')");
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
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

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            System.out.println("Вывод данных таблицы завершен.");
        }
        return null;
    }

    /** Очищение таблицы */
    public static void cleanTable(){
        try {
            connectionTable();
            ps = conn.prepareStatement("TRUNCATE TABLE enemies");
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            System.out.println("Очищение таблицы завершено.");
        }
    }

    /** Для передачи данных в модель таблицы */
    public ResultSet resultSetQuery(String query){
        try {
            connectionTable();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
