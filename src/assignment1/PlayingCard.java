
package assignment1;

//  PROGRAMMER:  Alvaro E. de Castro  123-45-6789
//
//  CLASS:       COP 3337-01   TWT 11:00AM
//
//  INSTRUCTOR:  Norman Pestaina  ECS 364
//
//  ASSIGNMENT:  #1 Enum & Arrays.   DUE Sunday 05/25
//
// CERTIFICATION: I certify that this work is my own and that
//                 none of it is the work of any other person.
//

public class PlayingCard implements Comparable
{
   public static final int NUMBER_OF_SUITS = CardSuit.values().length;
   public static final int NUMBER_OF_RANKS = CardRank.values().length;
   
   //Instance Variables
   private CardSuit suit;  //CLUBS, DIAMONDS, HEARTS, SPADES
   private CardRank rank;  //2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A
   
   //Constructor
   public PlayingCard(CardSuit suit, CardRank rank)
   {
      this.suit = suit;
      this.rank = rank;
   }
   
   //Accessor: rank
   public CardRank getRank()
   {
      return this.rank;
   }
   
   //Accessor: suit
   public CardSuit getSuit()
   {
      return this.suit;
   }
   
   //Override toString(): 
   //Return a PlayingCard image showing the rank and suit
   public String toString()
   {
      return "" + this.rank + this.suit;
   }
   
   //Override equals():
   public boolean equals(Object other)
   {
      if (other == null || other.getClass() != this.getClass())
         return false;
         
      PlayingCard that = (PlayingCard)other;
      return this.suit == that.suit &&
             this.rank == that.rank;
   }
   
   //Override compareTo(): 
   //Compare PlayingCards, primarily by rank, secondarily by suit
   public int compareTo(Object other)
   {
      PlayingCard that = (PlayingCard)other;
       System.out.println();
      if (this.rank != that.rank)
         return this.rank.compareTo(that.rank);
         
      return this.suit.compareTo(that.suit);
   }
   
   //An enumeration type to represent the Suits of a PlayingCard
   //This representation uses the Unicode black suit symbols
   public enum CardSuit
   {
      CLUBS('\u2663'), DIAMONDS('\u2666'), HEARTS('\u2665'), SPADES('\u2660');
      
      private char symbol;
      
      private CardSuit(char symbol)
      {
         this.symbol = symbol;
      }
     
      public char getSymbol()
      {
         return this.symbol;
      }  
       
      public String toString()
      {
         return "" + this.symbol;
      }
   }
 
   //An Enumeration type to represent the Ranks of a PlayingCard
   //This representation uses the numeric symbols and the 1st letter of Royals  
   public enum CardRank
   {
      DEUCE('2'), TREY('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'),
      NINE('9'), TEN('T'), JACK('J'), QUEEN('Q'), KING('K'), ACE('A');
      
      private char symbol;
      
      private CardRank(char symbol)
      {
         this.symbol = symbol;
      }
      
      public char getSymbol()
      {
         return this.symbol;
      }  
       
      public String toString()
      {
         return "" + this.symbol;
      }
   }
}