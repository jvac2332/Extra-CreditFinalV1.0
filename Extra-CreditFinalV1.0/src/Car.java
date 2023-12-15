import java.io.Serializable;

@SuppressWarnings("serial")
public class Car implements Serializable{
    private String make;
    private String model;
    private int year;
    // private variables means that it limits certain functions in context of the same clas




    // Constructors for the the class to help know which year the car is 
    public Car(String make, String model,int year){
        this.make = make;
        this.model = model;
        this.year = year; 
    }

    // The return statements are the Getter functions
    public String getMake() {
        return make;
    }

     public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return model;
    }

    // These are setter Functions 
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Car(){
        make = "";
        model = "";
        year = 0 ;
    }


    //toStringFunction
    @Override
    public String toString(){
        return String.format("Make: %s\tModel: %s\tYear: %d\n",make,model,year);
    }


    

}





