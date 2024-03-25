import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    byte[] memory = new byte[256];

    static ArrayList<HashMap<String, Integer>> programInstructions;
    static int AC = 0;
    static int PC = 0;
    static int F = 0;
    public static void main(String[] args) {
        programInstructions = loadProgram(args[0]);


        while (true) {

        }

    }

    static ArrayList<HashMap<String, Integer>> loadProgram(String filename) {

        ArrayList<HashMap<String, Integer>> instructions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.trim().startsWith("%") || line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                String operand = parts[1];
                int parameter = (parts.length > 2) ? Integer.parseInt(parts[2]) : 0;

                HashMap<String, Integer> instruction = new HashMap<>();
                instruction.put(operand, parameter);
                instructions.add(instruction);
            }
        } catch (IOException e) {
            System.err.println("Error reading program file: " + e.getMessage());
        }

        return instructions;
    }
}
