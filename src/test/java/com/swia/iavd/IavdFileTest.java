package com.swia.iavd;

import com.swia.iavd.model.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IavdFileTest {

    void test_parser(List<Card> cards) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(10240);
        IavdFile.save(baos, cards);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        List<Card> loadedCards = IavdFile.load(bais);
        assertIterableEquals(cards, loadedCards);
    }

    @Test
    void test_null() throws IOException {
        try {
            test_parser(null);
        } catch (NullPointerException e) {
            return;
        }
        fail("IllegalArgumentException expected");
    }

    @Test
    void test_empty() throws IOException {
        test_parser(new ArrayList<>());
    }

    @Test
    void test_army_ffg() throws IOException {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(IavdFile.getCard(CardSystem.FFG, Affiliation.IMPERIAL, "Darth Vader", true, true, "Lord of the Sith"));
        cards.add(IavdFile.getCard(CardSystem.FFG, Affiliation.IMPERIAL, "Driven by Hatred", true, false));
        cards.add(IavdFile.getCard(CardSystem.FFG, Affiliation.IMPERIAL, "Imperial Officer", false, false));
        cards.add(IavdFile.getCard(CardSystem.FFG, "Officer's Training"));
        test_parser(cards);
    }

    @Test
    void test_army_iacp() throws IOException {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(IavdFile.getCard(CardSystem.IACP, Affiliation.IMPERIAL, "Darth Vader", true, true, "Lord of the Sith"));        // FFG
        cards.add(IavdFile.getCard(CardSystem.IACP, Affiliation.IMPERIAL, "The Grand Inquisitor", true, true, "Sith Loyalist"));  // FFG remade by IACP
        cards.add(IavdFile.getCard(CardSystem.IACP, Affiliation.MERCENARY, "Zuckuss", true, true, "Gand Findsman"));              // IACP only
        cards.add(IavdFile.getCard(CardSystem.IACP, "Officer's Training")); // FFG
        cards.add(IavdFile.getCard(CardSystem.IACP, "Parry"));              // FFG remade by IACP
        cards.add(IavdFile.getCard(CardSystem.IACP, "Get Behind Me!"));     // IACP only
        test_parser(cards);
    }

    @Test
    void test_invalid_card() {
        assertNull(IavdFile.getCard(CardSystem.IACP, "UNKNOWN CARD"));
    }

    @Test
    void test_valid_deployment_card() {
        try {
            DeploymentCard card = (DeploymentCard) IavdFile.getCard(CardSystem.IACP, Affiliation.MERCENARY, "Zuckuss", true, true, "Gand Findsman");
            assertEquals(Affiliation.MERCENARY, card.getAffiliation());
            assertEquals("Zuckuss", card.getName());
            assertTrue(card.isUnique());
            assertTrue(card.isElite());
            assertEquals("Gand Findsman", card.getDescription());
            assertEquals("iacp/15263", card.getIavd());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException not expected");
        }
    }

    @Test
    void test_valid_command_card() {
        try {
            CommandCard card = (CommandCard) IavdFile.getCard(CardSystem.IACP, "Urgency");
            assertEquals("Urgency", card.getName());
            assertEquals("ffg/9100", card.getIavd());
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException not expected");
        }
    }


    @Test
    void test_get_card_by_name() {
        try {
            DeploymentCard card = (DeploymentCard) IavdFile.getCard(CardSystem.IACP, Affiliation.MERCENARY, "Zuckuss", true, true, "Gand Findsman");
            Card c = IavdFile.getCardByName(CardSystem.IACP, card.getId());
            assertEquals(card, c);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException not expected");
        }
    }
}
