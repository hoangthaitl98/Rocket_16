package TestingSystem;

public class Department implements Comparable<Department>{
    public int id;
    public String name;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Department d) {
        if (name == d.name){
            d.id = id;
            return 1;
        }
        else
            return 0;
    }
}
