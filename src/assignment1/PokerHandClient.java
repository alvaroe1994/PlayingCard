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
public class PokerHandClient
{
   public static void main(String[] args)
   {
      PlayingCardDeck deck = new PlayingCardDeck();

      for (PokerHand.HandType type : PokerHand.HandType.values())
      {
         PokerHand hand;
         do
         {
            hand = new PokerHand();
            deck.shuffle();
            for (int k = 1; k <= PokerHand.POKER_HAND_SIZE; k++)
               hand.addCard( deck.deal() );
         } while (hand.type() != type);
         
         JOptionPane.showMessageDialog( null, hand, type.toString(),
                                        JOptionPane.PLAIN_MESSAGE );
      }
              
       
   }  
}