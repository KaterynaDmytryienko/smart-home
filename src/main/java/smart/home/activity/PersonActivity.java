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
            LOGGER.info(person.getName() + " wants to fix the " + device.getName(device));
            LOGGER.info("Reading Manual:...\n..."
                    +device.getDocumentation().getDocumentationManual());
            LOGGER.info(device.getName(device)+" was fixed!");
            device.setFunctionality(100);
            device.setCurrentState(Device.DeviceState.IDLE);
        }
    }

    public void helpTheChild(Person person){

        LOGGER.info(person.getName()+" is helping the child..." );
    }

    public void eat(Person person,Person selectedToWait){

        LOGGER.info(person.getName()+" is eating.");
        if(selectedToWait!=null){
            LOGGER.info(selectedToWait.getName()+" is waiting on "+person.getName()+ " to finish eating.");

        }
        for(Device d: house.getDevices()){
            if(d instanceof Fridge){
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName()+" finished eating.");
        if(selectedToWait!=null){
            eat(selectedToWait,null);
        }
    }

    public void drink(Person person){
        LOGGER.info(person.getName()+" is drinking.");
        for(Device d: house.getDevices()){
            if(d instanceof Fridge){
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
    }
    public void play(Person person){
        LOGGER.info(person.getName()+" is playing...");
    }
    public void openFridge(Person person){
        LOGGER.info("Opening fridge..." + person.getName());

    }
}
