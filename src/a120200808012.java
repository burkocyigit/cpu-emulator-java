import java.io.*;
import java.util.ArrayList;

public class a120200808012 {

    static int[] memory = new int[256];

    static ArrayList<Instruction> programInstructions;
    static int AC = 0;
    static int PC = 0;
    static int F = 0;

    static boolean isFinished = false;
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No txt file provided!\nUsage: java a120200808012.java your_instructions.txt");
            System.exit(1);
        }

        String filename = args[0];

        programInstructions = loadProgram(filename);

        while (!isFinished) {
            executeInstruction(programInstructions.get(PC).getOperand(), programInstructions.get(PC).getParameter());
        }
    }

    static ArrayList<Instruction> loadProgram(String filename) {

        ArrayList<Instruction> instructions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.trim().startsWith("%") || line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                String operand = parts[1];
                int parameter = (parts.length > 2) ? Integer.parseInt(parts[2]) : 0;

                instructions.add( new Instruction(operand, parameter) );
            }
        } catch (IOException e) {
            System.err.println("Error reading program file: " + e.getMessage());
        }

        return instructions;
    }

    static void executeInstruction(String operand, int parameter) {
        switch (operand) {
            case "START": {
                System.out.println("********************\n\n");
                System.out.println("START: Start execution");
                PC++;
                break;
            }
            case "LOAD": {
                AC = parameter;
                PC++;
                break;
            }
            case "LOADM": {
                AC = memory[parameter];
                PC++;
                break;
            }
            case "STORE": {
                memory[parameter] = AC;
                PC++;
                break;
            }
            case "CMPM": {
                F = Integer.compare(AC, memory[parameter]);
                PC++;
                break;
            }
            case "CJMP": {
                PC = ( (F > 0) ? parameter : ++PC );
                break;
            }
            case "JMP": {
                PC = parameter;
                break;
            }
            case "ADD": {
                AC += parameter;
                PC++;
                break;
            }
            case "ADDM": {
                AC += memory[parameter];
                PC++;
                break;
            }

            case "SUB": {
                AC -= parameter;
                PC++;
                break;
            }
            case "SUBM": {
                AC -= memory[parameter];
                PC++;
                break;
            }
            case "MUL": {
                AC *= parameter;
                PC++;
                break;
            }
            case "MULM": {
                AC *= memory[parameter];
                PC++;
                break;
            }
            case "DISP": {
                System.out.println("------------------");
                System.out.println("| AC: " + AC + "        |");
                System.out.println("------------------");
                PC++;
                break;
            }
            case "HALT": {
                System.out.println("HALT: Execution halted.");
                System.out.println("\n\n********************");
                isFinished = true;
                break;
            }
            default:
                System.out.println("Instruction not found!");
                isFinished = true;
                break;
        }
    }


}
class Instruction {
    private final String operand;
    private final Integer parameter;

    public Instruction(String operand, Integer parameter) {
        this.operand = operand;
        this.parameter = parameter;
    }

    public String getOperand() {
        return operand;
    }

    public Integer getParameter() {
        return parameter;
    }
}
