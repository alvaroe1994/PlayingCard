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
import javax.swing.*;
public class PlayingCardDeckClient
{
   public static void main(String[] args)
   {
     final int CARDS_IN_HAND = PlayingCardDeck.NUMBER_OF_CARDS / 4;
      PlayingCard[] north = new PlayingCard[CARDS_IN_HAND];
      PlayingCard[] south = new PlayingCard[CARDS_IN_HAND];
      PlayingCard[] east  = new PlayingCard[CARDS_IN_HAND];
      PlayingCard[] west  = new PlayingCard[CARDS_IN_HAND];
      
      PlayingCardDeck deck = new PlayingCardDeck();
      deck.shuffle();
      
      for (int k = 0; k < north.length; k++)
      {
         north[k] = deck.deal();
         east[k]  = deck.deal();
         south[k] = deck.deal();
         west[k]  = deck.deal();
      }
 
      String game = Arrays.toString(north) + "\n" +
                    Arrays.toString(east)  + "\n" +
                    Arrays.toString(south) + "\n" +
                    Arrays.toString(west);
 
      String message = deck.getNumberOfCardsInDeck() + " Cards in the Deck";
      try
      {
         deck.deal();
      }
      catch (RuntimeException exc)
      {
         message += "\n" + exc.getMessage();
      }
      
      JOptionPane.showMessageDialog( null, game + "\n" + message, 
                                     "Full Deck Deal", JOptionPane.PLAIN_MESSAGE );
              
   }   
              
}