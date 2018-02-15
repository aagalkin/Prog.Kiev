public class Main {

    private static DeveloperList developerList = new DeveloperList();

    public static void main(String[] args) {
        developerList.add(new JuniorDeveloper("Mike", 500, 0));
        developerList.add(new JuniorDeveloper("Dima", 500, 1));
        developerList.add(new JuniorDeveloper("Vova", 500, 2));
        developerList.add(new MiddleDeveloper("Sam", 500, 3));
        developerList.add(new SeniorDeveloper("Jack", 500, 5));
        developerList.add(new SeniorDeveloper("Bob", 500, 6));
        developerList.add(new TeamLeadDeveloper("Robby", 500, 7));

        developerList.print();
    }
}
