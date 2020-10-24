import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map p1 = new Map(10, 1);
        Map p2 = new Map(10, 1);
//    m.printmap();
        System.out.println("Enter 1 for playing with other player or Enter 2 for playing with Computer");
        Scanner i = new Scanner(System.in);
        int mode = i.nextInt();
        if (mode == 1) {
            Players one = new Players(p1);
            Players two = new Players(p2);
            System.out.println("Player one select your ships:");
            one.setShip();
            System.out.println("Player two select your ships:");
            two.setShip();
            while (true) {
                System.out.println("Player one turn:");
                one.shoot(p2);
                if (p2.checkfinish() == 1) {
                    System.out.println("Player one Wins:))");
                    break;
                }

                System.out.println("Now its player two turn");
                two.shoot(p1);
                if (p1.checkfinish() == 1) {
                    System.out.println("Player two Wins:))");
                    break;
                }


            }


        }
        else{
            Players one = new Players(p1);
            AI computer = new AI(p2);
            System.out.println("Player one select your ships:");
            one.setShip();
            System.out.println("Computer is setting ships...");
            computer.setShip();
            System.out.println("done");
            p2.printmap(0);
            while (true) {
                System.out.println("Player one turn:");
                one.shoot(p2);
                if (p2.checkfinish() == 1) {
                    System.out.println("Player one Wins:))");
                    break;
                }

                System.out.println("Now its  computer turn");
                computer.shoot(p1);
                if (p1.checkfinish() == 1) {
                    System.out.println("Computer Wins:))");
                    break;
                }


            }
        }
    }

}
