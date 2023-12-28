package smart.home.model;


import java.util.List;

public class Garage extends Room{
//    public Garage(){
//        super();
//        setName("Garage");
//    }
    public Garage(List<Device>devices){
        super(devices);
        setName("Garage");
    }
    private List<Car>cars;
    private List<Bicycle> bicycles;

}
