import java.lang.Math;

public class monster{

  private String name;
  private int health;
  private int minDamage;
  private int maxDamage;
  private int level;


  public monster(String newName, int hp, int minDmg, int maxDmg, int lvl){
    name = newName;
    health = hp;
    minDamage = minDmg;
    maxDamage = maxDmg;
    level = lvl;
  }

  public monster(){
    name = "";
    level = (int)(Math.random() * 5);
    int temp = (int)(Math.random()*11);
      switch(temp){
        case 0: name += "goblin"; break;
        case 1: name += "hobgoblin"; break;
        case 2: name += "troll"; break;
        case 3: name += "gnoll"; break;
        case 4: name += "bugbear"; break;
        case 5: name += "orc"; break;
        case 6: name += "ogres"; break;
        case 7: name += "vampire"; break;
        case 8: name += "zombie"; break;
        case 9: name += "golem"; break;
        case 10: name += "fish"; break;
      }
    health = (int)(Math.random()*6) * level + 5;
    minDamage = (int)(Math.random() * 5);
    maxDamage = minDamage + (int)(Math.random() * 4) + 1;
  }

  public void setName(String newName){
    name = newName;
  }
  public String getName(){
    return name;
  }

  public void setHealth(int newHealth){
    health = newHealth;
  }
  public int getHealth(){
    return health;
  }

  public void setMinDamage(int newMinDamage){
    minDamage = newMinDamage;
  }
  public int getMinDamage(){
    return minDamage;
  }

  public void setMaxDamage(int newMaxDamage){
    maxDamage = newMaxDamage;
  }
  public int getMaxDamage(){
    return maxDamage;
  }

  public int calculateDamage(){
    return((int)(Math.random()*(maxDamage - minDamage + 1) + minDamage));
  }

  public void setLevel(int newLevel){
    level = newLevel;
  }
  public int getLevel(){
    return level;
  }

  public String toString(){
    return("Name: " + name + "\nHealth: " + health + "\nDamage range: " + minDamage + ", " + maxDamage + "\nLevel: " + level);
  }




}