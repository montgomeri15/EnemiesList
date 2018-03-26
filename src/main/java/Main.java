import DataBase.DbManager;

public class Main {

    public static void main(String[] args) {

        DbManager dbManager = new DbManager();

        dbManager.createTable();
        dbManager.fillTable();
        dbManager.showTable();

    }
}
