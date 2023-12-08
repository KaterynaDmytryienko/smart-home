package smart.home.model;


import java.util.List;

public class Garage extends Room{
    public Garage(){
        super();
        setName("Garage");
    }
    private List<Car>cars;
    private List<Bicycle> bicycles;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Bicycle> getBicycles() {
        return bicycles;
    }

    public void setBicycles(List<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }
}
