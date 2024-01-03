package smart.home.model;

public class Person extends Inhabitant {
    private String gender;
    private int age;
    private boolean hasDriveLicense;


    public Person(String name, String gender, int age, boolean hasDriveLicense) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hasDriveLicense = hasDriveLicense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasDriveLicense() {
        return hasDriveLicense;
    }

    public void setHasDriveLicense(boolean hasDriveLicense) {
        this.hasDriveLicense = hasDriveLicense;
    }
}
