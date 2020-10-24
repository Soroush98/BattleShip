import java.util.Random;
import java.util.Vector;

public class AI extends Players {

    public AI(Map map) {
        super(map);
    }

    @Override
    public void setShip() {
        int num=1;
        while (num<=5)
        {
            Random s = new Random(System.currentTimeMillis());
            int t=0,c=0;
            for (int i=0;i<playermap.getSize();i++)
                for (int j=0;j<playermap.getSize();j++)
                    if (playermap.getMap()[i][j]!=1)
                        t++;
            int all = s.nextInt(t);
            int size = s.nextInt(4)+2;
            int flag=0;

            for (int i=0;i<playermap.getSize();i++) {
                for (int j = 0; j < playermap.getSize(); j++) {
                    flag = 0;
                    if (playermap.getMap()[i][j] != 1)
                        c++;
                    if (c == all) {

                        if (i + size <= playermap.getSize() &&
                                j + size <= playermap.getSize()) {
                            for (int k = 0; k < size; k++) {
                                if (playermap.getMap()[i][j + k] == 1 || playermap.getMap()[i + k][j] == 1) {
                                    flag = 1;
                                }
                            }
                            if (flag == 1)
                                break;

                            else if (flag ==0 ) {
                                Random r1 = new Random();
                                int vertindex = r1.nextInt(2);
                                for (int k = 0; k < size; k++) {
                                    if (vertindex == 1)
                                    playermap.set(i+k,j,1);
                                    else
                                        playermap.set(i,j+k,1);
                                    }
                                num++;
                            }
                        }
                    }
                    if (flag == 1)
                        break;
                }

            }
        }
    }

    @Override
    public void shoot(Map enemy) {
        Vector <int []> exceptions = new <int[]>Vector();
        int c=0;
        for (int i=0;i<playermap.getSize();i++)
            for (int j=0;j<playermap.getSize();j++)
            {
                c++;
                for (int u = 0 ;u<exceptions.size();u++) {
                    int[] points = exceptions.get(u);
                    int x = points[0];
                    int y = points[1];
                    if (x==i && y==j)
                        c--;
                }
            }
            Random r = new Random();
            int all =r.nextInt(c);
            int temp=0,flag=0;
        for (int i=0;i<playermap.getSize();i++) {
            for (int j = 0; j < playermap.getSize(); j++) {
                if (temp == all) {
                    if (enemy.getMap()[i][j]==1){
                        enemy.set(i,j,2);

                    }
                    else {
                        enemy.set(i,j,3);

                    }
                    int [] p =new int [2];
                    p[0] = i;
                    p[1] = j;
                    exceptions.add(p);
                    flag = 1;
                    break;
                }
                if (enemy.getMap()[i][j] != 2 && enemy.getMap()[i][j] != 3)
                    temp ++;

            }
            if (flag == 1)
                break;
        }
      //  System.out.println("Your Map :");

        //System.out.println("Computer Map :");
        playermap.printmap2(enemy);

    }
}
