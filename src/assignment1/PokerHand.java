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

/**
 *
 * @author alvarodecastro
 */
import java.util.*;
import javax.swing.*;
public class PokerHand
{
   public static final int POKER_HAND_SIZE = 5;
   
   public enum HandType
   {
      NO_PAIR, ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT,
      FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH;
   }
   
   //Instance Variable
   private PlayingCard[] hand = new PlayingCard[POKER_HAND_SIZE];
   
   
   //Mutator
   //Add another card into this PokerHand
   //Exception thrown if this PokerHand is already completed
   public void addCard(PlayingCard card)
   {    
       //counting the empty spots left in the poker hand
       int count = 0;
       for(int j = 0;j<hand.length;j++)
       {
           if(hand[j]==null)
               count++;
       }
       
       //Trying to catch error if poker Hand is full
       //if there is no error it adds card to next empty spot
       if(count == 0)
           try
           {
           throw new ArithmeticException("Your hand is full");
           }
           catch(ArithmeticException e)
           {
               JOptionPane.showInputDialog("Your hand is full");
           }
       
       else
       {
            for(int i = 0;i<hand.length;i++)
            {
                if(hand[i]==null)
                {
                    hand[i] = card;
                    break;
                }
            }
       }
       
   }
   
   
   //Mutator
   //Sorts the players current hand in order according to suit and rank to help find hand type
   private PlayingCard[] sort(PlayingCard[] cards)
   {
       
       int cardcount = cards.length;
       int[] cardnumber = new int[cardcount];
       PlayingCard[] holder = new PlayingCard[cardcount];
       int[] numberorder = new int[cardcount];
       //initializing the cardnumber array
       for(int j=0;j<cardcount;j++)
       {
           cardnumber[j] = 0;
       }
       
       //it get the number value of each card and puts it in cardnumber slot appropriate to the card
       for(int i = 0; i<cardcount;i++)
       {
           if(cards[i].getSuit() == PlayingCard.CardSuit.CLUBS)
               cardnumber[i] += 0;
           if(cards[i].getSuit() == PlayingCard.CardSuit.DIAMONDS)
               cardnumber[i] += 13;
           if(cards[i].getSuit() == PlayingCard.CardSuit.HEARTS)
               cardnumber[i] += 26;
           if(cards[i].getSuit() == PlayingCard.CardSuit.SPADES)
               cardnumber[i] += 39;
           
           if(cards[i].getRank() == PlayingCard.CardRank.DEUCE)
               cardnumber[i] += 0;
           if(cards[i].getRank() == PlayingCard.CardRank.TREY)
               cardnumber[i] += 1;
           if(cards[i].getRank() == PlayingCard.CardRank.FOUR)
               cardnumber[i] += 2;
           if(cards[i].getRank() == PlayingCard.CardRank.FIVE)
               cardnumber[i] += 3;
           if(cards[i].getRank() == PlayingCard.CardRank.SIX)
               cardnumber[i] += 4;
           if(cards[i].getRank() == PlayingCard.CardRank.SEVEN)
               cardnumber[i] += 5;
           if(cards[i].getRank() == PlayingCard.CardRank.EIGHT)
               cardnumber[i] += 6;
           if(cards[i].getRank() == PlayingCard.CardRank.NINE)
               cardnumber[i] += 7;
           if(cards[i].getRank() == PlayingCard.CardRank.TEN)
               cardnumber[i] += 8;
           if(cards[i].getRank() == PlayingCard.CardRank.JACK)
               cardnumber[i] += 9;
           if(cards[i].getRank() == PlayingCard.CardRank.QUEEN)
               cardnumber[i] += 10;
           if(cards[i].getRank() == PlayingCard.CardRank.KING)
               cardnumber[i] += 11;
           if(cards[i].getRank() == PlayingCard.CardRank.ACE)
               cardnumber[i] += 12;
               
       }
       
       
       int smallestnum = 55;
       int count  = 0;
       //finds the smallest card according to its number and places it in the holder array which is returned later
       while(count != 5)
       {
           int position = 0;
            for(int k = 0; k<cardcount;k++)
            {   
                if(cardnumber[k]<smallestnum)
                {
                    smallestnum = cardnumber[k];
                    position = k;
                } 
            }
       holder[count] = cards[position];
       numberorder[count] = smallestnum; 
       smallestnum = 55;
       cardnumber[position] = 56;
       count++;    
       
       }
       
       return holder;
   }
   
   //Return the HandType of this PokerHand
   public HandType type()
   {  
     //holder variable in order to sort through it
     PlayingCard[] cards = new PlayingCard[POKER_HAND_SIZE];
     for(int i = 0; i <cards.length;i++)
     {
         cards[i] = hand[i];
     }

     cards = sort(cards);

     //methods in order to check for hand type
    if(isRoyalFlush(cards))
        return HandType.ROYAL_FLUSH;

    if(isStraightFlush(cards))
        return HandType.STRAIGHT_FLUSH;

    if(isFlush(cards))
        return HandType.FLUSH;
    
    if(isStraight(cards))
        return HandType.STRAIGHT;

    if(isFullHouse(cards))
        return HandType.FULL_HOUSE;
        
    if(isFourOfAKind(cards))
        return HandType.FOUR_OF_A_KIND;
    
    if(isThreeOfAKind(cards))
        return HandType.THREE_OF_A_KIND;
    
    if(isTwoPairs(cards))
        return HandType.TWO_PAIRS;
    
    if(isOnePair(cards))
        return HandType.ONE_PAIR;
    
    
      return HandType.NO_PAIR;
   }
   
   //Accessor
   //lets you know if the cards in your hand are a royal flush by checking to see is you have a straight flush and your first card is a 10
   private boolean isRoyalFlush(PlayingCard[] cards)
   {
       PlayingCard[] sortedcards = new PlayingCard[cards.length];
       sortedcards = sort(cards);
       if(isStraightFlush(cards) && sortedcards[0].getRank() == PlayingCard.CardRank.TEN)
       return true;
       else
       return false;
   }
   
   //Accessor
   //lets you know if you have a striaght flush by comparing card numbers
   private boolean isStraightFlush(PlayingCard[] cards)
   {
       int truecount = 0;
       if(cardNumber(cards[0])+1 == cardNumber(cards[1]))
           truecount++;
       if(cardNumber(cards[1])+1 == cardNumber(cards[2]))
           truecount++;
       if(cardNumber(cards[2])+1 == cardNumber(cards[3]))
           truecount++;
       if(cardNumber(cards[3])+1 == cardNumber(cards[4]))
           truecount++;
       
       if(sameSuit(cards))
           truecount++;
       
       if(truecount == 5)
           return true;
       else
           return false;
   }
   
   //Accessor
   //Calls sameSuit() method to see if all cards have same suit
   private boolean isFlush(PlayingCard[] cards)
   {
       if(sameSuit(cards))
       return true;
       else
       return false;
   }
   
   //Accessor
   //Gets each cards rank in for of an integer and then sorts them and see if it is straight
   private static boolean isStraight(PlayingCard[] cards)
   {
       int[] num = new int[5];
       PlayingCard[] cardrankorder = new PlayingCard[cards.length];
       for(int i = 0; i <cards.length;i++)
       {
           if(cards[i].getRank() == PlayingCard.CardRank.DEUCE)
               num[i] = 2;
           if(cards[i].getRank() == PlayingCard.CardRank.TREY)
               num[i] = 3;
           if(cards[i].getRank() == PlayingCard.CardRank.FOUR)
               num[i] = 4;
           if(cards[i].getRank() == PlayingCard.CardRank.FIVE)
               num[i] = 5;
           if(cards[i].getRank() == PlayingCard.CardRank.SIX)
               num[i] = 6;
           if(cards[i].getRank() == PlayingCard.CardRank.SEVEN)
               num[i] = 7;
           if(cards[i].getRank() == PlayingCard.CardRank.EIGHT)
               num[i] = 8;
           if(cards[i].getRank() == PlayingCard.CardRank.NINE)
               num[i] = 9;
           if(cards[i].getRank() == PlayingCard.CardRank.TEN)
               num[i] = 10;
           if(cards[i].getRank() == PlayingCard.CardRank.JACK)
               num[i] = 11;
           if(cards[i].getRank() == PlayingCard.CardRank.QUEEN)
               num[i] = 12;
           if(cards[i].getRank() == PlayingCard.CardRank.KING)
               num[i] = 13;
           if(cards[i].getRank() == PlayingCard.CardRank.ACE)
               num[i] = 14;
       }
       int min = 15;
       int holder = 0;
       int[] numsorted = new int[5];
       for(int k = 0; k < 5;k++)
       {
           for(int j = 0; j<num.length;j++)
           {
               if(num[j]<min)
               {
               min = num[j];
               holder = j;
               }
           }
           numsorted[k] = min;
           min = 15;
           num[holder] = 16;
       }
       
       int truecount = 0;
       if(numsorted[0]+1 == numsorted[1])
           truecount++;
       if(numsorted[1]+1 == numsorted[2])
           truecount++;
       if(numsorted[2]+1 == numsorted[3])
           truecount++;
       if(numsorted[3]+1 == numsorted[4])
           truecount++;
       
       if(truecount == 4)
           return true;
       else
           return false;
   }
   
   //Accessor
   //Check all posibilities for four of a kind
   private static boolean isFourOfAKind(PlayingCard[] cards)
   {
       if(cards[0].getRank() == cards[1].getRank() && cards[0].getRank() == cards[2].getRank() && cards[0].getRank() == cards[3].getRank())
           return true;
       
       if(cards[0].getRank() == cards[1].getRank() && cards[0].getRank() == cards[2].getRank() && cards[0].getRank() == cards[4].getRank())
           return true;
       
       if(cards[0].getRank() == cards[1].getRank() && cards[0].getRank() == cards[3].getRank() && cards[0].getRank() == cards[4].getRank())
           return true;
       
       if(cards[0].getRank() == cards[2].getRank() && cards[0].getRank() == cards[3].getRank() && cards[0].getRank() == cards[4].getRank())
           return true;
       
       if(cards[1].getRank() == cards[2].getRank() && cards[1].getRank() == cards[3].getRank() && cards[1].getRank() == cards[4].getRank())
           return true;
       
       
       return false;
   }
   
   //Accessor
   //Compares each card and sees if the total compairs that were true are 4
   private boolean isFullHouse(PlayingCard[] cards)
   {
       int samecard = 0;
       if(cards[0].getRank() == cards[1].getRank())
           samecard++;
       if(cards[0].getRank() == cards[2].getRank())
           samecard++;
       if(cards[0].getRank() == cards[3].getRank())
           samecard++;
       if(cards[0].getRank() == cards[4].getRank())
           samecard++;
       if(cards[1].getRank() == cards[2].getRank())
           samecard++;
       if(cards[1].getRank() == cards[3].getRank())
           samecard++;
       if(cards[1].getRank() == cards[4].getRank())
           samecard++;
       if(cards[2].getRank() == cards[3].getRank())
           samecard++;
       if(cards[2].getRank() == cards[4].getRank())
           samecard++;
       if(cards[3].getRank() == cards[4].getRank())
           samecard++;
       
       if(samecard == 4)
           return true;
       else
           return false;
   }
   
   //Accessor
   //Checks for all possible three of a kind
   private static boolean isThreeOfAKind(PlayingCard[] cards)
   {
       if(cards[0].getRank() == cards[1].getRank() && cards[0].getRank() == cards[2].getRank())
           return true;
       
       if(cards[0].getRank() == cards[1].getRank() && cards[0].getRank() == cards[3].getRank())
           return true;
       
       if(cards[0].getRank() == cards[1].getRank() && cards[0].getRank() == cards[4].getRank())
           return true;
       
       if(cards[0].getRank() == cards[2].getRank() && cards[0].getRank() == cards[3].getRank())
           return true;
       
       if(cards[0].getRank() == cards[2].getRank() && cards[0].getRank() == cards[4].getRank())
           return true;
         
       if(cards[0].getRank() == cards[3].getRank() && cards[0].getRank() == cards[4].getRank())
           return true;
       
       if(cards[1].getRank() == cards[2].getRank() && cards[1].getRank() == cards[3].getRank())
           return true;
       
       if(cards[1].getRank() == cards[2].getRank() && cards[1].getRank() == cards[4].getRank())
           return true;
       
       if(cards[1].getRank() == cards[3].getRank() && cards[1].getRank() == cards[4].getRank())
           return true;
       
       if(cards[2].getRank() == cards[3].getRank() && cards[2].getRank() == cards[4].getRank())
           return true;
       
       return false;
   }
   
   //Accessor
   //For loops run through an array and compare cards if there are two pairs it returns true
   private static boolean isTwoPairs(PlayingCard[] cards)
   {
       int pairnums = 0;
       for(int i = 0; i<cards.length-1;i++)
       {
           for(int j = i+1; j<cards.length;j++)
           {
               if(cards[i].getRank() == cards[j].getRank())
                   pairnums++;
           }
       }
       
       if(pairnums == 2)     
           return true;
       else
           return false;
       
      
   }
   
   //Accessor
   //For loops run through an array and compare cards if there is one pair it returns true
   private static boolean isOnePair(PlayingCard[] cards)
   {
       int pairnums = 0;
       for(int i = 0; i<cards.length-1;i++)
       {
           for(int j = i+1; j<cards.length;j++)
           {
               if(cards[i].getRank() == cards[j].getRank())
                   pairnums++;
           }
       }
       
       if(pairnums == 1)
       
           return true;
       else
           return false;
       
   }
   
   //Accessor
   //Compares card suits and sees if they are all the same
   private boolean sameSuit(PlayingCard[] cards)
   {
       if(cards[0].getSuit() == cards[1].getSuit() && cards[0].getSuit() == cards[2].getSuit() && 
               cards[0].getSuit() == cards[3].getSuit() && cards[0].getSuit() == cards[4].getSuit())
       return true;
       else
       return false;
   }
   
   //Accessor
   //Returns the number value of the card
   private int cardNumber(PlayingCard card)
   {
       //depending on the suit the card number goes up or the same
       int cardnum = 0;
       if(card.getSuit() == PlayingCard.CardSuit.CLUBS)
               cardnum += 0;
       if(card.getSuit() == PlayingCard.CardSuit.DIAMONDS)
               cardnum += 13;
       if(card.getSuit() == PlayingCard.CardSuit.HEARTS)
               cardnum += 26;
       if(card.getSuit() == PlayingCard.CardSuit.SPADES)
               cardnum += 39;
        
       
      //depending on the rank the card value goes up or stays the same 
       if(card.getRank() == PlayingCard.CardRank.DEUCE)
               cardnum += 0;
       if(card.getRank() == PlayingCard.CardRank.TREY)
               cardnum += 1;
       if(card.getRank() == PlayingCard.CardRank.FOUR)
               cardnum += 2;
       if(card.getRank() == PlayingCard.CardRank.FIVE)
               cardnum += 3;
       if(card.getRank() == PlayingCard.CardRank.SIX)
               cardnum += 4;
       if(card.getRank() == PlayingCard.CardRank.SEVEN)
               cardnum += 5;
       if(card.getRank() == PlayingCard.CardRank.EIGHT)
               cardnum += 6;
       if(card.getRank() == PlayingCard.CardRank.NINE)
               cardnum += 7;
       if(card.getRank() == PlayingCard.CardRank.TEN)
               cardnum += 8;
       if(card.getRank() == PlayingCard.CardRank.JACK)
               cardnum += 9;
       if(card.getRank() == PlayingCard.CardRank.QUEEN)
               cardnum += 10;
       if(card.getRank() == PlayingCard.CardRank.KING)
               cardnum += 11;
       if(card.getRank() == PlayingCard.CardRank.ACE)
               cardnum += 12;
              
       
       return cardnum;
   }
   
   public String toString()
   {
       return this.hand[0]+" "+this.hand[1]+" "+this.hand[2]+" "+this.hand[3]+" "+this.hand[4];
   }
}