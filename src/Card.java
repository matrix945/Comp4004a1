
public class Card implements Comparable<Card> {
	char suit;
	int rank;






	public String toString() {

		return (suit+"" + rank);
	}

	@Override
	public int compareTo(Card o) {
		if (this.rank != o.rank)
				return this.rank - o.rank;
		else{
			return (this.suit - o.suit);
		}
	}
}
