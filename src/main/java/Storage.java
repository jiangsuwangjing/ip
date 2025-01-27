import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Storage {
    private static final File dataDir = new File("./data");
    private static final File dataFile = new File("./data/alex.txt");

    public void saveData(String data) {
        try {
            if (!dataDir.exists()) {
                dataDir.mkdirs(); // Create the ./data directory if not exists
            }

            // Write data to the file
            FileWriter writer = new FileWriter(dataFile, true);
            writer.write(data);
            writer.close();

            System.out.println("Data saved to " + dataFile);
        } catch (IOException e) {
            System.err.println("An error occurred while saving data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        String data = "test test";
        storage.saveData(data);
    }
}
