import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorLaunch {
    public static void main(String[] args) {
        String input;

        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                System.out.print("Input:\n");
                input = reader.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println("Output:\n" + new StringParcer().parseString(input) + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
