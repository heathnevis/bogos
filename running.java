import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class running {
  private Scanner input;
  private player player1 = new player(); //initialize an instance of player so that stuff works properly with it.

  public running(){
  System.out.println("Welcome to our dungeon crawler game! Your objective is to traverse the dungeon, killing monsters and upgrading your gear until you eventually are ready to beat the dragon in the middle of the dungeon. Each dungeon is randomly generated, meaning that there is no 'best way' to play this game. When you are ready to begin, press 1.");
  Scanner sc = new Scanner(System.in);
  int in = sc.nextInt();
  if(in == 1){
    actions();
  }else{
  actions();
  }
  }

  public void actions() {

    int l = 7;
    int w = 7;
    boolean winCon = false;
    
    room[][] dungeon = new room[l][w];
    for(int a = 0; a < dungeon.length; a++){
      for(int b = 0; b < dungeon[0].length; b++){
        dungeon[a][b] = new room();
      }

    }
    dungeon = Generate(dungeon);

    room current = dungeon[l-1][0];
    System.out.println(current.getDescription());
    int pY = l-1;
    int pX = 0;

    while(winCon != true ){
      
      if(dungeon[3][3].getMonster().getHealth() <= 0){
        winCon = true;
        System.out.println("You have defeated the dungeon. You win!");
      }
      System.out.println(pX + " " + pY);
      int choice = Movement(dungeon[pY][pX]);
      //System.out.println(dungeon[pY][pX].getDescription());

      if(choice == 1){
        pY--;
      }else if(choice == 2){
        pX++;
      }else if(choice == 3){
        pY++;
      }else if(choice == 4){
        pX--;
      }
      //moving to the next room and fighting what's there
      System.out.println(dungeon[pY][pX].getDescription());
      if(dungeon[pY][pX].getMonster().getHealth() > 0){
        player1.fight(dungeon[pY][pX]);
        if(player1.getHealth() > 0){
          for(item a : dungeon[pY][pX].getTreasure()){
            if(a.getType().equals("armor")){
              System.out.println("Do you want to swap your armor?(y/n");
              System.out.println("Current armor: " + player1.getArmor());
              System.out.println("New armor: " + a);
              input = new Scanner(System.in);
              String answer = input.next();
              if(answer.equals("y"))
                player1.setArmor(a);
              if(answer.equals("fish"))
                player1.setDefense(50);
              
            }
            if(a.getType().equals("weapon")){
              System.out.println("Do you want to swap your weapon?(y/n");
              System.out.println("Current weapon: " + player1.getWeapon());
              System.out.println("New weapon: " + a);;
              input = new Scanner(System.in);
              String answer = input.next();
              if(answer.equals("y"))
                player1.setWeapon(a);
              if(answer.equals("fish"))
                player1.setDefense(50);
            }
          }
          
        }
      }
       
      
    }
  }


public  room[][] Generate(room[][] arr){
  double chance = Math.random();
  String words = new String();
  //setting initial rooms with an initial pass

  
  for(room[] R : arr){ 
    //R = new room[R.length]; DO NOT USE
    for(room rm : R){
      //rm = new room(); DO NOT USE
      chance = Math.random();
      if(chance > 0.1){ 
       
        //sets to be normal rooms
        rm.setRoom(words);

        //testing
        //System.out.println(rm.isNormal());
      }else{
        rm.setVoid();
      }
    }
  }

  //setting speciality rooms
  arr[arr.length - 1][0] = new room();
  arr[arr.length - 1][0].setStartRoom();

  //arr[arr.length / 2 + 1][arr.length / 2 + 1] = new room();
  arr[arr.length / 2 + 1][arr.length / 2 + 1].setBossRoom();


//DOORS (1)

  for(int i = 0; i < arr.length; i++){
    for(int j = 0; j < arr.length - 1; j++){

      room current = arr[i][j];
      room check = arr[i][j+1];
      //System.out.println(current.isNormal() + " " + check.isNormal());

      if(current.isNormal() == true && check.isNormal()== true){
      //System.out.println("ok");
      current.setRight(true);
      check.setLeft(true);
      }
    }
  }

  
  for(int i = 0; i < arr.length - 1; i++){
    for(int j = 0; j < arr.length; j++){

      room current = arr[i][j];
      room check = arr[i+1][j];
      //System.out.println(current.isNormal() + " " + check.isNormal());
      
      if(current.isNormal() == true && check.isNormal() == true){
      
      current.setBack(true);
      check.setFront(true);
      }
    }
  }
  return arr;
  }

//returns either 1, 2, 3, or 4, corresponding to where the player wants to move.
  public  int Movement(room R){
    Scanner sc = new Scanner(System.in);
    int count = 0;
    ArrayList<String> choice = new ArrayList<String>();
    ArrayList<Integer> c = new ArrayList<Integer>();

    if(R.FrontQ()){
      count++;
      String c1 = "(1) Go through the door at 12 o clock";
      choice.add(c1);
      c.add(1);
    }

    if(R.RightQ()){
      count++;
      String c2 = "(2) Go through the door at 3 o clock";
      choice.add(c2);
      c.add(2);
    }

    if(R.BackQ()){
      count++;
      String c3 = "(3) Go through the door at 6 o clock";
      choice.add(c3);
      c.add(3);
    }

    if(R.LeftQ()){
      count++;
      String c4 = "(4) Go through the door at 9 o clock";
      choice.add(c4);
      c.add(4);
    }
    //for(String s : choice){
      //c++;
      //System.out.println(c + ": " + s);
    //}
    System.out.println(choice);
    
    int n = sc.nextInt();

    if(isIn(n,c) == true){
      return n;
    }else{
      n = 1;
      return n;
    }
  }


  public  void movePlayer(room[][] arr, int playerx, int playery, int choice){

    room current = arr[playery][playerx];
    current.playerLoc(false);

    if(choice == 1){
      arr[playery - 1][playerx].playerLoc(true);
    }else if(choice == 2){
      arr[playery][playerx + 1].playerLoc(true);
    }else if (choice == 3){
      arr[playery + 1][playerx].playerLoc(true);
    }else if (choice == 4){
      arr[playery][playerx - 1].playerLoc(true);
    }

  }


  public boolean isIn(int num, ArrayList<Integer> arr){
    for(int N : arr)
  {
    if (N == num)
      return true;
  }

  return false;
}
  


}

