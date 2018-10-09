import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Poker {

    public static boolean checkStraight(ArrayList<Card> t) {
        //bug for handle A 13 12 11 10 9
        for (int i = 0; i < 5; i++) {
            if (t.get(0).rank != t.get(i).rank + i) {
                return false;
            }
        }
        return true;
    }

    //same colour
    public static boolean checkFlush(ArrayList<Card> t) {
//        check the suit not same suit
        for (int i = 0; i < 5; i++) {
            if (t.get(0).suit != t.get(i).suit) {
                return false;
            }
        }
        return true;
    }

    //Full house: same 3+2
    public static boolean checkFullHouse(ArrayList<Card> t) {

        if ( (t.get(1).rank == t.get(2).rank) && (t.get(3).rank == t.get(4).rank) && (t.get(4).rank == t.get(5).rank) ){
            return true;
        }
        if ( (t.get(4).rank == t.get(5).rank) && (t.get(1).rank == t.get(2).rank) && (t.get(2).rank == t.get(3).rank) ){
            return true;
        }
        return false;
    }

    //Four of a kind: 4+1
    public static boolean checkFourOfAKind(ArrayList<Card> t) {

    if ( (t.get(0).suit == t.get(1).suit) && (t.get(1).suit == t.get(2).suit) && (t.get(2).suit == t.get(3).suit)
                && (t.get(3).suit == t.get(4).suit) ){
        return true;
    }
        if ( (t.get(1).suit == t.get(2).suit) && (t.get(2).suit == t.get(3).suit) && (t.get(3).suit == t.get(4).suit)
                && (t.get(4).suit == t.get(5).suit) ){
            return true;
        }
        return false;
    }


    public static boolean betterThanStraight(ArrayList<Card> t) {
        return ( checkStraight(t) || checkFlush(t) || checkFourOfAKind(t) || checkFullHouse(t) );
    }

    //AABBC
    //AAABC
    public static boolean oneAwayFullHouse(ArrayList<Card> t) {
        //AAABC
        if ((t.get(0).rank == t.get(1).rank) && (t.get(1).rank == t.get(2).rank) ){
            return true;
        }
        //BAAAC
        if ((t.get(1).rank == t.get(2).rank) && (t.get(2).rank == t.get(3).rank) ){
            return true;
        }
        //BCAAA
        if ((t.get(2).rank == t.get(3).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }

        //AABBC
        if ((t.get(0).rank == t.get(1).rank) && (t.get(2).rank == t.get(3).rank) ){
            return true;
        }
        //AACBB
        if ((t.get(0).rank == t.get(1).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }
        //CAABB
        if ((t.get(1).rank == t.get(2).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }
        return false;
    }


    public boolean oneAwayFlush(ArrayList<Card> t){
        int counter =0;
        int position=0;
        for (int i = 0; i < 5; i++) {
            if (t.get(0).suit != t.get(i).suit) {
                counter = counter +1;
                position = i;
            }
        }
        if (counter == 1){
            return true;
        }
        else{
            return false;
        }

    }

    //one away from straight 12349
    //bug didn't handle 14567
    public boolean oneAwayStraight(ArrayList<Card> t){
        int counter =0;
        int position=0;
        for (int i = 0; i < 5; i++) {
            if (t.get(0).rank != t.get(i).rank + i) {
                counter = counter +1 ;
                position = i;
            }
        }
        if (counter ==1){
            return true;
        }
        else{
            return false;
        }

    }

    //3 cards same rank AAAXX
    public boolean threeSameRank(ArrayList<Card> t){
        //AAABC
        if ((t.get(0).rank == t.get(1).rank) && (t.get(1).rank == t.get(2).rank) ){
            return true;
        }
        //BAAAC
        if ((t.get(1).rank == t.get(2).rank) && (t.get(2).rank == t.get(3).rank) ){
            return true;
        }
        //BCAAA
        if ((t.get(2).rank == t.get(3).rank) && (t.get(3).rank == t.get(4).rank) ){
            return true;
        }
        return false;
    }

    //three card in a seq
    public boolean threeInSeq(ArrayList<Card> t){
       if ( (t.get(0).rank == t.get(1).rank + 1) && (t.get(1).rank == t.get(2).rank + 1) ){
           return true;
       }
        if ( (t.get(1).rank == t.get(2).rank + 1) && (t.get(2).rank == t.get(3).rank + 1) ){
            return true;
        }

        if ( (t.get(2).rank == t.get(3).rank + 1) && (t.get(3).rank == t.get(4).rank + 1) ){
            return true;
        }
        return false;
    }




    public boolean win(int a, int b) {

        System.out.println("a is " + a);
        System.out.println("b is " + b);
        return (a > b);

    }


    public static void readCard() {
        ArrayList allGames = new ArrayList();


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Mao\\eclipse-workspace\\Comp4004a1\\data"))) {
            String line;
            String[] tempArray;
            while ((line = br.readLine()) != null) {
                ArrayList oneGames = new ArrayList();
                ArrayList<Card> hand = new ArrayList<Card>();
                ArrayList<Card> init = new ArrayList<Card>();
                ArrayList<Card> exchange = new ArrayList<Card>();

                System.out.println(line);
                tempArray = line.split(" ");

                for (int i = 0; i < 5; i++) {
                    Card a = new Card();
                    a.suit = tempArray[i].charAt(0);
                    a.rank = convert(tempArray[i]);
                    hand.add(a);
                }
                for (int i = 5; i < 10; i++) {
                    Card a = new Card();
                    a.suit = tempArray[i].charAt(0);
                    a.rank = convert(tempArray[i]);
                    init.add(a);
                }
                for (int i = 10; i < 12; i++) {
                    Card a = new Card();
                    a.suit = tempArray[i].charAt(0);
                    a.rank = convert(tempArray[i]);
                    exchange.add(a);
                }
                Collections.sort(hand, Card::compareTo);
                Collections.sort(init, Card::compareTo);
                Collections.sort(exchange, Card::compareTo);
                oneGames.add(hand);
                oneGames.add(init);
                oneGames.add(exchange);
                allGames.add(oneGames);

                System.out.println("this is all games");
                System.out.println(allGames);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static int convert(String a) {
        if (a.length() == 3) {
            return 10;
        } else {
            if (a.charAt(1) == 74) {
                return 11;
            } else if (a.charAt(1) == 81) {
                return 12;
            } else if (a.charAt(1) == 75) {
                return 13;
            } else if (a.charAt(1) == 65) {
                return 1;
            } else {
                int k = a.charAt(1) - 48;
                return k;
            }
        }
    }


    public static void main(String[] args) {
        readCard();


    }

}
