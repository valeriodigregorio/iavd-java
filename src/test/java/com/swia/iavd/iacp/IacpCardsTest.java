package com.swia.iavd.iacp;

import com.swia.iavd.IavdFile;
import com.swia.iavd.model.Affiliation;
import com.swia.iavd.model.Card;
import com.swia.iavd.model.CardSystem;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IacpCardsTest {
    
    private static class CardList extends ArrayList<Card> {
        
        void addCard(Card card) {
            assertNotEquals(null, card);
            super.add(card);
        }

        void validate() throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IavdFile.save(baos, this);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            List<Card> loadedCards = IavdFile.load(bais);
            assertIterableEquals(this, loadedCards);
        }

    }
    
    @Test
    void test_season_4() {
        CardList cards = new CardList();
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Lando Calrissian", true, true, "Charming Gambler"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Jyn Erso", true, true, "Stardust"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Loku Kanoloa", true, true, "Deadly Marksman"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Verena Talos", true, true, "Student of Battle"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "AT-RT", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Rebel Pathfinder", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Rebel Saboteur", true, false));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Built on Hope"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "General Sorin", true, true, "Vicious Tactician"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Director Krennic", true, true, "Aspirational Officer"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Agent Blaise", true, true, "ISB Interrogator"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "E-Web Engineer", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Overwatch", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Shoretrooper", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Mortar Trooper", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "ISB Infiltrator", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Royal Guard", true, false));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Deploy the Garrison!"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Bossk", true, true, "Born Hunter"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "The Mandalorian", true, true, "Renegade Hunter"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "IG-11", true, true, "To Nurse and Protect"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Trandoshan Hunter", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Clan of Two", true, true));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Guild Programming"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Whistling Birds"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.NEUTRAL, "The Darksaber", true, true, "Weapon of the Ancients"));

        try {
            cards.validate();
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException not expected");
        }
    }

}
