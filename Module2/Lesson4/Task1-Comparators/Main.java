import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Humans:");
        Comparator<Human> humanComparator = (h1, h2) -> h2.getAge() - h1.getAge();

        Human[] humans = {new Human(5), new Human(10), new Human(15), new Human(20)};
        Arrays.sort(humans);//Сортировка по возрастанию.
        System.out.println(Arrays.toString(humans));

        Arrays.sort(humans, humanComparator);//Сортировка по убыванию.
        System.out.println(Arrays.toString(humans));

        System.out.println("Figures:");
        Comparator<Figures> figuresComparator = (f1, f2) -> (int)(f2.getSquare() - f1.getSquare());

        Figures[] figures = {new Triangle(12.5, 4, 11.6), new Rectangle(10, 5), new Circle(5)};
        Arrays.sort(figures);//Сортировка по возрастанию.
        System.out.println(Arrays.toString(figures));

        Arrays.sort(figures, figuresComparator);//Сортировка по убыванию.
        System.out.println(Arrays.toString(figures));

    }
}
