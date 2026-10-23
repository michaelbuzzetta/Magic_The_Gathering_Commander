package com.mtgcommandersimulator.integration;

import mage.cards.Card;
import mage.cards.CardSetInfo;
import mage.cards.s.SolRing;
import mage.constants.CardType;
import mage.constants.Rarity;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.UUID;

public class RealCardInstantiationTest {

    @Test
    public void createsRealPlayableSolRing() {

        CardSetInfo setInfo = new CardSetInfo(
            "Sol Ring",
            "C21",
            "263",
            Rarity.UNCOMMON
        );

        Card card = new SolRing(
            UUID.randomUUID(),
            setInfo
        );

        assertNotNull(card);

        assertEquals("Sol Ring", card.getName());

        assertTrue(card.getCardType().contains(CardType.ARTIFACT));

        assertFalse(
            "Sol Ring must have its activated mana ability",
            card.getAbilities().isEmpty()
        );

        System.out.println(
            "[PASS] Real XMage Sol Ring instantiated with abilities"
        );
    }
}
