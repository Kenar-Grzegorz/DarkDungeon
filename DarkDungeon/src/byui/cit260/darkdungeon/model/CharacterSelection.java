/*
 *  Dark Dungeon game
 */
package byui.cit260.darkdungeon.model;

import byui.cit260.darkdungeon.control.BattleControl;
import java.io.Serializable;
import java.util.Objects;

/**
 * @authors Greg Kenar, William Murray, Florian Kausche
 * CIT 260  First Assignment
 */

public class CharacterSelection implements Serializable {
    private String characterName;
    private String characterClass;
    private int health;
    private int minAttackDamage;
    private int maxAttackDamage;
    private int defenseAmount;
    private int manaAmount;
    private int abilityDamage;
    private int elementalDamage;

    public CharacterSelection() {
    }

    public CharacterSelection(String characterName, String characterClass, int health, int minAttackDamage, int maxAttackDamage, int defenseAmount, int manaAmount, int abilityDamage, int elementalDamage) {
        this.characterName = characterName;
        this.characterClass = characterClass;
        this.health = health;
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
        this.defenseAmount = defenseAmount;
        this.manaAmount = manaAmount;
        this.abilityDamage = abilityDamage;
        this.elementalDamage = elementalDamage;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    
    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getDefenseAmount() {
        return defenseAmount;
    }

    public void setDefenseAmount(int defenseAmount) {
        this.defenseAmount = defenseAmount;
    }

    public int getManaAmount() {
        return manaAmount;
    }

    public void setManaAmount(int manaAmount) {
        this.manaAmount = manaAmount;
    }

    public int getAbilityDamage() {
        return abilityDamage;
    }

    public void setAbilityDamage(int abilityDamage) {
        this.abilityDamage = abilityDamage;
    }

    public int getElementalDamage() {
        return elementalDamage;
    }

    public void setElementalDamage(int elementalDamage) {
        this.elementalDamage = elementalDamage;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.characterName);
        hash = 37 * hash + Objects.hashCode(this.characterClass);
        hash = 37 * hash + this.health;
        hash = 37 * hash + this.minAttackDamage;
        hash = 37 * hash + this.maxAttackDamage;
        hash = 37 * hash + this.defenseAmount;
        hash = 37 * hash + this.manaAmount;
        hash = 37 * hash + this.abilityDamage;
        hash = 37 * hash + this.elementalDamage;
        return hash;
    }

    @Override
    public String toString() {
        return "Character{" +  "characterName=" + characterName +  "characterClass=" + characterClass + ", health=" + health + ", minAttackDamage=" + minAttackDamage + ", maxAttackDamage=" + maxAttackDamage + ", defenseAmount=" + defenseAmount + ", manaAmount=" + manaAmount + ", abilityDamage=" + abilityDamage + ", elementalDamage=" + elementalDamage + '}';
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
        final CharacterSelection other = (CharacterSelection) obj;
        if (this.health != other.health) {
            return false;
        }
        if (this.minAttackDamage != other.minAttackDamage) {
            return false;
        }
        if (this.maxAttackDamage != other.maxAttackDamage) {
            return false;
        }
        if (this.defenseAmount != other.defenseAmount) {
            return false;
        }
        if (this.manaAmount != other.manaAmount) {
            return false;
        }
        if (this.abilityDamage != other.abilityDamage) {
            return false;
        }
        if (this.elementalDamage != other.elementalDamage) {
            return false;
        }
        if (!Objects.equals(this.characterClass, other.characterClass)) {
            return false;
        }
        if (!Objects.equals(this.characterName, other.characterName)) {
            return false;
        }
        return true;
    }
    
    public void heal(Item potion) {
            int amount = potion.getItemAmount();
        if (amount>0){System.out.println("*  You have used a potion  *\n");System.out.println("  `  `  \\ \\(`^')/ /  '  '\n");
            health = health + potion.getItemHeal();
            System.out.println("before"+potion.getItemAmount());
            amount--;
            potion.setItemAmount(amount);
            System.out.println("after"+potion.getItemAmount());
            System.out.println(this.characterName+" drinks a healing potion.");
            System.out.println(getStatus());
            //return amount;
        } else {
            System.out.println("*  You've exhausted your potion supply!  *\n");
            //return amount;
        }  
        System.out.println("*  You have " + amount + " potions left.  *\n");
    }
    /*public void heal(int amount) {
        int numHealthPotions = 3;
        int healthPotionHealAmount = 25;
        if (numHealthPotions > 0) {
            health = health + healthPotionHealAmount;
            --numHealthPotions;
            System.out.println(characterName+" drinks a healing potion.");
            System.out.println(getStatus());
            
        } else {
            System.out.println("  You've exhausted your potion supply!");
        }  
    }*/
    public int attack() {
        return BattleControl.random(minAttackDamage, maxAttackDamage);
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    public String getStatus() {
        return "Player HP: " + health;
    }
    public String getManaStatus() {
        return "Player Mana: " + manaAmount;
    }
    public void defend(Monster monster) {
        int attackStrength = monster.attack();
        health = (health > attackStrength) ? health - attackStrength : 0;
        System.out.println(monster.getMonsterName()+ " hits "+getCharacterName()+" for "+attackStrength+" HP of damage \n");
        
        if (health == 0) {
            System.out.println("\t" + getCharacterName() + " has been defeated, try again next time");
        }
    }
    public static CharacterSelection warriorCreate() {
        return new CharacterSelection("The Might Warrior -","- Brave attacker of all that is evil",100,10,50,10,30,50,50);
     }

     public static CharacterSelection paladinCreate() {
        return new CharacterSelection("The Might Paladin Defender -","- Brave defender of the people for all that is good.", 100,10,40,10,30,40,60);
     }
}

