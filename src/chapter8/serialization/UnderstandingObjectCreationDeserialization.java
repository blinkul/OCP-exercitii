package chapter8.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UnderstandingObjectCreationDeserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File outFile = new File("files\\serializationPlants.txt");
        if (!outFile.exists()) {
            outFile.createNewFile();
        }

        List<Plant> savePlants = new ArrayList<>();
        savePlants.add(new Plant("Red", 5, 'T'));
        savePlants.add(new Plant("Blue", 8, 'P'));

        writeObjects(savePlants, outFile);
        List<Plant> loadedPlants = getAnimals(outFile);

        for (Plant animal : loadedPlants) {
            System.out.println(animal.toString());
        }
    }

    public static void writeObjects(List<Plant> list, File outFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)))) {
            for (Plant animal : list) {
                out.writeObject(animal);
            }
        }
    }

    public static List<Plant> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Plant> animals = new ArrayList<>();
        try (ObjectInputStream out = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object obj = out.readObject();
                if (obj instanceof Plant) {
                    animals.add((Plant) obj);
                }
            }
        } catch (EOFException eof) {
            System.out.println("End of file reached.");
        }
        return animals;
    }
}
