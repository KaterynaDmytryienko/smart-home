package smart.home.model;

import java.util.List;

public class Bathroom extends Room {
 private FloodSensor floodSensor;

 public Bathroom(List<Device> devices){
  super(devices);
  setFloodSensor(new FloodSensor());
  setName("Bathroom");
 }

 public Bathroom(){
  super();
  setFloodSensor(new FloodSensor());
  setName("Bathroom");
 }
 public FloodSensor getFloodSensor() {
  return floodSensor;
 }

 public void setFloodSensor(FloodSensor floodSensor) {
  this.floodSensor = floodSensor;
 }

}
