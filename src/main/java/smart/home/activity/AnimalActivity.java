package smart.home.activity;

import smart.home.event.EventManager;
import smart.home.event.EventTypes;
import smart.home.event.Event;
import smart.home.model.*;

import java.util.List;
import java.util.Random;

public class AnimalActivity implements Activity {
    private List<Animal> animals = House.getHouse().getAnimals();
    House house = House.getHouse();
    /**
     * Method generates random animal events on a random floor in a random room.
     *
     * @param sportEvent A boolean flag indicating whether the generated event is sport-related.
     * @return An instance of the Event representing the randomly generated event.
     */
    @Override
    public Event doSomething(boolean sportEvent) {
        EventManager eventManager=house.getEventManager();
        Random rand = new Random();
        Animal selectedAnimal = animals.get(rand.nextInt(animals.size()));

        EventTypes[] events = EventTypes.values();
        int min = eventManager.getFIRST_ANIMAL_EVENT_INDEX();
        int max = eventManager.getLAST_ANIMAL_EVENT_INDEX();

        int range = max - min + 1;
        int eventIndex = rand.nextInt(range) + min;
        List<Floor> floors = house.getFloors();
        int floorIndex = rand.nextInt(floors.size());
        List<Room> rooms = house.getRooms(floorIndex);
        int roomIndex = rand.nextInt(rooms.size());

        return new Event(events[eventIndex], selectedAnimal, rooms.get(roomIndex));

    }

    /**
     * Method returns randomly chosen item.
     *
     * @return A randomly chosen Item from the house's items list.
     */
    public Item getRandomItem() {
        Random rand = new Random();
        return house.getItems().get((rand.nextInt(house.getItems().size())));
    }

    /**
     * Method allows an animal to play with chosen item.
     *
     * @param animal The animal to play with the chosen item.
     */
    public void play(Inhabitant animal) {
        System.out.println(animal.getName() + " is playing with " + getRandomItem().getName());
    }
}