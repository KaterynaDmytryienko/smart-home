package smart.home.util;

import smart.home.controller.DeviceAPI;
import smart.home.controller.DeviceAPII;
import smart.home.model.Device;
import smart.home.model.House;

public class ConsumptionReport extends Report{
    public ConsumptionReport() {
    }

    @Override
    protected String prepareReportContent() {

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Device consumption report\n");
        House house=House.getHouse();
        DeviceAPI<Device> deviceAPI = new DeviceAPII<>();
        double totalElectricity=0.0;
        double totalGas=0.0;
        double totalWater=0.0;
        double totalCost=0.0;
        for(Device device:house.getDevices()){
            deviceAPI.collectDeviceData(device);
            reportBuilder.append("\n\n"+device.getName(device)+"\n");

            double elct=deviceAPI.getTotalElectricityConsumption(device);
            totalElectricity+=elct;
            reportBuilder.append("Electricity:").append(String.format("%.2f",elct) + " kWh");

            double gas=deviceAPI.getTotalGasConsumption(device);
            totalGas+=gas;
            reportBuilder.append("\t\tGas:").append( String.format("%.2f",gas)+" cubic meters");

            double wtr=deviceAPI.getTotalWaterConsumption(device);
            totalWater+=wtr;
            reportBuilder.append("\t\tWater:").append( String.format("%.2f",wtr)+" gallons");

            double cost=deviceAPI.getFinancialCost(device);
            totalCost+=cost;
            reportBuilder.append("\nTotal daily financial cost: ").append( String.format("%.2f",cost)+" $$$");

        }

        reportBuilder.append("\n\n\tOVERALL DAILY USAGE\n");
        reportBuilder.append("Electricity: ").append( String.format("%.2f",totalElectricity) + " kWh");
        reportBuilder.append("\t\tGas: ").append( String.format("%.2f",totalGas)+" cubic meters");
        reportBuilder.append("\t\tWater: ").append( String.format("%.2f",totalWater)+" gallons");
        reportBuilder.append("\nTotal daily financial cost: ").append( String.format("%.2f",totalCost)+" $$$");


        return reportBuilder.toString();



    }
}
