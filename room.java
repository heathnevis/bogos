
public class room{

  private int numDoors;
  private monster Monster;
  private String desc;
  private item[] treasure;

  private boolean normalQ;
  private boolean hallwayQ;
  private boolean voidQ;

  //to track where each door is in each room
  private boolean hasLeft;
  private boolean hasRight;
  private boolean hasFront;
  private boolean hasBack;

  private boolean playerIsIn;
  private boolean isStart;
  private boolean isBoss;

//normal room creator
public room(int M, String d){
  
  Monster = new monster();
  String name = Monster.getName();
  int level = Monster.getLevel();
  int health = Monster.getHealth();
  int maxDamage = Monster.getMaxDamage();
  int minDamage = Monster.getMinDamage();
  
  desc = d;
  normalQ = true;
  hallwayQ = false;
  voidQ = false;
  treasure = new item[(int)(Math.random()*4)+1];
  for(item a : treasure){
    a = new item();
  }
}

//hallway creator
public room(int M){
  Monster = new monster();
  desc = "You are in a hallway.";
  treasure = null;
  normalQ = false;
  hallwayQ = true;
  voidQ = false;

}

//void room creator
public room(){
  desc = "if you are reading this, something went wrong";
  treasure = null;
  normalQ = false;
  hallwayQ = false;
  voidQ = true;
  hasLeft = false;
  hasRight = false;
  hasFront = false;
  hasBack = false; 

}
//setters for type of room
public void setRoom(String d){
  Monster = new monster();
  
  desc = d;
  treasure = new item[2];
  treasure[0] = new item();
  treasure[1] = new item();
  normalQ = true;
  hallwayQ = false;
  voidQ = false;
}

//hallway creator
public void setHallway(int M){
  Monster = new monster();
  desc = "You are in a hallway.";
  treasure = null;
  normalQ = false;
  hallwayQ = true;
  voidQ = false;
}

//void room creator
public void setVoid(){
  desc = "if you are reading this, something went wrong";
  treasure = null;
  normalQ = false;
  hallwayQ = false;
  voidQ = true;
  hasLeft = false;
  hasRight = false;
  hasFront = false;
  hasBack = false; 
}
//special rooms 
public void setStartRoom(){
  desc = "Welcome to the dungeon!";
  treasure = null;
  normalQ = true;
  hallwayQ = false;
  voidQ = false;
  isStart = true;
  hasFront = true;
  hasRight = true;

}

public void setBossRoom(){
  Monster = new monster("dragon",100, 3, 10, 10); //change stats to be balanced
  Monster.setHealth(100);
  Monster.setLevel(10);
  Monster.setName("dragon");
  Monster.setMinDamage(3);
  Monster.setMaxDamage(10);
  desc = "You are in the lair of the dragon";
  treasure = null;
  //probably setting seperate conditions for this specific room
  normalQ = true;
  hallwayQ = false;
  voidQ = false;
  isBoss = true;
  hasFront = true;
  hasRight = true;
  hasLeft = true;
  hasBack = true;
}


//setters for each of the doors
public void setLeft(boolean b){
  hasLeft = b;
}

public void setRight(boolean b){
  hasRight = b;
}

public void setFront(boolean b){
  hasFront = b;
}

public void setBack(boolean b){
  hasBack = b;
}

public boolean BackQ(){
  return hasBack;
}

public boolean FrontQ(){
  return hasFront;
}

public boolean LeftQ(){
  return hasLeft;
}

public boolean RightQ(){
  return hasRight;
}

public void playerLoc(boolean b){
  playerIsIn = b;
}


public void setDescription(String S){
  desc = S;
}

public void setMonsters(monster M){
  Monster = M;
}

//getters we nay need
public String getDescription(){
  return desc;
}

public monster getMonster(){
  return Monster;
}

public boolean isNormal(){
  return normalQ;
}

public boolean isHallway(){
  return hallwayQ;
}

public boolean isVoid(){
return voidQ;
}

public item[] getTreasure(){
  return treasure;
}

//Need a creator for the choices, some sort of way to generate monsters and treasure based on player playtime, and an overall generation alg.  

}

//Ok so here's what I'm thinking for procedureal generation: Our "dungeon" is gonna be a 2x2 array of room objects. We generate the rooms first, figure out an alg for generating doors in nice locations, and generate hallways connecting the rooms. finally we fill the remaining spaces with void rooms. 

//procedural generation:  

//1: Generate I'd say between 30 and 50 rooms, generate the center room (in the center) and generate the starting room (I would say at one of the 4 corners)


//2: Generate doors connecting each of the rooms: If a room has a wall against a wall of another room, generate doors on appropiate sides. 

//3: Generate hallways between rooms that have 1-2 spaces between them, generating appropiate doors where required

//4: Fill the rest with void rooms

//I'm thinking an 11x11 2d array should be plenty of room for us to figure out where everything goes, and that way the central room can be at the exact center of the dungeon. 