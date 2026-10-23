package com.mtgcommandersimulator.integration;

import org.junit.Test;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import static org.junit.Assert.*;

/** Classpath smoke test only; does not create or play a game. */
public class XMageDependencyTest {
    @Test public void commanderAndAiTypesLoadAndExposeConstructors() throws Exception {
        Class<?> commander = Class.forName("mage.game.CommanderFreeForAll");
        Class<?> match = Class.forName("mage.game.CommanderFreeForAllMatch");
        Class<?> ai = Class.forName("mage.player.ai.ComputerPlayer");
        assertTrue("Commander class must extend GameCommanderImpl",
            Class.forName("mage.game.GameCommanderImpl").isAssignableFrom(commander));
        assertTrue("Commander game must expose a public 5-argument constructor",
            Arrays.stream(commander.getConstructors()).anyMatch(c -> c.getParameterCount() == 5));
        assertTrue("Match must expose a public one-argument constructor",
            Arrays.stream(match.getConstructors()).anyMatch(c -> c.getParameterCount() == 1));
        assertTrue("AI must expose a public two-argument constructor",
            Arrays.stream(ai.getConstructors()).anyMatch(c -> c.getParameterCount() == 2));
    }
}
