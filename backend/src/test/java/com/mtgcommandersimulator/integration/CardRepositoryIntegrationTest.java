package com.mtgcommandersimulator.integration;

import mage.cards.Card;
import mage.cards.repository.CardInfo;
import mage.cards.repository.CardRepository;
import mage.cards.repository.CardScanner;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardRepositoryIntegrationTest {

    @Test
    public void loadsRealCardFromRepository() {

        CardScanner.scan();

        CardInfo info = CardRepository.instance.findCard("Sol Ring", true);

        assertNotNull(
            "Sol Ring must exist in the XMage card repository",
            info
        );

        Card card = info.createCard();

        assertNotNull(card);
        assertEquals("Sol Ring", card.getName());

        assertFalse(
            "Real Sol Ring must contain abilities",
            card.getAbilities().isEmpty()
        );

        System.out.println(
            "[PASS] Sol Ring loaded from XMage repository"
        );
    }
}