import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Poker {

    public static boolean checkStraight(ArrayList<Card> t){

        //check the suit not same suit
        for (int i=0;i<5;i++) {
            if (t.get(0).suit != t.get(i).suit) {
                return false;
            }
        }

        //bug for handle A 13 12 11 10 9
        for (int i = 0;i<5;i++){
            if (t.get(0).rank != t.get(i).rank+i) {
                return false;
            }
        }





    return true;
    }






	public boolean win (int a , int b ) {

		System.out.println("a is " + a);
		System.out.println("b is " + b);
		return (a>b);

	}


	public static void readCard() {
		ArrayList allGames = new ArrayList();
		ArrayList oneGames = new ArrayList();

		ArrayList<Card> hand = new ArrayList<Card> ();
		ArrayList<Card> init = new ArrayList<Card> ();
		ArrayList<Card> exchange = new ArrayList<Card> ();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Mao\\eclipse-workspace\\Comp4004a1\\data"))) {
		    String line;
		    String[] tempArray;
		    while ((line = br.readLine()) != null) {
		       System.out.println(line);
		       tempArray = line.split(" ");



		       for (int i =0 ;i<5;i++) {
                   Card a = new Card();
                   a.suit = tempArray[i].charAt(0);
                   a.rank = convert(tempArray[i]);
                   hand.add(a);
		       }
		       for (int i =5 ;i<10;i++) {
                   Card a = new Card();
                   a.suit = tempArray[i].charAt(0);
                   a.rank = convert(tempArray[i]);
                   init.add(a);
		       }
                for (int i =10 ;i<12;i++) {
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

		    }
//		    System.out.println(hand);
//            System.out.println(hand.get(0) + "9999999999999999999");
//		    System.out.println(init);
//		    System.out.println(exchange);
//		    System.out.println(oneGames);
		    System.out.println(allGames);

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
            }
            else if (a.charAt(1) == 81) {
                return 12;
            }
            else if (a.charAt(1) == 75) {
                return 13;
            }
            else if (a.charAt(1) == 65) {
                return 1;
            }
            else{
                int k = a.charAt(1) - 48;
                return  k;
            }
        }
    }



	public static void main(String[] args){
		readCard();


	}

}
