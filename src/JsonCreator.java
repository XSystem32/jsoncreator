import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class JsonCreator {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        JsonHandler jsonHandler = new JsonHandler();

        System.out.println("Which operation would you like to perform?\n 1. Create or update existing file \n 2. Open file \n 3. Delete element \n 4. Update an existing element");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                jsonHandler.createJson();
                break;
            case 2:
                jsonHandler.openJson();
                break;
            case 3:
                jsonHandler.deleteJsonObject();
                break;
            case 4:
                jsonHandler.updateJsonObject();
                break;
        }

    }

}
