package com.mtgcommandersimulator.integration;

import mage.cards.decks.Deck;
import mage.game.CommanderFreeForAllMatch;
import mage.game.match.MatchOptions;
import mage.player.ai.ComputerPlayer;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FourAIPlayerRegistrationTest {

    @Test
    public void registersFourAIPlayers() {

        MatchOptions options = new MatchOptions(
            "MTG Commander Simulator - Four AI Test",
            "Commander",
            true
        );

        options.setDeckType("Commander");

        CommanderFreeForAllMatch match =
            new CommanderFreeForAllMatch(options);

        Set<UUID> playerIds = new HashSet<>();

        for (int i = 1; i <= 4; i++) {

            ComputerPlayer player = new ComputerPlayer(
                "AI Player " + i,
                options.getRange()
            );

            Deck deck = new Deck();

            match.addPlayer(player, deck);

            assertTrue(
                "Each player must have a unique ID",
                playerIds.add(player.getId())
            );
        }

        assertEquals(
            "Exactly four players should be registered",
            4,
            match.getPlayers().size()
        );

        System.out.println(
            "[PASS] Four distinct XMage AI players registered"
        );
    }
}