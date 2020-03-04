package com.swia.iavd;

import com.swia.iavd.model.Card;
import com.swia.iavd.model.CardSystem;
import com.swia.iavd.model.CommandCard;
import com.swia.iavd.model.DeploymentCard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IavdFile {
    private static final String IAVD_FILE_HEADER = "DECK\t";
    private static final String IAVD_FILE_SEPARATOR = Character.toString((char) 27);
    private static final String IAVD_FILE_CARD_ID_REGEX = ".*piece;;;.*?;(.*?)/.*\\\\	(-*1)\\\\.*\\\\	null;\\d*;\\d*;(\\d*)";

    private static final CardDataset[] datasets = new CardDataset[CardSystem.values().length];

    static {
        for (CardSystem cardSystem : CardSystem.values()) {
            try {
                datasets[cardSystem.ordinal()] = new CardDataset(cardSystem);
            } catch (IOException ignored) {
            }
        }
    }

    public static Card getCard(CardSystem cardSystem, String affiliation, String name, boolean elite, boolean unique, String description) throws IllegalArgumentException {
        return datasets[cardSystem.ordinal()].getCard(DeploymentCard.getId(affiliation, name, elite, unique, description));
    }

    public static Card getCard(CardSystem cardSystem, String name) throws IllegalArgumentException {
        return datasets[cardSystem.ordinal()].getCard(CommandCard.getId(name));
    }

    private static Card getCard(int system, int id) {
        Card card = datasets[CardSystem.FFG.ordinal()].getCard(id);
        if (card != null && system == -1) {
            return card;
        }
        return datasets[CardSystem.IACP.ordinal()].getCard(id);
    }

    public static List<Card> load(InputStream stream) throws IOException {
        Scanner scanner = new Scanner(stream);
        scanner.useDelimiter(IAVD_FILE_SEPARATOR);

        if (!scanner.hasNext() || !scanner.next().equals(IAVD_FILE_HEADER)) {
            throw new IOException("Invalid deck save file format.");
        }

        Pattern pattern = Pattern.compile(IAVD_FILE_CARD_ID_REGEX, Pattern.DOTALL);
        List<Card> list = new ArrayList<>();

        while (scanner.hasNext()) {
            String text = scanner.next();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                int system = Integer.parseInt(matcher.group(2));
                int id = Integer.parseInt(matcher.group(3));
                Card card = IavdFile.getCard(system, id);
                if (card != null) {
                    list.add(card);
                }
            }
        }

        return list;
    }

    public static void save(OutputStream stream, List<Card> cards) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        writer.append(IAVD_FILE_HEADER);
        for (Card card : cards) {
            String resource = ResourceHelper.getResourceContent(card.getIavd());
            writer.append(resource.substring(IAVD_FILE_HEADER.length()));
        }
        writer.close();
    }
}
