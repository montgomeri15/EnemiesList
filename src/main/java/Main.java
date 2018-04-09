import DataBase.DbManager;

public class Main {

    public static void main(String[] args) {

        DbManager dbManager = new DbManager();

        //dbManager.createTable();
        //dbManager.checkTable();
        //dbManager.fillTable();
        //dbManager.showTable();
        //dbManager.clearTable();

        //MainFrame mainFrame = new MainFrame();
        //mainFrame.ourFrame();

        AddForm addForm = new AddForm();
        addForm.addFrame();

    }
}
