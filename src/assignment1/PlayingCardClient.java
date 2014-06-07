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
import javax.swing.JOptionPane;
/**
 *
 * @author alvarodecastro
 */
public class PlayingCardClient {
    public static void main(String[] args)
   {
      String deck = "";
      for (PlayingCard.CardSuit suit : PlayingCard.CardSuit.values())
      {
         for (PlayingCard.CardRank rank : PlayingCard.CardRank.values())
         {
            PlayingCard card = new PlayingCard(suit, rank);
            deck += card + "  ";
         }
         deck = deck.trim() + "\n";
      }
      deck = deck.trim();    
      JOptionPane.showMessageDialog( null, deck, "Playing Cards",
                                     JOptionPane.PLAIN_MESSAGE );
      
      PlayingCard card = randomCard();
    
      String message = " Card: " + card + "\n" + 
                       " Rank: " + card.getRank() + "\n" +
                       " Suit: " + card.getSuit() + "\n\n";

      PlayingCard other = randomCard();
      message += card + (card.equals(other) ? " = " : " != ") + other + "\n" +
                 (card.compareTo(other) < 0 ? card + " < " + other + "\n" : "") +
                 (card.compareTo(other) > 0 ? card + " > " + other + "\n" : "") ;
                 
      JOptionPane.showMessageDialog( null, message, "PlayingCard Methods",
                                     JOptionPane.PLAIN_MESSAGE );
   }
   
   private static PlayingCard randomCard()
   {
      Random gen = new Random();
      return new PlayingCard(PlayingCard.CardSuit.values()[ gen.nextInt(PlayingCard.NUMBER_OF_SUITS) ],
                             PlayingCard.CardRank.values()[ gen.nextInt(PlayingCard.NUMBER_OF_RANKS) ] );
   }
}
