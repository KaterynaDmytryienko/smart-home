package smart.home.model;

import java.util.List;

public class House {
    private List<Animal>animals;
    private  List<Person>people;
    private  List<Device>devices;
    private List<Sensor>sensors;
    private List<Item>items;
//    private  List<Room>rooms;
    private  List<Floor>floors;


    private static House house;

    private House(){}
    public static House getHouse(){
        if(house==null){
            house=new House();
        }
        return house;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

//    public List<Room> getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(List<Room> rooms) {
//        this.rooms = rooms;
//    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public static void setHouse(House house) {
        House.house = house;
    }
}

