package smart.home.model;

import smart.home.controller.SmartHouseAPI;
import smart.home.event.Even_Types;
import smart.home.event.Event;
import smart.home.event.Observer;
import smart.home.util.Documentation;
import smart.home.util.DocumentationLoader;

import java.sql.Struct;
import java.util.*;

public abstract class Device implements Observer {
    public class Consumption {
        private int electricityConsumption;
        private int gasConsumption;
        private int waterConsumption;

        // Constructors, getters, setters, etc.

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

    private int functionality = 100; // Assuming 100 is the max functionality
//    private int activeConsumption;
//    private int idleConsumption;
//    private int offConsumption;

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

//    public ConsumptionRecord getLatestConsumptionRecord() {
//        if (!consumptionHistory.isEmpty()) {
//            return consumptionHistory.get(consumptionHistory.size() - 1);
//        }
//        return null;
//    }
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

        // functionality decreases linearly over time
        functionality--;
    }

    private Documentation documentation;

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getPerformance() {
        return performance;
    }

    private int performance =10;


    public Device() {
        this.documentation = null;
    }

    public String getName(Device device) {
        if(device instanceof LightDevice){
            String documentationFilePath = "path.txt";
            return "LightDevice";
        }else if(device instanceof Fridge){
            String documentationFilePath = "path.txt";
            return "Fridge";
        }else if(device instanceof Bicycle){
            String documentationFilePath = "path.txt";
            return "Bicycle";
        }else if(device instanceof Car){
            String documentationFilePath = "path.txt";
            return "Car";
        }

        return null;
    }

    public Documentation getDocumentation(){
        if(documentation==null){
            documentation=DocumentationLoader.loadDocumentation(this);
        }
        return documentation;
    }

  //  public int getCurrentConsumption() {
//        return currentConsumption;
//    }
    public void downgradePerformance(){
        Random rand = new Random();
        int eventIndex = rand.nextInt(6)+3;
        functionality-=eventIndex*5;
        if(functionality<=0){
            Event event=new Event(Even_Types.DEVICE_BREAKAGE,this,getCurrentRoom());
            house.getEventManager().handleEvent(event);

        }
    }

//    public void setActiveConsumption(int activeConsumption) {
//        this.activeConsumption = activeConsumption;
//    }

//    public void setOffConsumption(int offConsumption) {
//        this.offConsumption = offConsumption;
//    }
//
//    public int getIdleConsumption() {
//        return idleConsumption;
//    }
//
//    public void setIdleConsumption(int idleConsumption) {
//        this.idleConsumption = idleConsumption;
//    }

    public abstract void updateConsumption();
    public abstract void getsBroken();
}
