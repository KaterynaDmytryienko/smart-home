package smart.home.model;

import smart.home.event.EventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class House {
    private EventManager eventManager;
    private List<Animal>animals;
    private  List<Person>people;
    private  List<Device>devices;
    private List<Sensor>sensors;
    private List<Item>items;
    private  List<Floor>floors;
    private static House house;

    private House(){}
    public static House getHouse(){
        if(house==null){
            house=new House();
        }
        return house;
    }
    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
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
        List<Device>devices1=new ArrayList<>();
        for(Floor floor : house.getFloors()){
            for(Room room : floor.getRooms()) {
                if(room.getDevices()!=null){
                    for (Device d: room.getDevices()) devices1.add(d);
                }
            }

        }

        return devices1;
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

    public List<Room> getRooms(int floorIndex) {
        return floors.get(floorIndex).getRooms();
    }
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

