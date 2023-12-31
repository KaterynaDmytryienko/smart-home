package smart.home.model;

import smart.home.event.Even_Types;
import smart.home.event.Event;
import smart.home.event.Observer;
import smart.home.util.documentation.Documentation;
import smart.home.util.documentation.DocumentationLoader;

import java.util.*;

public abstract class Device implements Observer {
    public class Consumption {
        private int electricityConsumption;
        private int gasConsumption;
        private int waterConsumption;

        public Consumption(int electricityConsumption, int gasConsumption, int waterConsumption) {
            this.electricityConsumption = electricityConsumption;
            this.gasConsumption = gasConsumption;
            this.waterConsumption = waterConsumption;
        }

        public int getElectricityConsumption() {
            return electricityConsumption;
        }

        public void setElectricityConsumption(int electricityConsumption) {
            this.electricityConsumption = electricityConsumption;
        }

        public int getGasConsumption() {
            return gasConsumption;
        }

        public void setGasConsumption(int gasConsumption) {
            this.gasConsumption = gasConsumption;
        }

        public int getWaterConsumption() {
            return waterConsumption;
        }

        public void setWaterConsumption(int waterConsumption) {
            this.waterConsumption = waterConsumption;
        }
    }

    public void setActiveConsumption(Consumption activeConsumption) {
        this.activeConsumption = activeConsumption;
    }

    public void setOffConsumption(Consumption offConsumption) {
        this.offConsumption = offConsumption;
    }

    public void setIdleConsumption(Consumption idleConsumption) {
        this.idleConsumption = idleConsumption;
    }

    Consumption activeConsumption;
    Consumption offConsumption;
    Consumption idleConsumption;
    House house = House.getHouse();

    public Map<String, Integer> getUsers() {
        return users;
    }
    public int getUserCount(String name) {
        return users.getOrDefault(name, 0);
    }
    public void addUser(String name) {
        if (users.containsKey(name)) {
            int currentCount = users.get(name);
            users.put(name, currentCount + 1);
        } else {
            users.put(name, 1);
        }
    }

    Map<String, Integer> users = new HashMap<>();

    public enum DeviceState {ACTIVE, IDLE, OFF}

    public DeviceState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(DeviceState currentState) {
        this.currentState = currentState;
    }

    private DeviceState currentState = DeviceState.IDLE;

    public int getFunctionality() {
        return functionality;
    }


    public void setFunctionality(int functionality) {
        this.functionality = functionality;
    }

    private int functionality = 100;

    public static class ConsumptionRecord {
        public int getElectricityConsumption() {
            return electricityConsumption;
        }

        public int getGasConsumption() {
            return gasConsumption;
        }

        public int getWaterConsumption() {
            return waterConsumption;
        }

        int electricityConsumption;
        int gasConsumption;
        int waterConsumption;

        public int getFunctionality() {
            return functionality;
        }

        public void setFunctionality(int functionality) {
            this.functionality = functionality;
        }

        int functionality;
        long timestamp;

        ConsumptionRecord(int electricity, int gas, int water, int functionality, long timestamp) {
            this.electricityConsumption = electricity;
            this.gasConsumption = gas;
            this.waterConsumption = water;
            this.functionality = functionality;
            this.timestamp = timestamp;
        }
    }

    private List<ConsumptionRecord> consumptionHistory = new ArrayList<>();
    public List<ConsumptionRecord> getConsumptionHistory() {
        return consumptionHistory;
    }

    /**
     * Method gets room where current device is located.
     * @return Room
     */
 public Room getCurrentRoom(){
      for(Floor floor:house.getFloors()){
          for(Room room: floor.getRooms()){
              if(room.getDevices()!=null){
              for(Device device: room.getDevices()){
                  if(device == this){
                      return room;
                  }
              }}
          }
      }
      return null;
 }

    public void recordConsumption() {
        int currentElectricityConsumption = 0;
        int currentGasConsumption = 0;
        int currentWaterConsumption = 0;

        switch (currentState) {
            case ACTIVE:
                currentElectricityConsumption = activeConsumption.electricityConsumption;
                currentGasConsumption=activeConsumption.gasConsumption;
                currentWaterConsumption=activeConsumption.waterConsumption;
                break;
            case IDLE:
                currentElectricityConsumption = idleConsumption.electricityConsumption;
                currentGasConsumption=idleConsumption.gasConsumption;
                currentWaterConsumption=idleConsumption.waterConsumption;
                break;
            case OFF:
                currentElectricityConsumption = offConsumption.electricityConsumption;
                currentGasConsumption=offConsumption.gasConsumption;
                currentWaterConsumption=offConsumption.waterConsumption;
                break;
        }

        long currentTime = System.currentTimeMillis();
        consumptionHistory.add(new ConsumptionRecord(currentElectricityConsumption, currentGasConsumption, currentWaterConsumption, functionality, currentTime));
        setCurrentState(DeviceState.IDLE);
        // functionality decreases linearly over time
        functionality--;
    }

    private Documentation documentation;

    public Device() {
        this.documentation = null;
    }

    /**
     * Method returns current device name.
     * @param device
     * @return String deviceName
     */
    public String getName(Device device) {
        if(device instanceof LightDevice){
            return "LightDevice";
        }else if(device instanceof Fridge){
            return "Fridge";
        }else if(device instanceof Bicycle){
            return "Bicycle";
        }else if(device instanceof Car){
            return "Car";
        } else if (device instanceof PetFeeder) {
            return "Pet Feeder";
        } else if (device instanceof Treadmill) {
            return "Treadmill";
        }
        else if(device instanceof Multicooker){
            return "Multicooker";
        }
        else if(device instanceof Speakers){
            return "Speakers";
        }
        else if(device instanceof VacuumCleaner){
            return "Vacuum cleaner";
        }
        return null;
    }

    public Documentation getDocumentation(){
        if(documentation==null){
            documentation=DocumentationLoader.loadDocumentation(this);
        }
        return documentation;
    }

    /**
     * Method allows to downgrade performance by a random value
     * and generates DEVICE_BREAKAGE event if device`s functionality reaches 0 or less.
     */
    public void downgradePerformance(){
        Random rand = new Random();
        int eventIndex = rand.nextInt(6)+3;
        functionality-=eventIndex*5;
        if(functionality<=0){
            Event event=new Event(Even_Types.DEVICE_BREAKAGE,this,getCurrentRoom());
            house.getEventManager().handleEvent(event);
            this.setCurrentState(DeviceState.OFF);
        }
    }


}
