package com.swia.iavd;

import com.swia.iavd.model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void test_deployment_card() {
        DeploymentCard card = new DeploymentCard("Mercenary", "Zuckuss", true, true, "Gand Findsman", "iacp/15263");
        assertEquals("Mercenary", card.getAffiliation());
        assertEquals("Zuckuss", card.getName());
        assertTrue(card.isUnique());
        assertTrue(card.isElite());
        assertEquals("Gand Findsman", card.getDescription());
        assertEquals("iacp/15263", card.getIavd());
        assertEquals(CardSystem.IACP, card.getCardSystem());
    }

    @Test
    void test_command_card() {
        CommandCard card = new CommandCard("Urgency", "ffg/9100");
        assertEquals("Urgency", card.getName());
        assertEquals("ffg/9100", card.getIavd());
        assertEquals(CardSystem.FFG, card.getCardSystem());
    }

}
