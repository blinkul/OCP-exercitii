package chapter8.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreams {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File outFile = new File("files\\serializationAnimals.txt");
        if (!outFile.exists()) {
            outFile.createNewFile();
        }

        List<Animal> saveAnimals = new ArrayList<>();
        saveAnimals.add(new Animal("Tiger", 10, 'P'));
        saveAnimals.add(new Animal("Deer", 4, 'F'));

        writeObjects(saveAnimals, outFile);
        List<Animal> loadedAnimals = getAnimals(outFile);

        for (Animal animal : loadedAnimals) {
            System.out.println(animal.toString());
        }
    }

    public static void writeObjects(List<Animal> list, File outFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)))) {
            for (Animal animal : list) {
                out.writeObject(animal);
            }
        }
    }

    public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        try (ObjectInputStream out = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object obj = out.readObject();
                if (obj instanceof Animal) {
                    animals.add((Animal) obj);
                }
            }
        } catch (EOFException eof) {
            System.out.println("End of file reached.");
        }
        return animals;
    }
}
