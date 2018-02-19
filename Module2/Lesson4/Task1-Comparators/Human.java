public class Human implements Comparable<Human>{
    private int age;

    public Human(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                '}';
    }
}
