import java.util.ArrayList;
import java.util.*;

class Player
{
    private ArrayList<Cards> player;
    public int score;
    
    
    public Player()
    {
        player = new ArrayList<Cards>();
        score = 0;
        
    }
    
  
    public void getCard(Cards i)
    {
        player.add(i);
    }
    
    public void getHand()
    {
        for(int i = 0; i < player.size(); i++)
        {
            Cards temp = player.get(i);

            System.out.println(temp.getName()); 
            
        }
        
    }
    
    public int getScore()
    {
        int number = 0;
        for(int i = 0; i < player.size(); i++)
        {
            Cards temp = player.get(i);
            int s = temp.getValue();
            number = number + s;
            score = number;
        }
        return score;
    }
    
    public void setScore(int s)
    {
         for(int i = 0; i < player.size(); i++)
        {
            Cards temp = player.get(i);
            int length = temp.getName().length();
            if(temp.getName().substring(length - 1,length).equals("A"))
            player.remove(temp);
            
            
            
        }
    }
    
}


class Cards
{
   private String Name;
   private int Value;
   
   public Cards(String newName, int newValue)
   {
       Name = newName;
       Value = newValue;
       
   }
   
   public String getName()
   {
       return Name;
   }
   
   public int getValue()
   {
       return Value;
   }
   
   
}

class Main
{
   public static void main(String[] args)
   {
    boolean start = true;
    while (start == true)
    {
    
       Game s = new Game();
       Scanner in = new Scanner(System.in);
      
       s.assignCards();
       s.shuffle();
       
       boolean cont = true;
    while (cont == true)
    {
       
       
       System.out.println("Enter [1] to stand ");
       System.out.println("Enter [2] to hit ");
       System.out.println("Enter [3] to get hand. ");
      
       int input = in.nextInt();
       
       if(input == 1)
       {
           s.stand();
           s.getHighestScore();
           cont = false;
       }
       else if(input == 2)
       {
           s.hit();
       }
       else if(input == 3)
       {
           s.getHand();
           
       }
       else
       {
           //s.getInv();
           cont = false;
        }
         
    }
    System.out.println("Enter [4] to Play again. Else to end.");
    int input = in.nextInt();
    if(input != 4)
    start = false;
    }
   }
}












class Game
{
    ArrayList<Cards> game;
    ArrayList<Player> players;
    private Player one;
    private Player bot;
    
    public Game()
    {
        game = new ArrayList<Cards>();
        players = new ArrayList<Player>();
        one = new Player();
        bot = new Player();
        players.add(one);
        players.add(bot);
        
        
    }

    public void assignCards()
    {
        String symbol = "";
        Cards s = new Cards("", 0);
        for(int i = 0; i < 4; i++)
        {
            if(i == 0)
                symbol = "cloves";
            if(i == 1)
                symbol = "spades";
            if(i == 2)
                symbol = "heart";
            if(i == 3)
                symbol = "diamond";

            for(int j = 1; j < 14; j++)
            {
                if(j == 1)
                {
                s = new Cards(symbol + "-A",11);
                game.add(s);
                }
                
                else if(j == 11)
                {
                    s = new Cards(symbol + "-J",10);
                game.add(s);
                }
                else if(j == 12)
                {
                    s = new Cards(symbol + "-Q",10);
                game.add(s);
                }
                else if(j == 13)
                {
                    s = new Cards(symbol + "-K",10);
                game.add(s);
                }
                else
                {
                    s = new Cards(symbol + "-" + j,j);
                    game.add(s);
                    
                }     
            }
        }
    }
    
    public void getInv()
    {
        for(int i = 0; i < game.size(); i++)
        {
            System.out.println(game.get(i).getName());
        }
    }
    
   
    public void shuffle()
    {
       int shuffle = 0;
       String name = "";
       Random generator = new Random();
      
       for(int i = 0; i < players.size(); i++)
       {
           
       for(int j = 0; j < 2; j++)
        {
        shuffle = generator.nextInt(game.size());
        
        Cards temp = game.get(shuffle);  
        game.remove(shuffle);
        
        players.get(i).getCard(temp);
       
       }
       }
       
       one.getHand();
       if(one.getScore() == 21)
       {
       System.out.println("You Win!!!");
       System.out.println("Enter [4] to Finish current game");
       }
    }

    
    public void stand()
    {
      int shuffle = 0;
      Random generator = new Random();
       
      shuffle = generator.nextInt(game.size());
        
      Cards temp = game.get(shuffle);  
      game.remove(shuffle);
      
      if(one.getScore() >= bot.getScore())
      bot.getCard(temp);
      System.out.println("Dealer's score");
      System.out.println(bot.getScore());
      
      System.out.println("Your score");
      System.out.println(one.getScore());
      
      
    }
     
    public void hit()
    {
        int shuffle = 0;
        Scanner in = new Scanner(System.in);
        Random generator = new Random();
       
        shuffle = generator.nextInt(game.size());
        
        Cards temp = game.get(shuffle);  
        game.remove(shuffle);
        
        one.getCard(temp);
        
        int length = temp.getName().length(); 
        
        
        
          
            
        if(temp.getName().substring(length - 1,length).equals("A"))
        {
          /*System.out.println("Ace 1 or 11?")
          int input = in.nextInt();
          if(input == 1)
          one.setScore(10);
          */
         if(one.getScore() > 21)
         {
         one.setScore(10);
         Cards s = new Cards(temp.getName() ,1);
         one.getCard(s);
         }
        }
        
        
        
        
      
        System.out.println("Your score");
        System.out.println(one.getScore());
        
        
        if(one.getScore() == 21 && bot.getScore() == 21)
        {
         System.out.println("Push");
         System.out.println("Enter [4] to Finish current game");
        }
        if(one.getScore() == 21 && bot.getScore() != 21)
        {
        System.out.println("You Win!!!");
        System.out.println("Enter [4] to Finish current game");
        }
        
        if(one.getScore() > 21)
        {
        System.out.println("Dealer's score");
        System.out.println(bot.getScore());
      
        System.out.println("Dealer Wins");
        System.out.println("Enter [4] to Finish current game");
        }
       
    }
    
    public void getHighestScore()
    {
        int max = one.getScore();
        for(int i = 1; i < players.size(); i++)
        {
            int temp = players.get(i).getScore();
            if(temp == max)
            System.out.println("Push");
            else if(temp > max && temp <= 21) 
            System.out.println("Dealer Wins");
            else if(max <= 21)
            System.out.println("You Win!!!");
            else
            System.out.println("Dealer Wins");
            
        }
    }
    
    public void getHand()
    {
         one.getHand();
    }
    
    
    public void getScore()
    {
        
      System.out.println(one.getScore());
    }
    
}

