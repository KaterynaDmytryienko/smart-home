package smart.home;

import smart.home.controller.SmartHouseAPI;


public class  SmartHouseSimulation {
    public static void main(String[] args) {
        SmartHouseAPI smartHouseAPI=new SmartHouseAPI();
        smartHouseAPI.runSimulation();
    }
}

