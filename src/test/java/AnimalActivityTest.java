import org.junit.Test;
import smart.home.event.EventTypes;
import smart.home.event.Event;
import smart.home.event.EventManager;
import smart.home.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AnimalActivityTest {
    @Test
    public void animalPlayTest(){
        House house = House.getHouse();
        Animal animal=new Animal("Bird","Mandarinka");
        Floor floor = new Floor(1);
        Room room = new LivingRoom();
        Item item = new Item(1, "feather");
       List<Animal> animals = new ArrayList<>();
        List<Floor>floors = new ArrayList<>();
        List<Room>rooms = new ArrayList<>();
        List<Item>items = new ArrayList<>();
         items.add(item);
        floors.add(floor);
        animals.add(animal);
        house.setFloors(floors);
        house.setItems(items);
        floor.setRooms(rooms);
        house.setAnimals(animals);
        Event event=new Event(EventTypes.PLAY,animal,room);
        EventManager eventManager=new EventManager();
        eventManager.handleEvent(event);

        assertTrue(event.isHandled);

    }

    @Test
    public void animalThirstyTest(){
        House house = House.getHouse();
        Animal animal=new Animal("Bird","Mandarinka");
        Floor floor = new Floor(1);
        Room room = new LivingRoom();
        List<Animal> animals = new ArrayList<>();
        List<Floor>floors = new ArrayList<>();
        List<Room>rooms = new ArrayList<>();
        floors.add(floor);
        animals.add(animal);
        house.setFloors(floors);
        floor.setRooms(rooms);
        house.setAnimals(animals);
        Event event=new Event(EventTypes.ANIMAL_THIRSTY,animal,room);
        PetFeeder petFeeder = new PetFeeder();
        petFeeder.update(event);

        assertTrue(event.isHandled);

    }
    @Test
    public void animalHungryTest(){
        House house = House.getHouse();
        Animal animal=new Animal("Bird","Mandarinka");
        Floor floor = new Floor(1);
        Room room = new LivingRoom();
        List<Animal> animals = new ArrayList<>();
        List<Floor>floors = new ArrayList<>();
        List<Room>rooms = new ArrayList<>();
        floors.add(floor);
        animals.add(animal);
        house.setFloors(floors);
        floor.setRooms(rooms);
        house.setAnimals(animals);
        Event event=new Event(EventTypes.ANIMAL_HUNGRY,animal,room);
        PetFeeder petFeeder = new PetFeeder();
        petFeeder.update(event);

        assertTrue(event.isHandled);

    }
}
