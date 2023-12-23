package smart.home.model;

import smart.home.controller.SmartHouseAPI;
import smart.home.event.Even_Types;
import smart.home.event.Event;
import smart.home.event.Observer;
import smart.home.util.Documentation;
import smart.home.util.DocumentationLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Device implements Observer {
    House house = House.getHouse();

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
    private int activeConsumption;
    private int idleConsumption;
    private int offConsumption;

    public static class ConsumptionRecord {
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
                currentElectricityConsumption = activeConsumption;
                // Add logic for gas and water consumption if applicable
                break;
            case IDLE:
                currentElectricityConsumption = idleConsumption;
                // Add logic for gas and water consumption if applicable
                break;
            case OFF:
                currentElectricityConsumption = offConsumption;
                // Add logic for gas and water consumption if applicable
                break;
        }

        long currentTime = System.currentTimeMillis(); // Or your simulation's time
        consumptionHistory.add(new ConsumptionRecord(currentElectricityConsumption, currentGasConsumption, currentWaterConsumption, functionality, currentTime));

        // Decrease functionality linearly over time
        functionality--; // Adjust the decrement as per your simulation's needs
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

    public  String getName(Device device) {
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

//    public void setCurrentConsumption(int currentConsumption) {
//        this.currentConsumption = currentConsumption;
//    }


    public void setActiveConsumption(int activeConsumption) {
        this.activeConsumption = activeConsumption;
    }

    public void setOffConsumption(int offConsumption) {
        this.offConsumption = offConsumption;
    }

    public int getIdleConsumption() {
        return idleConsumption;
    }

    public void setIdleConsumption(int idleConsumption) {
        this.idleConsumption = idleConsumption;
    }

    public abstract void updateConsumption();
    public abstract void getsBroken();
}
