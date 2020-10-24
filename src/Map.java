public class Map {
    private int size=10;
    private int [][] map = new int[size][size];
    int player;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    //0 for water
    //1 for ship
    //2 for sinked ship
    //3 for missed shoots
    public int getSize() {
        return size;
    }

    public Map(int size, int player)
    {
        this.size= size;
        this.player = player;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }
    public void set(int x,int y,int num){
        map[x][y] = num;
    }
    public void printmap(int flag){

        for (int u = 0;u<size;u++)
            System.out.print("| " + u+" ");
        System.out.println("|");
        for (int i=0;i<size;i++)
        {
            System.out.print("----|");
            for (int j=0;j<size-1;j++)
            {
                System.out.print("---+");
            }
            System.out.println();
            System.out.print(i);
            for (int j=0;j<size;j++)
            {
                if (flag == 0) {
                    if (map[i][j] == 1)
                        System.out.print(ANSI_RED_BACKGROUND+"   "+ANSI_RESET+"|");
                    else if (map[i][j] == 2)
                        System.out.print(ANSI_BLUE_BACKGROUND+"   "+ANSI_RESET+"|");
                    else
                        System.out.print("   |");
                }
                if (flag == 1) {

                   if (map[i][j] == 2)
                       System.out.print(ANSI_GREEN_BACKGROUND+"   "+ANSI_RESET+"|");
                   else if (map[i][j] == 3)
                       System.out.print(ANSI_YELLOW_BACKGROUND+"   "+ANSI_RESET+"|");
                    else
                        System.out.print("   |");
                }
            }
            System.out.println();
        }
    }
    public int checkfinish()
    {
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
            {
                if(map[i][j]==1)
                    return 0;
            }
            return 1;
    }
    public void printmap2(Map map2){
        System.out.println("Your Map :                              Enemy Map:");
        for (int u = 0;u<size;u++)
            System.out.print("| " + u+" ");
        System.out.print("|   ");

        for (int u = 0;u<size;u++)
            System.out.print("| " + u+" ");
        System.out.println("|");
        for (int i=0;i<size;i++)
        {
            System.out.print("----|");
            for (int j=0;j<size-1;j++)
            {
                System.out.print("---+");
            }
            System.out.print("   ");
            for (int j=0;j<size-1;j++)
            {
                System.out.print("---+");
            }
            System.out.print("---+");
           System.out.println();
            System.out.print(i);
            for (int j=0;j<size;j++)
            {
                    if (map[i][j] == 1)
                        System.out.print(ANSI_RED_BACKGROUND+"   "+ANSI_RESET+"|");
                    else if (map[i][j] == 2)
                        System.out.print(ANSI_BLUE_BACKGROUND+"   "+ANSI_RESET+"|");
                    else
                        System.out.print("   |");

            }
            System.out.print("  ");
            System.out.print(i);
            for (int j=0;j<size;j++) {
                if (map2.getMap()[i][j] == 2)
                    System.out.print(ANSI_GREEN_BACKGROUND + "   " + ANSI_RESET + "|");
                else if (map2.getMap()[i][j] == 3)
                    System.out.print(ANSI_YELLOW_BACKGROUND + "   " + ANSI_RESET + "|");
                else
                    System.out.print("   |");
            }
            System.out.println();
        }
    }

}
