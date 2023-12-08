package smart.home.activity;

import smart.home.event.Even_Types;
import smart.home.event.Event;
import smart.home.model.*;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class PersonActivity {
    private static final Logger LOGGER = Logger.getLogger(PersonActivity.class.getName());
    private List<Person>people = House.getHouse().getPeople();
    boolean isBusy;
    House house = House.getHouse();

    public List<Person> getPeople() {
        return people;
    }

    public Event doSomething(){
         Random rand = new Random();
         Person selectedPerson = people.get(rand.nextInt(people.size()));

//         if (rand.nextBoolean()) {
//             return enterTheRoom(House.getHouse().getFloors().get(0).getRooms().get(0), people.get(0));
//         } else {
//             return exitTheRoom(House.getHouse().getFloors().get(0).getRooms().get(0), people.get(0));
//         }

         Even_Types[] events = Even_Types.values();
         int eventIndex = rand.nextInt(events.length);

         List<Floor>floors = house.getFloors();
         int floorIndex = rand.nextInt(floors.size());

         List<Room>rooms = house.getRooms(floorIndex);
         int roomIndex = rand.nextInt(rooms.size());

         return new Event(events[eventIndex],selectedPerson,rooms.get(roomIndex));



     }

//     public Event enterTheRoom(Room room, Person person){
//         System.out.println("Entered" + person.getName());
//         return new Event(Even_Types.ENTER_ROOM, person, room);
//     }
//    public Event exitTheRoom(Room room, Person person){
//        System.out.println("Exit" + person.getName());
//        return new Event(Even_Types.FLOOD, person, room);
//    }

    public void helpTheChild(Person person){
        LOGGER.info("Helping the child..." + person.getName());
    }

    public void openFridge(Person person){
        LOGGER.info("Opening fridge..." + person.getName());

    }
}
