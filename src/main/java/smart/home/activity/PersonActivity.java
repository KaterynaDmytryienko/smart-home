package smart.home.activity;

import smart.home.model.Person;
import smart.home.model.Room;

public class PersonActivity {
    boolean isBusy;
    Person person;//list?
     protected void doSomething(){
         //rand{
         // if(){
         // EventManager.manage(enterRoom(person,room));
         // }
         //
         // }
        //randomly choose activity
     }

     public void enterTheRoom(Room room){
         room.setEmpty(false);
         //output to console

     }
    public void exitTheRoom(Room room){
        room.setEmpty(true);
        //output to console

    }
}
