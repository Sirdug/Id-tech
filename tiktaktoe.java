import java.util.*;
class App{
    static ArrayList<Integer>playerpositions=new ArrayList<Integer>();
    static ArrayList<Integer>cpupositions=new ArrayList<Integer>();
    public static void main(String[] args) {
      char [][] gameboard = {
        {' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '},
      };
      printgameboard(gameboard);
      while(true){
        Scanner scan = new Scanner(System.in);
        System.out.println("Place your piece (1-9):");
        int playerPos = scan.nextInt();
        while(playerpositions.contains(playerPos) || cpupositions.contains(playerPos)){
          System.out.println("Posiiton Taken! Choose new Position (1-9):");
          playerPos = scan.nextInt();
        }
        placepiece(gameboard, playerPos, "player");
        String result = checkwinner();
        if(result.length() > 0){
          printgameboard(gameboard);
          System.out.println(result);
          break;
        }
        Random rand = new Random();
        int cpuPos = rand.nextInt(9)+1;
         while(playerpositions.contains(cpuPos) || cpupositions.contains(cpuPos)){
          cpuPos = rand.nextInt(9)+1;
        }
        placepiece(gameboard, cpuPos, "cpu");
        result = checkwinner();
         if(result.length() > 0){
          printgameboard(gameboard);
          System.out.println(result);
          break;
         }
        printgameboard(gameboard);
      }
  
    }
    public static void printgameboard(char[][]gameboard) {
       for(char [] row:gameboard){
        for(char c:row){
            System.out.print(c);
        }
        System.out.println();
       }
    }
    public static void placepiece(char[][]gameboard,int pos,String user) {
        char symbol = 'x';
        if(user.equals("player")){
            symbol = 'x';
            playerpositions.add(pos);
        }
        else if(user.equals("cpu")){
            symbol = 'o';
            cpupositions.add(pos);
        }
        switch(pos){
            case 1:gameboard[0][0]=symbol; break;
            case 2:gameboard[0][2]=symbol; break;
            case 3:gameboard[0][4]=symbol; break;
            case 4:gameboard[2][0]=symbol; break;
            case 5:gameboard[2][2]=symbol; break;
            case 6:gameboard[2][4]=symbol; break;
            case 7:gameboard[4][0]=symbol; break;
            case 8:gameboard[4][2]=symbol; break;
            case 9:gameboard[4][4]=symbol; break;

        }
    }
    public static String checkwinner(){
       List toprow = Arrays.asList(1,2,3);
       List botrow = Arrays.asList(7,8,9);
       List siderow = Arrays.asList(1,4,7);
       List rigsiderow = Arrays.asList(3,6,9);
       List slantrow = Arrays.asList(1,5,9);
       List middlerow = Arrays.asList(4,5,6);
       List slant2row = Arrays.asList(7,5,3);
       List<List>winning = new ArrayList<List>();
       winning.add(toprow);
       winning.add(botrow);
       winning.add(siderow);
       winning.add(rigsiderow);
       winning.add(slantrow);
       winning.add(middlerow);
       winning.add(slant2row);
       for(List l : winning){
        if(playerpositions.containsAll(l)){
            return "Congrats you Won!";
          }else if(cpupositions.containsAll(l)){
            return "Sorry you Lose!";
          }else if(playerpositions.size() + cpupositions.size() == 9){
            return "Tie!";
          }
       }
        return"";
    }
        
    
}
