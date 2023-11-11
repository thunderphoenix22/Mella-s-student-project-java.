import java.util.Scanner;

public class Main {

    static String[] Tname = new String[100];
    static String[] TID = new String[100];
    static String[] TPASS = new String[100];
    static String[] Sname = new String[100];
    static String[] SID = new String[100];
    static String[] SPASS = new String[100];
    static int [] Scores = new int [100];

    public static void main(String[] args) {
        Scanner ms = new Scanner(System.in);
        for (int i=0; i<Tname.length; i++){
        System.out.println("Welcome to Mella's score board. Would you like to register (R) or login (L)?");
        System.out.println("Provide your choice");
        String choice = ms.nextLine();
        if (choice.equals("R")) {
            System.out.println("Are you a teacher (T) or a student (S)?");
            String option = ms.nextLine();
            if (option.equals("T")) {
                TeachDatabaseRegPoint();
            } else if (option.equals("S")) {
                StudentDatabaseRegPoint();
            }
        }
        else if(choice.equals("L")) {
            System.out.println("Are you a teacher(T) or a student(S)?");
            String option = ms.nextLine();
            int w = 0;
            if (option.equals("T")) {
                TeachersDatabaseLogin();
                System.out.println("provide the number of student to put score in");
                int size = ms.nextInt();
                System.out.println("Provide the scores of the students");

                for (w = 0; w < size; w++) {
                    System.out.println("Element" + (w + 1) + ":");
                    double score = ms.nextDouble();
                    if (Scores[w] == 0) {
                        Scores[w] = (int) score;
                    }
                }
                System.out.println("What do you want to do?");
                System.out.println("press 1 for Average score");
                System.out.println("press 2 for highest score");
                System.out.println("press 3 for lowest score");
                System.out.println("press 4 to exit");
                int nums = ms.nextInt();
                if (nums == 1) {
                    AverageScore(Scores,size);
                } else if (nums == 2) {
                    ThehighestScore(Scores);

                } else if (nums == 3) {
                    ThelowestScore(Scores, size);

                } else if (nums == 4) {
                    System.exit(0);
                }


            } else if (option.equals("S")) {
                StudentDatabaseLogin();
                System.out.println((Scores[w]));


            }

        }
        }
    }


    static void TeachDatabaseRegPoint() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Provide your name, ID and password");
        String nam = cs.nextLine();
        String id = cs.nextLine();
        String pass = cs.nextLine();

        for (int i = 0; i < Tname.length; i++) {
            if (Tname[i] == null && TID[i] == null && TPASS[i] == null) {
                Tname[i] = nam;
                TID[i] = id;
                TPASS[i] = pass;
                System.out.println("Welcome teacher " + nam);
                break; // Exit the loop after successful registration
            }
        }
    }

    static void StudentDatabaseRegPoint() {
        Scanner ss = new Scanner(System.in);
        System.out.println("Provide your name, ID and password");
        String snam = ss.nextLine();
        String sid = ss.nextLine();
        String spass = ss.nextLine();

        for (int i = 0; i < Sname.length; i++) {
            if (Sname[i] == null && SID[i] == null && SPASS[i] == null) {
                Sname[i] = snam;
                SID[i] = sid;
                SPASS[i] = spass;
                System.out.println("Welcome student " + snam);
                break;
            }
        }
    }

    static void TeachersDatabaseLogin() {
        Scanner xs= new Scanner(System.in);
        System.out.println("Provide you name, ID and password");
        String TnamIN = xs.nextLine();
        String TidIN = xs.nextLine();
        String TpassIN = xs.nextLine();
        for(int i=0; i<Tname.length; i++){
            if(TnamIN.equals(Tname[i]) && TidIN.equals(TID[i]+"TEACH") && TpassIN.equals(TPASS[i])){
                System.out.println("Welcome teacher " + TnamIN );
            }
        }
    }
    static void StudentDatabaseLogin(){
        Scanner tx= new Scanner(System.in);
        System.out.println("Provide your name, ID and password");
        String SnamIN= tx.nextLine();
        String SidIN= tx.nextLine();
        String SpassIN= tx.nextLine();
        for(int i=0; i< Sname.length; i++){
            if(SnamIN.equals(Sname[i]) && SidIN.equals(SID[i]+"STUD")&& SpassIN.equals(SPASS[i])){
                System.out.println("Welcome student " + SnamIN);
            }
        }
    }
    static void AverageScore(int[] scores, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int score = scores[i];
            sum += score;
        }

        double average = (double) sum / size;
        System.out.println("Average test score: " + average);
    }
    static void ThehighestScore(int[] Students){
        int HighestScore= Integer.MIN_VALUE;
        for (int i=0; i<Students.length; i++){
            if (Students[i]>HighestScore){
                HighestScore= Students[i];
            }

        }
        System.out.println(HighestScore);}
    static void ThelowestScore(int[] Students, int size){
        int LowestScore=Integer.MAX_VALUE;
        for(int i=0; i< size;i++){
            if(Students[i]<LowestScore){
                LowestScore= Students[i];
            }
        }
        System.out.println(LowestScore); }


    }
