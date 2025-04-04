public class Character 
{
    private String name;
    private int strength;
    private int speed;
    private int health=50;
    private final int heal = 5;
    private final int damage =10;

    public Character(String name, int strength, int speed)
    {
        this.name=name;
        this.strength= strength;
        this.speed = speed;
    }
    public Character(Character c)
    {
        this.name = c.name;
        this.strength = c.strength;
        this.speed = c.speed;
    }
    public String getName()
    {
        return name;
    }
    public int getStrength()
    {
        return strength;
    }
    public int getSpeed()
    {
        return speed;
    }
    public int attack(Character c)
    {
        int attack = damage + strength;
        return c.health - attack;
    }
    public int heal()
    {
        this.health +=heal + 2*speed;
        if (health > 50)
        {
            health =50;
        }
        return health;
    }
    public void takeDamage(int damage)
    {
        health
    }
    public String toString()
    {
        String answer = 
        return answer;
    }
    public boolean isEqual()
    {

    }
