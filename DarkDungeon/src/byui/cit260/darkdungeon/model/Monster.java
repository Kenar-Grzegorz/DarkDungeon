/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.model;

import byui.cit260.darkdungeon.control.*;
import byui.cit260.darkdungeon.exception.BattleControlException;
import darkdungeongame.DarkDungeonGame;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Bill
 */
public class Monster implements Serializable {
    
    // class instance variables
    private String monsterName;
    private int health;
    private int defense;
    private int minAttackDamage;
    private int maxAttackDamage;
    private int abilityDamage;
    private final static Random random = new Random();
    private final static Set<Integer> monstersSeen = new HashSet<Integer>();
    private final static int NUM_MONSTERS = 37;
    
    public Monster() {
    }

    public Monster(String monsterName, int health, int defense, int minAttackDamage, int maxAttackDamage, int abilityDamage) {
        this.monsterName = monsterName;
        this.health = health;
        this.defense = defense;
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
        this.abilityDamage = abilityDamage;
    }
    
    public static Monster newRandomInstance() {
    if (monstersSeen.size() == NUM_MONSTERS) {
            monstersSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_MONSTERS);
        } while (monstersSeen.contains(i));
        monstersSeen.add(i);
        if (i == 0) {
            return new Monster("Banshee",45,10,10,20,25);
                } else if (i==1) {
            return new Monster("Large Bat",10,1,1,3,1);
                } else if (i==2) {
            return new Monster("Giant Beetle",5,3,1,5,1);
                } else if (i==3) {
            return new Monster("Carrion Crawler",45,7,5,10,15);
                } else if (i==4) {
           return new Monster("Cave Fisher",40,6,1,8,1);
                } else if (i==5) {
           return new Monster("Giant Centipede",20,5,1,3,5);
                } else if (i==6) {
           return new Monster("Crawling Claw",15,10,1,3,1);
                } else if (i==7) {
           return new Monster("Death Knight",120,20,15,25,50);
                } else if (i==8) {
           return new Monster("Air Elemental",120,18,25,35,25);
                } else if (i==9) {
           return new Monster("Earth Elemental",120,18,25,35,25);
                } else if (i==10) {
           return new Monster("Fire Elemental",120,18,30,45,25);
                } else if (i==11) {
           return new Monster("Water Elemental",120,18,20,30,25);
                } else if (i==12) {
           return new Monster("Gargoyle",55,12,5,15,5);
                } else if (i==13) {
           return new Monster("Gelatinous Cube",80,8,5,15,5);
                } else if (i==14) {
           return new Monster("Ghost",100,15,15,25,50);
                } else if (i==15) {
           return new Monster("Ghoul",80,11,15,25,10);
                } else if (i==16) {
           return new Monster("Gnoll",50,5,5,8,2);
                } else if (i==17) {
           return new Monster("Goblin",15,4,1,5,2);
                } else if (i==18) {
           return new Monster("Stone Golem",120,10,15,25,20);
                } else if (i==19) {
           return new Monster("Heucuva",120,12,15,25,20);
                } else if (i==20) {
           return new Monster("Lich",120,20,18,30,40);
                } else if (i==21) {
           return new Monster("Lurker",50,8,5,12,10);
                } else if (i==22) {
           return new Monster("Mimic",60,7,5,12,10);
                } else if (i==23) {
           return new Monster("Mummy",100,16,15,20,80);
                } else if (i==24) {
           return new Monster("Phantom",90,16,15,20,10);
                } else if (i==25) {
           return new Monster("Poltergeist",80,14,15,20,10);
                } else if (i==26) {
           return new Monster("Giant Rat",10,3,1,3,5);
                } else if (i==27) {
           return new Monster("Revenant",100,17,12,18,15);
                } else if (i==28) {
           return new Monster("Roper",80,11,10,15,5);
                } else if (i==29) {
           return new Monster("Shadow",120,18,15,20,15);
                } else if (i==30) {
           return new Monster("Skeleton",20,9,2,8,2);
                } else if (i==31) {
           return new Monster("Spectre",75,16,15,20,10);
                } else if (i==32) {
           return new Monster("Vampire",120,20,20,40,25);
                } else if (i==33) {
           return new Monster("Wight",40,12,5,15,10);
                } else if (i==34) {
           return new Monster("Will o’ wisp",15,7,1,4,1);
                } else if (i==35) {
           return new Monster("Zombie",35,4,2,10,10);
        } else {
            return new Monster("Bloody Zombie",45,4,2,10,10);
               }
    }
    public static Monster newBossInstance() {
        return new Monster("Dragon",120,18,25,35,25);
    }
    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    public int getMinAttackDamage() {
        return minAttackDamage;
    }

    public void setMinAttackDamage(int minAttackDamage) {
        this.minAttackDamage = minAttackDamage;
    }

    public int getMaxAttackDamage() {
        return maxAttackDamage;
    }

    public void setMaxAttackDamage(int maxAttackDamage) {
        this.maxAttackDamage = maxAttackDamage;
    }

    public int getAbilityDamage() {
        return abilityDamage;
    }

    public void setAbilityDamage(int abilityDamage) {
        this.abilityDamage = abilityDamage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.monsterName);
        hash = 71 * hash + this.health;
        hash = 71 * hash + this.defense;
        hash = 71 * hash + this.minAttackDamage;
        hash = 71 * hash + this.maxAttackDamage;
        hash = 71 * hash + this.abilityDamage;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Monster other = (Monster) obj;
        if (this.health != other.health) {
            return false;
        }
        if (this.defense != other.defense) {
            return false;
        }
        if (this.minAttackDamage != other.minAttackDamage) {
            return false;
        }
        if (this.maxAttackDamage != other.maxAttackDamage) {
            return false;
        }
        if (this.abilityDamage != other.abilityDamage) {
            return false;
        }
        if (!Objects.equals(this.monsterName, other.monsterName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Monster{" + "monsterName=" + monsterName + ", health=" + health + ", defense=" + defense + ", minAttackDamage=" + minAttackDamage + ", maxAttackDamage=" + maxAttackDamage + ", abilityDamage=" + abilityDamage + '}';
    }
    
    public int attack() throws BattleControlException {
        return BattleControl.random(minAttackDamage, maxAttackDamage);
    }
    public boolean isAlive() {
        return health > 0;
    }
    
    public String getStatus() {
        return "Monster HP: " + health;
    }
    
}
