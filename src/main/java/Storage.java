import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    private static final String path = "./data/alex.txt";
    private static final File dataDir = new File("./data");
    private static final File dataFile = new File(path);

    public Task loadTaskEntry(String data) throws CorruptDataException {
        try {
            String[] fields = data.split(" \\| ");
            String type = fields[0];
            String status = fields[1];
            String content = fields[2];
            return switch (type) {
                case "T" -> new ToDo(content, status);
                case "D" -> new Deadline(content, status, fields[3]);
                case "E" -> new Event(content, status, fields[3], fields[4]);
                default -> throw new InvalidTaskTypeException();
            };
        } catch (IndexOutOfBoundsException e) {
            throw new CorruptDataException(e.getMessage());
        }
    }

    public TaskList loadTaskList() {
        try {
            ArrayList<Task> taskList = new ArrayList<>();
            Scanner scanner = new Scanner(dataFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                taskList.add(loadTaskEntry(line));
            }
            return new TaskList(taskList);
        } catch (FileNotFoundException e) {
            System.out.println("The data file is missing. Please relaunch the program.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new TaskList();
    }

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

    public void deleteLineFromFile(int index) throws IOException {
        Path filePath = Paths.get(path);
        List<String> lines = new ArrayList<>(Files.readAllLines(filePath));
        lines.remove(index - 1);

        Files.write(filePath, lines);
    }
    public static void main(String[] args) {
        Storage storage = new Storage();
        String data = "test test";
        storage.saveData(data);
    }
}
