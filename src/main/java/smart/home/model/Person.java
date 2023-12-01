package smart.home.model;

import smart.home.util.Documentation;

public class Person {
    private String name;
    private String gender;
    private int age;
    private boolean hasDriveLicense;


    public Person(String name, String gender, int age, boolean hasDriveLicense) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hasDriveLicense = hasDriveLicense;
    }

    public void accessDocumentation(Device device){
        Documentation documentation=device.getDocumentation();
        if(documentation!=null){

        }else{

        }

    }
}
