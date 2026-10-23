package com.mtgcommandersimulator.integration;

import mage.cards.decks.Deck;
import mage.cards.decks.DeckCardInfo;
import mage.cards.decks.DeckCardLists;
import mage.cards.repository.CardInfo;
import mage.cards.repository.CardRepository;
import mage.cards.repository.CardScanner;
import mage.game.CommanderFreeForAll;
import mage.game.CommanderFreeForAllMatch;
import mage.game.match.MatchOptions;
import mage.players.Player;
import mage.player.ai.ComputerPlayer;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FourPlayerCommanderInitializationTest {

    @Test
    public void initializesFourPlayersWithRealDecks() throws Exception {

        CardScanner.scan();

        MatchOptions options = new MatchOptions(
            "MTG Commander Simulator - Four Player Test",
            "Commander",
            true
        );

        options.setDeckType("Commander");

        CommanderFreeForAllMatch match =
            new CommanderFreeForAllMatch(options);

        CardInfo plains =
            CardRepository.instance.findCard("Plains", true);

        CardInfo isamaru =
            CardRepository.instance.findCard(
                "Isamaru, Hound of Konda", true
            );

        assertNotNull(plains);
        assertNotNull(isamaru);

        Set<UUID> expectedPlayerIds = new HashSet<>();

        for (int i = 1; i <= 4; i++) {

            DeckCardLists deckList = new DeckCardLists();
            deckList.setName("AI Commander Deck " + i);

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
                    isamaru.getName(),
                    isamaru.getCardNumber(),
                    isamaru.getSetCode(),
                    1
                )
            );

            Deck deck = Deck.load(deckList, false, false);

            assertEquals(99, deck.getCards().size());
            assertEquals(1, deck.getSideboard().size());

            ComputerPlayer player = new ComputerPlayer(
                "AI Player " + i,
                options.getRange()
            );

            expectedPlayerIds.add(player.getId());

            match.addPlayer(player, deck);
        }

        assertEquals(4, match.getPlayers().size());

        match.startGame();

        assertNotNull(match.getGame());

        assertTrue(
            match.getGame() instanceof CommanderFreeForAll
        );

        assertEquals(
            "Game must contain four players",
            4,
            match.getGame().getPlayers().size()
        );

        for (UUID playerId : expectedPlayerIds) {

            Player player = match.getGame().getPlayer(playerId);

            assertNotNull("Player must be registered", player);

            assertEquals(
                "Library must contain 99 cards before opening hands",
                99,
                player.getLibrary().size()
            );

            assertEquals(
                "Sideboard must contain the commander",
                1,
                player.getSideboard().size()
            );
        }

        assertEquals(
            "Commander starting life must be 40",
            40,
            match.getGame().getStartingLife()
        );

        System.out.println(
            "[PASS] Four AI players initialized with complete Commander decks"
        );
    }
}