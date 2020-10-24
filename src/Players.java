import javafx.util.Pair;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Players {
    Map playermap ;
    public Players(Map map){
        playermap = map;
    }
    public void setShip() {
        int num=1;
        while (num!=2) {
            System.out.println("Placing " + num + "ship");
            System.out.println("Enter ship Cordination:\nX:");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            System.out.println("Y:");
            int y = scanner.nextInt();
            if (x >= playermap.getSize() || y >= playermap.getSize()
                    || x < 0 || y < 0) {
                System.out.println("out of index ");
                num--;
            } else {
                if (playermap.getMap()[x][y] == 1) {
                    System.out.println("Already has a ship");
                    num--;
                } else {
                    System.out.println("Enter the size(2-5)");
                    int size =0;
                    while (true){
                        size = scanner.nextInt();
                        if (size>=2 && size <=5)
                            break;
                        else
                            System.out.println("Must be beetween 2 to 5");
                    }
                    System.out.println("Enter 1 for vertical or 2 for horizontal");
                    int mode = scanner.nextInt();
                    int flag=0;
                    for (int temp = 0; temp<=size ; temp++)
                    {
                        if (mode==1 )
                        {
                            if (x+temp<size) {
                                if (playermap.getMap()[x + temp][y] == 1 && x + temp < size) {
                                    System.out.println("Collapse Beetween ships .. try another one ");
                                    num--;
                                    flag = 1;
                                    break;
                                }
                            }

                        }
                         else
                        {
                            if (y+temp<size) {
                                if (playermap.getMap()[x][y + temp] == 1) {
                                    System.out.println("Collapse Beetween ships .. try another one ");
                                    num--;
                                    flag = 1;
                                    break;
                                }

                            }

                        }
                    }
                    if (mode == 1 && x + size > playermap.getSize() ||
                            mode != 1 && y + size > playermap.getSize()) {
                        System.out.println("Not acceptable ");
                        num--;
                    } else {
                        if (flag ==0) {
                            for (int j = 0; j < size; j++) {

                                playermap.set(x, y, 1);
                                if (mode == 1)
                                    x++;
                                else
                                    y++;
                            }
                        }
                    }

                }
            }
                num++;
                playermap.printmap(0);
            }

    }
    public void shoot(Map enemy){
        System.out.println("Please Enter 1 for normal shooting and 2 for Random shooting");
        Scanner scn = new Scanner(System.in);
        int index = scn.nextInt();

        System.out.println("Enter Cordination for shooting : \n");

        int x,y=0;
        while (true)
        {
            System.out.println("X:");
            x =scn.nextInt();
            System.out.println("Y:");
             y =scn.nextInt();
            if (x >= playermap.getSize() || y >= playermap.getSize()
                    || x < 0 || y < 0) {
                System.out.println("Not valid ,.. please Enter another x and Y");
            }
            else
                break;
        }
        if (index==1) {
            if (enemy.getMap()[x][y] == 1)
                enemy.set(x, y, 2);
            else
                enemy.set(x, y, 3);
        }
        else if (index==2)
        {

            Vector <int[]>points = new Vector();
            for (int i=-1;i<=1;i++)
            {
                for (int j=-1;j<=1;j++)
                {
                    if (x+i >= playermap.getSize() || y+j >= playermap.getSize()
                            || x+i < 0 || y+j < 0) {

                    }
                    else
                    {
                        int [] p=new int [2];
                        p[0] = x+i;
                        p[1] = x+j;
                        points.add(p);
                    }
                }
            }
            Random random = new Random();
            int ind = random.nextInt(points.size());
            int x1 = points.get(ind)[0];
            int y1 = points.get(ind)[1];
            if (enemy.getMap()[x1][y1] == 1)
                enemy.set(x1, y1, 2);
            else
                enemy.set(x1, y1, 3);
        }
       // System.out.println("Enemy Map :");

        //System.out.println("Your Map :");
        playermap.printmap2(enemy);


    }
}
