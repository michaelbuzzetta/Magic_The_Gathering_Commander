package com.mtgcommandersimulator.integration;

import mage.game.CommanderFreeForAll;
import mage.game.CommanderFreeForAllMatch;
import mage.game.match.MatchOptions;

import org.junit.Test;
import static org.junit.Assert.*;

public class CommanderGameCreationTest {

    @Test
    public void createsRealXMageCommanderGame() throws Exception {

        MatchOptions options = new MatchOptions(
            "MTG Commander Simulator Test",
            "Commander",
            true
        );

        options.setDeckType("Commander");

        CommanderFreeForAllMatch match =
            new CommanderFreeForAllMatch(options);

        assertNotNull(match);
        assertEquals("MTG Commander Simulator Test",
                     match.getName());

        match.startGame();

        assertNotNull("Game must exist", match.getGame());

        assertTrue(
            "Game must use Commander rules implementation",
            match.getGame() instanceof CommanderFreeForAll
        );

        System.out.println(
            "[PASS] Real XMage Commander game created"
        );
    }
}
