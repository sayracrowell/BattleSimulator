/**
 * This Class contains all the methods needed to make a character, 
 * alter health, and let the BattleSimulator function correctly
 * @Mariam Barry
 * @date 4-08-25
 */
import java.util.Random;
public class Character 
{
    private String name;
    private int strength=0;
    private int speed=0;
    private int health=0;
    private final int TRUE_HEALTH = 50;
    private final int HEAL = 5;
    private final int ATTACK =10;
    Random rnd = new Random();
    /**
     * Constructor
     * @param name is the name of the player
     * @param strength is the strength assigned to a player
     * @param speed is the speed assigned to a player
     */

    public Character(String name, int strength, int speed)
    {
        this.name=name;
        this.strength= strength;
        this.speed = speed;
        this.health= TRUE_HEALTH;
        
    }
    /**
     * Copy Constructor
     * @param c is a previously made character being passed into the method
     */
    public Character(Character c)
    {
        this.name = c.name;
        this.strength = c.strength;
        this.speed = c.speed;
        this.health= TRUE_HEALTH;

    }
    /**
     * This gets the Player's name assigned to it in battle simulator
     * @return name of the player
     */
    public String getName()
    {
        return name;
    }
    /**
     * This gets the Player's health
     * @return health of the player
     */
    public int getHealth()
    {
        return health;
    }
     /**
     * This gets the Player's strength assigned to it in BattleSimulator
     * @return strength of the player
     */
    public int getStrength()
    {
        return strength;
    }
     /**
     * This gets the Player's speed assigned to it in BattleSimulator
     * @return speed of the player
     */
    public int getSpeed()
    {
        return speed;
    }
    /**
     * This method calculates the damage to be inflicted 
     * and gives it a 10% chance of being a critical hit
     * @param c is the character being passed in to get attacked
     * @return damage inflicted onto passed-in player
     */
    public int attack(Character c)
    {
        int damage = ATTACK + strength;
        if (rnd.nextInt(100)<10)
        {
            damage+=5;
            System.out.println("**Critical Hit**");
        }
        c.takeDamage(damage);
        return damage;
    }
    /**
     * This method calculates the amount healed
     * and sets a bound so true health doesn't go past 50
     * @return healed the amount the character is getting healed by
     */
    public int heal()
    {
        int healed= HEAL + (2*speed);
        if ( health + healed > TRUE_HEALTH)
        {
            healed =TRUE_HEALTH-health;
        }
        health+=healed;
        return healed;
    }
    /**
     * This method subtracts damage from players' health
     * @param damage being passed in from the attack method
     */
    public void takeDamage(int damage)
    {
        health-= damage;
        if (health < 0)
        {
            health = 0;
        }
    }
    /**
     * Shows a String format of health remaining
     * @return answer a formatted string showing name and health
     */
   public String toString()
    {
        String answer = name+" health remaining: " + health;
        return answer;
    }
    /**
     * Compares a current character with another character to check if they are equal
     * @param c the Character to compare with
     * @return true if name, strength, speed,
     * and health are the same as the specified character
     */
   public boolean isEqual( Character c)
    {
        return this.name.equals(c.getName()) &&
            this.strength == c.getStrength() &&
            this.speed == c.getSpeed() &&
            this.health == c.getHealth();
    }
}
