import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class JsonCreator {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Scanner json = new Scanner(System.in);

        System.out.println("Which operation would you like to perform?\n 1. Create or update \n 2. Open file");

        if (scan.nextInt() == 1) {
            System.out.println("Enter the name of the file you want to modify or create: ");

            try (BufferedWriter file = new BufferedWriter(new FileWriter("/Users/yaz/Documents/Jsons/" + json.nextLine(), true))) {

                HashMap<String, String> objects = new HashMap<>();
                System.out.println("Enter the name and the role: ");
                objects.put(scan.nextLine(), scan.nextLine());

                JSONObject obj = new JSONObject(objects);
                file.write(obj.toJSONString());
                System.out.println("Successfully Copied JSON Object to File...");
                System.out.println("\nJSON Object: " + obj);
            }
        } else if (scan.nextInt() == 2) {
            try {
                Scanner input = new Scanner(System.in);

                System.out.println("Enter the file name: ");

                File file = new File("/Users/yaz/Documents/Jsons/" + input.nextLine());

                input = new Scanner(file);

                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    System.out.println(line);
                    }
                        input.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

        }

    }


}
