import java.util.ArrayList;

public class app {
   public static void main(String[] args){
        ArrayList<Car> storages = new ArrayList<Car>();
        /*storages.add(new Car("", "","",0));
        //print What region of cars would like to display
        if(CarPrinter.printToTextFile(storages, "")){
            System.out.println("File Saved");
        } else {
            System.out.print("File Error");
        }
        if(CarPrinter.printToXMLFile(storages, "")){
            System.out.println("File Saved");
        } else {
            System.out.print("File Error");
        }    */
        
        MainFrame frame = new MainFrame(storages);
        frame.setVisible(true);
   } 
}
