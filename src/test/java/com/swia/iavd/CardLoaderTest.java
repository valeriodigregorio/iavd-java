package com.swia.iavd;

import static org.junit.jupiter.api.Assertions.*;

import com.swia.iavd.model.CardSystem;
import org.junit.jupiter.api.Test;

import com.swia.iavd.model.Card;
import com.swia.iavd.model.CardMock;

import java.io.IOException;

class CardLoaderTest {

    @Test
    void test_null_card_system() {
        try {
            new CardDataset((CardSystem) null);
        } catch (IOException e) {
            fail("IOException not expected");
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    @Test
    void test_null_cards() {
        try {
            new CardDataset((Card[]) null);
        } catch (NullPointerException e) {
            return;
        }
        fail("NullPointerException expected");
    }

    @Test
    void test_empty() {
        new CardDataset(new CardMock[]{});
    }

    @Test
    void test_cards() {
        try {
            Card[] cards = new Card[]{
                    new CardMock(1, "test/1"),
                    new CardMock(2, "test/2")
            };
            CardDataset dataset = new CardDataset(cards);
            for (Card card : cards) {
                assertEquals(card, dataset.getCard(card.getId()));
            }
            assertNull(dataset.getCard(cards.length + 1));
        } catch (Exception e) {
            fail("Exception not expected");
        }
    }

}
