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

package assignment1;

import java.util.*;
public class PlayingCardDeck
{
   public static final int NUMBER_OF_CARDS = PlayingCard.NUMBER_OF_SUITS *
                                             PlayingCard.NUMBER_OF_RANKS;
   //Instance Variable
   //Number of PlayingCards currently in this PlayingCardDeck
   private int numberOfCardsInDeck;
   
   //Instance Variable
   //CLUBS:    deck[0]  .. deck[12] DEUCE, TREY, .. KING, ACE
   //DIAMONDS: deck[13] .. deck[25] DEUCE, TREY, .. KING, ACE
   //HEARTS:   deck[26] .. deck[38] DEUCE, TREY, .. KING, ACEE
   //SPADES:   deck[39] .. deck[51] DEUCE, TREY, .. KING, ACE
   private boolean[] deck;
   
   //Constructor
   //set all 52 cards in deck to true
   public PlayingCardDeck()
   {
       this.deck = new boolean[52];
       this.numberOfCardsInDeck = 52;
       for(int k=0;k<deck.length;k++)
           this.deck[k] = true;
   }
   
   //Accessor
   //Return the # of PlayingCards currently in this PlayingCardDeck
   public int getNumberOfCardsInDeck()
   {
      return this.numberOfCardsInDeck;
   }
   
   //Mutator
   //Return all 52 PlayingCards to this PlayingCardDeck
   public void shuffle()
   {
       this.numberOfCardsInDeck = 52;
       for(int k=0;k<this.deck.length;k++)
           this.deck[k] = true;
   }
   
   //Mutator
   //Construct a randomly selected PlayingCard from this PlayingCardDeck
   // Remove the randomly selected PlayingCard from this PlayingCardDeck
   // Return the randomly selected PlayingCard
   public PlayingCard deal()
   {
       //generating a random number to deal a random card
      int cardnumber = (int) Math.round(Math.random()*51);
      
      //while loop to make sure number hasnt been used or we're not of cards;
      while(deck[cardnumber] == false)
      {
         cardnumber = (int) Math.round(Math.random()*51);
         if(this.numberOfCardsInDeck==0)
             break;
      }
      
      
      
      //setting the card im using to false and reducind my deck size by 1
      deck[cardnumber] = false;
      this.numberOfCardsInDeck--;
      
      //getting the card information in order to return the card
      PlayingCard.CardSuit suit = PlayingCard.CardSuit.CLUBS;

      if(checkSuit(cardnumber).equals("DIAMONDS")){
      suit = PlayingCard.CardSuit.DIAMONDS;
      }
      if(checkSuit(cardnumber).equals("HEARTS")){
        suit = PlayingCard.CardSuit.HEARTS;
      }
      if(checkSuit(cardnumber).equals("SPADES")){
        suit = PlayingCard.CardSuit.SPADES;
      }
      PlayingCard.CardRank rank = PlayingCard.CardRank.DEUCE;
      if(checkRank(cardnumber).equals("3"))
          rank = PlayingCard.CardRank.TREY;
      if(checkRank(cardnumber).equals("4"))
          rank = PlayingCard.CardRank.FOUR;
      if(checkRank(cardnumber).equals("5"))
          rank = PlayingCard.CardRank.FIVE;
      if(checkRank(cardnumber).equals("6"))
          rank = PlayingCard.CardRank.SIX;
      if(checkRank(cardnumber).equals("7"))
          rank = PlayingCard.CardRank.SEVEN;
      if(checkRank(cardnumber).equals("8"))
          rank = PlayingCard.CardRank.EIGHT;
      if(checkRank(cardnumber).equals("9"))
          rank = PlayingCard.CardRank.NINE;
      if(checkRank(cardnumber).equals("T"))
          rank = PlayingCard.CardRank.TEN;
      if(checkRank(cardnumber).equals("J"))
          rank = PlayingCard.CardRank.JACK;
      if(checkRank(cardnumber).equals("Q"))
          rank = PlayingCard.CardRank.QUEEN;
      if(checkRank(cardnumber).equals("K"))
          rank = PlayingCard.CardRank.KING;
      if(checkRank(cardnumber).equals("A"))
          rank = PlayingCard.CardRank.ACE;
      
      
      PlayingCard currentCard = new PlayingCard(suit,rank);
      
      return currentCard;
   }
   
   //Accessor
   //Helps deal() find the suit of the card that is being dealt
   private String checkSuit(int cardnumber)
   {

       String cardsuit;
       int suitnum = cardnumber/13;
       
       switch(suitnum){
           case 0:
               cardsuit = "CLUBS";
               break;
               
           case 1:
               cardsuit = "DIAMONDS";
               break;
          
           case 2:
               cardsuit = "HEARTS";
               break;
               
           default:
               cardsuit = "SPADES";
               break;
       }
       return cardsuit;
   }  
       
   //Accessor
   //Helps deal() find the rank of the card that is being dealt
   private String checkRank(int cardnumber)
      {
       String cardrank;
       int ranknum = cardnumber % 13;
       switch(ranknum){
           case 0:
               cardrank = "2";
               break;
               
           case 1:
               cardrank = "3";
               break;
          
           case 2:
               cardrank = "4";
               break;
               
           case 3:
               cardrank = "5";
               break;
           
           case 4:
               cardrank = "6";
               break;
               
           case 5:
               cardrank = "7";
               break;
               
           case 6:
               cardrank = "8";
               break;
               
           case 7:
               cardrank = "9";
               break;
               
           case 8:
               cardrank = "T";
               break;
               
           case 9:
               cardrank = "J";
               break;
                
           case 10:
               cardrank = "Q";
               break;
                
           case 11:
               cardrank = "K";
               break;

           default:
               cardrank = "A";
               break;
       }
       
       return cardrank;
      
   }
   
       public String toString()
{
    String array = "";
    for(int i = 0;i<this.deck.length;i++){
        array += this.deck[i] + ", ";
    }
    return array+" "+this.numberOfCardsInDeck;
}

}

