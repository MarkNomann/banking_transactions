package es.nomann;

import java.util.ArrayList;
import java.util.List;

public class Cards extends Card {

    private List<Card> cards = new ArrayList<>();

    public Cards() {}

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void add(Card card) {
        this.cards.add(card);
    }


}
