package Program;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class note {

    private static final String FILE_PATH = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nNote Management Menu:");
            System.out.println("1. View Notes");
            System.out.println("2. Add Note");
            System.out.println("3. Update Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewNotes();
                    break;
                case 2:
                    addNote();
                    break;
                case 3:
                    updateNote();
                    break;
                case 4:
                    deleteNote();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewNotes() {
        ArrayList<String> notes = readNotesFromFile();
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            System.out.println("\nAll Notes:");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
    }

    private static void addNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your note: ");
        String newNote = scanner.nextLine();
        writeNoteToFile(newNote);
        System.out.println("Note added successfully.");
    }

    private static void updateNote() {
        ArrayList<String> notes = readNotesFromFile();
        viewNotes();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the note number to update: ");
        int noteNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (noteNumber > 0 && noteNumber <= notes.size()) {
            System.out.print("Enter the updated note: ");
            String updatedNote = scanner.nextLine();
            notes.set(noteNumber - 1, updatedNote);
            writeAllNotesToFile(notes);
            System.out.println("Note updated successfully.");
        } else {
            System.out.println("Invalid note number.");
        }
    }

    private static void deleteNote() {
        ArrayList<String> notes = readNotesFromFile();
        viewNotes();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the note number to delete: ");
        int noteNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (noteNumber > 0 && noteNumber <= notes.size()) {
            notes.remove(noteNumber - 1);
            writeAllNotesToFile(notes);
            System.out.println("Note deleted successfully.");
        } else {
            System.out.println("Invalid note number.");
        }
    }

    private static ArrayList<String> readNotesFromFile() {
        ArrayList<String> notes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notes.add(line);
            }
        } catch (IOException e) {
            // Ignore if the file doesn't exist
        }
        return notes;
    }

    private static void writeNoteToFile(String note) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(note);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeAllNotesToFile(ArrayList<String> notes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String note : notes) {
                writer.write(note);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
