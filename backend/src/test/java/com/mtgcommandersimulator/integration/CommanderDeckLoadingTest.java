package com.mtgcommandersimulator.integration;

import mage.cards.decks.Deck;
import mage.cards.decks.DeckCardLists;
import mage.cards.decks.DeckCardInfo;
import mage.cards.repository.CardScanner;
import mage.cards.repository.CardRepository;
import mage.cards.repository.CardInfo;

import org.junit.Test;
import static org.junit.Assert.*;

public class CommanderDeckLoadingTest {

    @Test
    public void loadsCompleteCommanderDeck() throws Exception {

        CardScanner.scan();

        DeckCardLists deckList = new DeckCardLists();
        deckList.setName("Isamaru Commander Test");

        CardInfo plains = CardRepository.instance.findCard("Plains", true);
        CardInfo commander = CardRepository.instance.findCard(
            "Isamaru, Hound of Konda", true
        );

        assertNotNull("Plains must exist", plains);
        assertNotNull("Commander must exist", commander);

        deckList.getCards().add(
            new DeckCardInfo(
                plains.getName(),
                plains.getCardNumber(),
                plains.getSetCode(),
                99
            )
        );

        deckList.getSideboard().add(
            new DeckCardInfo(
                commander.getName(),
                commander.getCardNumber(),
                commander.getSetCode(),
                1
            )
        );

        Deck deck = Deck.load(deckList, false, false);

        assertEquals(
            "Main deck must contain 99 cards",
            99,
            deck.getCards().size()
        );

        assertEquals(
            "Commander must be in sideboard",
            1,
            deck.getSideboard().size()
        );

        assertEquals(
            "Deck must contain exactly 100 cards",
            100,
            deck.getCards().size() + deck.getSideboard().size()
        );

        System.out.println(
            "[PASS] Complete 100-card Commander deck loaded"
        );
    }
}