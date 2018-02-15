import java.util.Arrays;

public class DeveloperList {
    private Developer developerList[] = new Developer[0];
    private int developerListCount = 0;

    private JuniorDeveloper juniorDeveloperList[] = new JuniorDeveloper[0];
    private int juniorListCount = 0;

    private MiddleDeveloper middleDeveloperList[] = new MiddleDeveloper[0];
    private int middleListCount = 0;

    private SeniorDeveloper seniorDeveloperList[] = new SeniorDeveloper[0];
    private int seniorListCount = 0;

    private TeamLeadDeveloper teamLeadDeveloperList[] = new TeamLeadDeveloper[0];
    private int teamLeadCount = 0;

    public void add(Developer developer){
        if (developerListCount > developerList.length - 1){
            developerList = Arrays.copyOf(developerList, developerList.length + 1);
            developerList[developerListCount++] = developer;
            addToSpecialList(developer);
        }else{
            developerList[developerListCount++] = developer;
            addToSpecialList(developer);
        }
    }

    private void addJunior(JuniorDeveloper developer){
        if (juniorListCount > juniorDeveloperList.length - 1){
            juniorDeveloperList = Arrays.copyOf(juniorDeveloperList, juniorDeveloperList.length + 1);
            juniorDeveloperList[juniorListCount++] = developer;
        }else{
            juniorDeveloperList[juniorListCount++] = developer;
        }
    }

    private void addMiddle(MiddleDeveloper developer){
        if (middleListCount > middleDeveloperList.length - 1){
            middleDeveloperList = Arrays.copyOf(middleDeveloperList, middleDeveloperList.length + 1);
            middleDeveloperList[middleListCount++] = developer;
        }else{
            middleDeveloperList[middleListCount++] = developer;
        }
    }

    private void addSenior(SeniorDeveloper developer){
        if (seniorListCount > seniorDeveloperList.length - 1){
            seniorDeveloperList = Arrays.copyOf(seniorDeveloperList, seniorDeveloperList.length + 1);
            seniorDeveloperList[seniorListCount++] = developer;
        }else{
            seniorDeveloperList[seniorListCount++] = developer;
        }
    }

    private void addTeamLead(TeamLeadDeveloper developer){
        if (teamLeadCount > teamLeadDeveloperList.length - 1){
            teamLeadDeveloperList = Arrays.copyOf(teamLeadDeveloperList, teamLeadDeveloperList.length + 1);
            teamLeadDeveloperList[teamLeadCount++] = developer;
        }else{
            teamLeadDeveloperList[teamLeadCount++] = developer;
        }
    }

    private void addToSpecialList(Developer developer){
        if (developer instanceof JuniorDeveloper){
            addJunior((JuniorDeveloper)developer);
        }
        else if (developer instanceof MiddleDeveloper){
            addMiddle((MiddleDeveloper)developer);
        }
        else if (developer instanceof SeniorDeveloper){
            addSenior((SeniorDeveloper)developer);
        }
        else if (developer instanceof TeamLeadDeveloper){
            addTeamLead((TeamLeadDeveloper)developer);
        }
    }

    public void print(){
        System.out.println("all developers: \n");
        for (Developer d : developerList){
            StringBuilder sb = new StringBuilder()
                    .append(d.getName())
                    .append(": ")
                    .append(d.getBasicSalary())
                    .append(" -> ")
                    .append(d.getSalary());
            System.out.println(sb.toString());
        }
        System.out.println("");
        juniorPrint();
        middlePrint();
        seniorPrint();
        teamLeadPrint();
        developersWithBigSalaryPrint();
    }

    private void juniorPrint(){
        System.out.println("junior developers: \n");
        for (JuniorDeveloper j : juniorDeveloperList){
            StringBuilder sb = new StringBuilder()
                    .append(j.getName())
                    .append(": ")
                    .append(j.getBasicSalary())
                    .append(" -> ")
                    .append(j.getSalary());
            System.out.println(sb.toString());
        }
        System.out.println("");
    }

    private void middlePrint(){
        System.out.println("middle developers: \n");
        for (MiddleDeveloper m : middleDeveloperList){
            StringBuilder sb = new StringBuilder()
                    .append(m.getName())
                    .append(": ")
                    .append(m.getBasicSalary())
                    .append(" -> ")
                    .append(m.getSalary());
            System.out.println(sb.toString());
        }
        System.out.println("");
    }

    private void seniorPrint(){
        System.out.println("senior developers: \n");
        for (SeniorDeveloper s : seniorDeveloperList){
            StringBuilder sb = new StringBuilder()
                    .append(s.getName())
                    .append(": ")
                    .append(s.getBasicSalary())
                    .append(" -> ")
                    .append(s.getSalary());
            System.out.println(sb.toString());
        }
        System.out.println("");
    }

    private void teamLeadPrint(){
        System.out.println("teamLead developers: \n");
        for (TeamLeadDeveloper tl : teamLeadDeveloperList){
            StringBuilder sb = new StringBuilder()
                    .append(tl.getName())
                    .append(": ")
                    .append(tl.getBasicSalary())
                    .append(" -> ")
                    .append(tl.getSalary());
            System.out.println(sb.toString());
        }
        System.out.println("");
    }

    private void developersWithBigSalaryPrint(){
        System.out.println("developers with salary more than 1500: \n");
        for (Developer d : developerList){
            if (d.getSalary() >= 1500){
                StringBuilder sb = new StringBuilder()
                        .append(d.getName())
                        .append(": ")
                        .append(d.getBasicSalary())
                        .append(" -> ")
                        .append(d.getSalary());
                System.out.println(sb.toString());
            }
        }
    }
}
