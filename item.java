public class item{

  private int level;
  private String desc;
  private String type;
  private int defenseBonus;
  private int healthBonus;
  private int damageBonus;

  public item(){
    level = (int)(Math.random()*7) + 1;
    type = "armor";
    if(Math.random() < 0.5)
      type = "weapon";
      damageBonus = level + (int)(Math.random()*4);
    if(type.equals("armor")){
      healthBonus = level + (int)(Math.random()*10);
      defenseBonus = level + (int)(Math.random()*3);
    }
    generateDesc();
    if(Math.random() < 0.01){
      level = 10;
      type = "weapon";
      desc = "vorpal sword";
      damageBonus = 20;
      defenseBonus = 10;
    }
    else if(Math.random() < 0.1){
      level += 3;
      desc = "enchanted " + desc;
      if(type.equals("weapon"))
        damageBonus += 10;
      else{
        defenseBonus += 10;
        healthBonus += 10;
      }
    }

  }

  public item(int lvl, String typ, int defBonus, int hpBonus, int dmgBonus){
    level = lvl;
    type = typ;
    generateDesc();
    defenseBonus = defBonus;
    healthBonus = hpBonus;
    damageBonus = dmgBonus;
  }
  

  public void setDesc(String s){
    desc = s;
  }

  public String getDesc(){
    return desc;
  }

  public void setType(String s){
    type = s;
  }

  public String getType(){
    return type;
  }

  public int getLevel(){
    return level;
  }
  public void setBonus(int defense, int health, int damage){
    defenseBonus = defense;
    healthBonus = health;
    damageBonus = damage;
  }

  public int getBonusDamage(){
    return damageBonus;
  }

  public int getBonusHealth(){
    return healthBonus;
  }

  public int getBonusDefense(){
    return defenseBonus;
  }


  public void generateDesc(){ //makes a random description for the item
    String newDesc = "";
    int temp = (int)(Math.random() * 16); //if you want to add more descriptors, go ahead, just change the range, and make the fish ones be last
    switch(temp){
      case 0: newDesc += "broken "; break;
      case 1: newDesc+= "bloody "; break;
      case 2: newDesc += "pointy "; break;
      case 3: newDesc += "heavenly "; break;
      case 4: newDesc += "heavy "; break;
      case 5: newDesc += "demonic "; break;
      case 6: newDesc += "glowing "; break;
      case 7: newDesc += "dull "; break;
      case 8: newDesc += "sharp "; break;
      case 9: newDesc += "unbreaking "; break;
      case 10: newDesc += "fancy "; break;
      case 11: newDesc += "plain "; break;
      case 12: newDesc += "filthy "; break;
      case 13: newDesc += "light "; break;
      case 14: newDesc += "odd "; break;
      case 15: newDesc += "fishy "; healthBonus += 5; break;
    }
    if(type.equals("weapon")){
      temp = (int)(Math.random()*16); 
      switch(temp){
        case 0: newDesc += "mace "; break;
        case 1: newDesc += "flail "; break;
        case 2: newDesc += "longsword "; break;
        case 3: newDesc += "shortsword "; break;
        case 4: newDesc += "greatsword "; break;
        case 5: newDesc += "dagger "; break;
        case 6: newDesc += "spear "; break;
        case 7: newDesc += "lance "; break;
        case 8: newDesc += "katana "; break;
        case 9: newDesc += "pike "; break;
        case 10: newDesc += "club "; break;
        case 11: newDesc += "quarterstaff "; break;
        case 12: newDesc += "sickle "; break;
        case 13: newDesc += "battleaxe "; break;
        case 14: newDesc += "rapier "; break;
        case 15: newDesc += "fish "; healthBonus += 5; break;
      }
    }
    if(type.equals("armor")){
      temp = (int)(Math.random()*9);
      switch(temp){
        case 0: newDesc += "leather armor "; break;
        case 1: newDesc += "studded leather armor "; break;
        case 2: newDesc += "half plate "; break;
        case 3: newDesc += "full plate "; break;
        case 4: newDesc += "ring mail "; break;
        case 5: newDesc += "scale mail "; break;
        case 6: newDesc += "hide armor "; break;
        case 7: newDesc += "breastplate "; break;
        case 8: newDesc += "chain shirt "; break;

      }
    }
    temp = (int)(Math.random()*11);
    switch(temp){
      case 0: newDesc += "of destruction"; break;
      case 1: newDesc += "of friendship"; break;
      case 2: newDesc += "of pain"; break;
      case 3: newDesc += "of might"; break;
      case 4: newDesc += "of light"; break;
      case 5: newDesc += "of darkness"; break;
      case 6: newDesc += "of protection"; break;
      case 7: newDesc += "of blocking"; break;
      case 8: newDesc += "of hitting things"; break;
      case 9: newDesc += "of strength"; break;
      case 10: newDesc += "of fish"; healthBonus += 5; break;
    }
    desc = newDesc;

  }

  public String toString(){
    if(type.equals("armor"))
      return(desc + ", defence bonus:" + defenseBonus + ", health bonus: " + healthBonus);
    return(desc + ", damage bonus: " + damageBonus);
  }

}

