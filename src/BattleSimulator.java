/**
 *This BattleSimulator Class is a simulation of a turn-based game
 *The characters alternate between either attacking and healing based on a random
 * @Sayra Crowell
 * @date 4-08-25
 */
import java.util.Random;

 public class BattleSimulator 
{
     public static void main(String[] args) 
     {
         // Create characters 
         Character player1 = new Character("Gandolf the Grey", 4, 1);
         Character player2 = new Character("Dobby the Elf", 1, 4);
 
         System.out.println("It's a duel to the death. Let's welcome our opponents:");
         System.out.println(player1.getName() + " [Strength: " + player1.getStrength() + ", Speed: " + player1.getSpeed() + "]");
         System.out.println("AND");
         System.out.println(player2.getName() + " [Strength: " + player2.getStrength() + ", Speed: " + player2.getSpeed() + "]");
         System.out.println("Let the battle commence!");
         System.out.println("***************************************");
 
         Random rand = new Random();
 
         while (player1.getHealth() > 0 && player2.getHealth() > 0) 
         {
             // Player 1's turn
             if (rand.nextInt(100) < 70) 
             {
                 int damage = player1.attack(player2);
                 System.out.println(player1.getName() + " ATTACKS! They inflict " + damage + " damage.");
             } 
             else 
             {
                 int healed = player1.heal();
                 System.out.println(player1.getName() + " HEALS. They gained " + healed + " health.");
             }
 
             // Player 2's turn
             // added check health for player 2
             if (player2.getHealth()>0) 
            {
                if (rand.nextInt(100) < 70) 
                {
                    int damage = player2.attack(player1);
                    System.out.println(player2.getName() + " ATTACKS! They inflict " + damage + " damage.");
                } else {
                    int healed = player2.heal();
                    System.out.println(player2.getName() + " HEALS. They gained " + healed + " health.");
                }
            }
             // Current Status
             System.out.println("-------------------");
             System.out.println("Current Status:");
             System.out.println(player1);
             System.out.println(player2);
             System.out.println("-------------------");
         }
 
         // End of battle
         System.out.println("********************************");
         System.out.println("The battle has ended.");
 
         if (player1.getHealth() <= 0 && player2.getHealth() <= 0) 
         {
             System.out.println("Sadly, the duel has left them both dead.");
         } 
         else if (player1.getHealth() <= 0) 
         {
             System.out.println(player2.getName() + " is triumphant this eve!");
         } 
         else 
         {
             System.out.println(player1.getName() + " has emerged victorious!");
         }
     }
}
