import DataBase.DbManager;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {

    private int columnCount =3;
    private ArrayList<String[]> dataArrayList;

    public TableModel(){
        dataArrayList = new ArrayList<String[]>();

        for (int i=0; i<dataArrayList.size(); i++){
            dataArrayList.add(new String[getColumnCount()]);  //Добавив кол-во колонок, мы проинициализировали
        }
    }

    public int getRowCount() {
        return dataArrayList.size();  //Возвращает количество строк (элементов массива)
    }

    public int getColumnCount() {
        return columnCount;
    }

    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0: return "ID";
            case 1: return "Name";
            case 2: return "Status";
        }
        return null;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        String [] rows = dataArrayList.get(rowIndex);  //Получает i-тую строку
        return rows[columnIndex];  //Возвращает i-тый столбец
    }

    public void addData(String[]row){  //Передаем массив строк для каждой i-той ячейки
        String [] rowTable = row;  //Мы можем передать в метод любой массив
        dataArrayList.add(rowTable);  //Добавили 1 строку таблицы
    }

    public void addData(DbManager dbManager){

        try {
            ResultSet resultSet = dbManager.resultSetQuery("SELECT * FROM enemies");

            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String status = resultSet.getString("status");

                String []row = {id, name, status};

                addData(row);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }


    }
}
