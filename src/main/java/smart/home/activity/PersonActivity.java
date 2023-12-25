package smart.home.activity;

import smart.home.event.Even_Types;
import smart.home.event.Event;
import smart.home.model.*;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class PersonActivity implements Activity{
    private static final Logger LOGGER = Logger.getLogger(PersonActivity.class.getName());

    boolean isBusy;
    House house = House.getHouse();

    private List<Person>people = house.getPeople();

    public List<Person> getPeople() {
        return people;
    }
@Override
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
    public void fixDevice(Person person,Device device) {
        if (device != null) {
            LOGGER.info(person.getName() + " fixing the " + device.getName(device));
            // LOGGER.info(device.getDocumentation().getDocumentationManual());
            //  device.setPerformance(10);
//            Device.ConsumptionRecord latestRecord = device.getLatestConsumptionRecord();
//            latestRecord.setFunctionality(100);
            device.setFunctionality(100);
        }
    }

    public void helpTheChild(Person person){

        LOGGER.info("Helping the child..." + person.getName());
    }

    public void eat(Person person){
        LOGGER.info(person.getName()+" is eating.");
        for(Device d: house.getDevices()){
            if(d instanceof Fridge){
                d.addUser(person.getName());
                break;
            }
        }
    }

    public void drink(Person person){
        LOGGER.info(person.getName()+" is drinking.");
        for(Device d: house.getDevices()){
            if(d instanceof Fridge){
                d.addUser(person.getName());
                break;
            }
        }
    }
    public void play(Person person){
        LOGGER.info("Playing..."+person.getName());
    }
    public void openFridge(Person person){
        LOGGER.info("Opening fridge..." + person.getName());

    }
}
