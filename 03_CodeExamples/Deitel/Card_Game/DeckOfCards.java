// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;

public class DeckOfCards {
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

   private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
   private int currentCard = 0; // index of next Card to be dealt (0-51)

   // constructor fills deck of Cards
   public DeckOfCards() {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};      

      // populate deck with Card objects                   
      for (int count = 0; count < deck.length; count++) {  
         deck[count] =                                     
            new Card(faces[count % 13], suits[count / 13]);
      }                                                    
   } 

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle() {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) {
         // select a random number between 0 and 51 
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // swap current Card with randomly selected Card
         Card temp = deck[first];   
         deck[first] = deck[second];
         deck[second] = temp;       
      } 
   } 

   // deal one Card
   public Card dealCard() {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length) {
         return deck[currentCard++]; // return current Card in array
      } 
      else {
         return null; // return null to indicate that all Cards were dealt
      } 
   } 
} 

