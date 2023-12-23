package smart.home.activity;

import smart.home.event.Even_Types;
import smart.home.event.Event;
import smart.home.model.*;

import java.util.List;
import java.util.Random;

public class AnimalActivity implements Activity{
    private List<Animal> animals = House.getHouse().getAnimals();
    boolean isBusy;
    House house = House.getHouse();

    public List<Animal> getAnimals() {
        return animals;
    }
@Override
    public Event doSomething(){
        Random rand = new Random();
        Animal selectedAnimal = animals.get(rand.nextInt(animals.size()));

//         if (rand.nextBoolean()) {
//             return enterTheRoom(House.getHouse().getFloors().get(0).getRooms().get(0), people.get(0));
//         } else {
//             return exitTheRoom(House.getHouse().getFloors().get(0).getRooms().get(0), people.get(0));
//         }

        Even_Types[] events = Even_Types.values();
        int min = 3;
        int max = 6; // Since the upper bound is exclusive, set this to 7-1
        int range = max - min + 1;
        int eventIndex = rand.nextInt(range) + min;
        List<Floor>floors = house.getFloors();
        int floorIndex = rand.nextInt(floors.size());

        List<Room>rooms = house.getRooms(floorIndex);
        int roomIndex = rand.nextInt(rooms.size());

        return new Event(events[eventIndex],selectedAnimal,rooms.get(roomIndex));



    }
}
