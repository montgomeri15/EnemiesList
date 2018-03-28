import javax.swing.table.AbstractTableModel;
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

    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public void addDate(String[]row){  //Передаем массив строк для каждой i-той ячейки
        String [] rowTable = row;  //Мы можем передать в метод любой массив

        dataArrayList.add(rowTable);  //Добавили 1 строку таблицы
    }
}
