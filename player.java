import java.util.*;
import java.lang.*;


public class player extends monster{

  private int defense;
  private item armor;
  private item weapon;
  

  public player(){
    super();
    this.setName("player");
    armor = new item(1, "armor", 1, 1, 0);
    weapon = new item(1, "weapon", 0, 0, 2);
  }

  public String toString(){
    return (super.toString() + "\nDefense: " + defense);
  }

  public void setDefense(int def){
    defense = def;
  }
  public int getDefense(){
    return defense;
  }
  
  public void damage(int dmg){
    if(dmg <= defense){
    }
    else
      super.setHealth(super.getHealth() - (dmg - defense));
  }

  public void setArmor(item newArmor){
    defense = defense - armor.getBonusDefense();
    armor = newArmor;
    super.setHealth(super.getHealth() + armor.getBonusHealth());
    defense = defense + armor.getBonusDefense();
  }
  
  public String getArmor(){
    return armor.toString();
  }

  public void setWeapon(item newWeapon){
    super.setMinDamage(super.getMinDamage() - weapon.getBonusDamage());
    super.setMaxDamage(super.getMaxDamage() - weapon.getBonusDamage());
    weapon = newWeapon;
    super.setMinDamage(super.getMinDamage() - weapon.getBonusDamage());
    super.setMaxDamage(super.getMaxDamage() - weapon.getBonusDamage());
  }
  public String getWeapon(){
    return weapon.toString();
  }
  public int getHealth(){
    return super.getHealth();
  }

  public void fight(room R){
    monster M = R.getMonster();
    String name = M.getName();
    int monsterHealth = M.getHealth();
    int MDamage = M.calculateDamage();
    int Health = super.getHealth();
    
    //player and monster autmatically trade hits until one dies
    while(monsterHealth > 0 && this.getHealth() > 0){
      monsterHealth -= super.calculateDamage();

      if(monsterHealth <= 0){
        System.out.println("You found and killed a " + name + ".");
      } else if(player.super.getHealth() <= 0){
        System.out.println("The " + name + " in the next room turned you into mincemeat.");
        System.exit(0);
      } else{

        MDamage = M.calculateDamage();
        damage(MDamage);

    if(monsterHealth <= 0){
        System.out.println("You found and killed a " + name + ".");
      } else if(getHealth() <= 0){
        System.out.println("The " + name + " in the next room turned you into mincemeat.");
        System.exit(0);
      }
    }
    
    }
    
    super.setHealth(Health);

  }

}