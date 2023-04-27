import java.util.LinkedList;
import java.util.List;

public class Human implements Comparable<Human>{
    private String last_name;
    private String first_name;
    private String second_name;

    public Human(String last_name, String first_name, String second_name) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.second_name = second_name;
    }


    @Override
    public int compareTo(Human o) {
        String first = (last_name + first_name + second_name);
        String second = (o.last_name + o.first_name + o.second_name);
        return first.compareTo(second);
    }

    @Override
    public String toString() {
        return last_name + " " + first_name + " " + second_name;
    }

    public static void main(String[] args) {
        List<Human> list = new LinkedList<>();
        list.add(new Human("Саливонов", "Никита", "Андреевич"));
        list.add(new Human("Афонин", "Владислав", "Алексеевич"));
        list.add(new Human("Шилин", "Тимур", "Сергеевич"));
        list.add(new Human("Горьков", "Владимир", "Андреевич"));
        list.sort(Human::compareTo);
        System.out.println(list);
    }
}
