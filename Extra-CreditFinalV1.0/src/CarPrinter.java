import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
// These imports help with setting up how to run the code with no erros
public class CarPrinter {
    public  static void printToTextFile(ArrayList<Car> storage){
        // The boolean to the print text file lets me know where I can send my first set of infomation 
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("cars.txt"))));
            for (Car car : storage){
                pw.print(car);
                    // The printwriter allows me to access the file path of what I want to put i
            }
            pw.close();
            System.out.println("File was saved");
        } catch (Exception ex){
            System.out.println("File not saved ");
            
        }
   // The return and return false allows to find whatever the statement was
    }

    public static void printToXMLFile(ArrayList<Car> storage){
        try{
            XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File("cars.xml"))));
            // the Xml encoder allows the user to store that  information in there file
            enc.writeObject(storage);
            enc.close();

            System.out.println("XML was saved");
        } catch (Exception ex){
            System.out.println("XML not saved ");
        }

    }

    
    

    
}
