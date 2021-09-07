package com.swia.iavd.iacp;

import com.swia.iavd.IavdFile;
import com.swia.iavd.model.*;
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

        boolean validate() throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IavdFile.save(baos, this);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            List<Card> loadedCards = IavdFile.load(bais);
            assertIterableEquals(this, loadedCards);
            return true;
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
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Clan of Two", false, true));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Guild Programming"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Whistling Birds"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.NEUTRAL, "The Darksaber", true, true, "Weapon of the Ancients"));

        assertDoesNotThrow(cards::validate);
    }

    @Test
    void test_season_5() {
        CardList cards = new CardList();
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Overwhelming Impact"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Apex Predator"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Feint"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Rapid Recalibration"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Rest in Peace"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Cassian Andor", true, true, "Ruthless Agent"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "K-2S0", true, true, "Rogue Security Droid"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Davith Elso", true, true, "Codename: \"Hawkbat\""));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Murne Rin", true, true, "Deceptive Diplomat"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Luke Skywalker", true, true, "Jedi Knight"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Biv Bodhrik", true, true, "Fueled by Vengeance"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Fury of Kashyyyk", false, true));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Sniper Configuration"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Blend In"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "AT-ST", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Heavy Stormtrooper", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Captain Terro", true, true, "Wasteland Enforcer"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Iden Versio", true, true, "Inferno Commander"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Agent Kallus", true, true, "Tenacious Investigator"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "The General's Ranks", true, false));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Cavalry Charge"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Static Pulse"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Face Me!"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Deploy the Garrison!"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Wampa", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "HK-47", true, true, "Faithful Meatbag Exterminator"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Doctor Aphra", true, true, "Rogue Archaeologist"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Dengar", true, true, "Ruthless Killer"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Zuckuss", true, true, "Gand Findsman"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Under Duress", false, true));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Definition: 'Love'"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Windfall"));

        DeploymentCard clawdite = IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Clawdite Shapeshifter", false, false);
        cards.addCard(clawdite);
        assertTrue(clawdite.getIavd().startsWith("iacp/"));

        clawdite = IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Clawdite Shapeshifter", true, false);
        cards.addCard(clawdite);
        assertTrue(clawdite.getIavd().startsWith("iacp/"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.NEUTRAL, "Mara Jade", true, true, "Lost Legend"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Reactive Loyalties"));

        CommandCard assassinate = IavdFile.getCommandCard(CardSystem.IACP, "Assassinate");
        cards.addCard(assassinate);
        assertTrue(assassinate.getIavd().startsWith("iacp/"));

        assertDoesNotThrow(cards::validate);
    }

    @Test
    void test_season_6() {
        CommandCard deployTheGarrison = IavdFile.getCommandCard(CardSystem.IACP, "Deploy the Garrison!");
        assertEquals("iacp/16068", deployTheGarrison.getIavd());

        CommandCard coveringFire = IavdFile.getCommandCard(CardSystem.IACP, "Covering Fire");
        assertEquals("iacp/10332", coveringFire.getIavd());

        DeploymentCard koTunFeralo = IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Ko-Tun Feralo", true, true, "Rebel Quartermaster");
        assertTrue(koTunFeralo.isElite());

        CardList cards = new CardList();

        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Honoring the Fallen"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Expose Weakness"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Palace Politics"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Covering Fire"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Ambush"));
        cards.addCard(IavdFile.getCommandCard(CardSystem.IACP, "Demoralizing Monologue"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "CT-1701", true, true, "\"Wildfire\""));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Cara Dune", true, true, "Dropper Veteran"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.REBEL, "Z-6 Trooper", true, false));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Flametrooper", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Snowtrooper", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Dark Trooper Mk III", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Dewback Rider", true, false));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.IMPERIAL, "Moff Gideon", true, true, "Ruthless War Criminal"));

        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Bib Fortuna", true, true, "Cunning Majordomo"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "Migs Mayfeld", true, true, "Survivor of Burinin Konn"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "The Mandalorian", true, true, "Rising Phoenix"));
        cards.addCard(IavdFile.getDeploymentCard(CardSystem.IACP, Affiliation.MERCENARY, "First Strike", false, true));

        assertDoesNotThrow(cards::validate);
    }

}
