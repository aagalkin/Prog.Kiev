import java.util.Comparator;

public abstract class Figures implements Comparable<Figures>{
    String name;

    @Override
    public int compareTo(Figures f) {
        return (int)(getSquare() - f.getSquare());
    }

    @Override
    public String toString() {
        return "Figure " + getName() + "{" +
                "square=" + (int)getSquare() +
                '}';
    }

    public String getName() {
        return name;
    }

    public abstract double getSquare();
}
