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
    public Event doSomething(boolean sportEvent){
         Random rand = new Random();
         Person selectedPerson = people.get(rand.nextInt(people.size()));

    Even_Types[] events = Even_Types.values();

    int min = 2;  // Index of ENTER_ROOM
    int max = 14;
    if(sportEvent){min=0;
        max = 3;
    }
    int range = max - min + 1;
    int eventIndex = rand.nextInt(range) + min;

         List<Floor>floors = house.getFloors();
         int floorIndex = rand.nextInt(floors.size());

         List<Room>rooms = house.getRooms(floorIndex);
         int roomIndex = rand.nextInt(rooms.size());

         return new Event(events[eventIndex],selectedPerson,rooms.get(roomIndex));

     }

    public void fixDevice(Person person,Device device) {
        if (device != null ) {
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

    public void useTreadmill(Person person, Person selectedToWait){
        LOGGER.info(person.getName()+" is using a treadmill.");
        if(selectedToWait!=null){
            LOGGER.info(selectedToWait.getName()+" is waiting on "+person.getName()+ " to finish using treadmill.");

        }
        for(Device d: house.getDevices()){
            if(d instanceof Treadmill){
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName()+" finished using treadmill.");
        if(selectedToWait!=null){
            useTreadmill(selectedToWait,null);
        }
    }

    public void cookInMulticooker(Person person, Person selectedToWait){
        LOGGER.info(person.getName()+" is cooking in a multicooker.");
        if(selectedToWait!=null){
            LOGGER.info(selectedToWait.getName()+" is waiting on "+person.getName()+ " to finish cooking in a multicooker.");

        }
        for(Device d: house.getDevices()){
            if(d instanceof Multicooker){
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName()+" finished using multicooker.");
        if(selectedToWait!=null){
            cookInMulticooker(selectedToWait,null);
        }
    }

    public void listenToMusic(Person person){
        LOGGER.info(person.getName()+" is listening to the music via speakers.");
        for(Device d: house.getDevices()){
            if(d instanceof Speakers){
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName()+" finished listening to music.");
    }

    public void ski(Person person, Person selectedToWait){
        LOGGER.info(person.getName()+" is skiing.");
        if(selectedToWait!=null){
            LOGGER.info(selectedToWait.getName()+" is waiting on "+person.getName()+ " to finish skiing");

        }
        for(Device d: house.getDevices()){
            if(d instanceof Skis){
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName()+" finished skiing.");
        if(selectedToWait!=null){
            ski(selectedToWait,null);
        }
    }

    public void drive(Person person){
        LOGGER.info(person.getName()+" is driving.");
        for(Device d: house.getDevices()){
            if(d instanceof Car){
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName()+" finished driving.");
    }

    public void workout(Person person){
        LOGGER.info(person.getName()+" is working out.");
        LOGGER.info(person.getName()+" finished working out.");
    }
    public void cycle(Person person, Person selectedToWait){
        LOGGER.info(person.getName()+" is cycling.");
        if(selectedToWait!=null){
            LOGGER.info(selectedToWait.getName()+" is waiting on "+person.getName()+ " to finish cycling");

        }
        for(Device d: house.getDevices()){
            if(d instanceof Bicycle){
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName()+" finished cycling.");
        if(selectedToWait!=null){
            cycle(selectedToWait,null);
        }
    }

    public void handleFlood(Person person){
        LOGGER.info(person.getName()+" is calling mechanic while wiping the floor.");
    }
    public void handleHeat(Person person){
        LOGGER.info(person.getName()+" is opening a window");
    }
}
