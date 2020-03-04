# Imperial Assault Vassal Deck File Parser for Java (iavd-java)
This parser for Java and Android allows your project to save/load Vassal deck files.

# Usage examples

## Load Vassal deck file
```
File file = new File(path);
InputStream is = new FileInputStream(file);
List<Card> cards = IavdFile.load(is)
```

## Save Vassal deck file
```
File file = new File(path);
OutputStream os = new FileOutputStream(file);
IavdFile.save(os, cards)
```

## Load Vassal deck file
```
Card deploymentCard = IavdFile.getCard(CardSystem.FFG, Affiliation.IMPERIAL, "Darth Vader", true, true, "Lord of the Sith");
Card commandCard = IavdFile.getCard(CardSystem.IACP, "Get Behind Me!");
```

# Building package
In order to to build this project you need to clone [iavd-dataset](https://github.com/valeriodigregorio/iavd-dataset) in src/main/resources.
```
cd src/main/resources
git clone https://github.com/valeriodigregorio/iavd-dataset.git .
```
You can then generate the .jar file (using Maven) and import it in your project as a dependency.