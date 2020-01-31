import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class JsonHandler {

    Scanner scan = new Scanner(System.in);
    Scanner json = new Scanner(System.in);

    public void createJson() throws IOException {
        System.out.println("Enter the name of the file you want to modify or create: ");

        try (BufferedWriter file = new BufferedWriter(new FileWriter("/Users/yaz/Documents/Jsons/" + json.nextLine() + ".json", true))) {

            HashMap<String, String> objects = new HashMap<>();
            System.out.println("Enter the name and the role: ");
            objects.put(scan.nextLine(), scan.nextLine());

            JSONObject obj = new JSONObject(objects);
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        }
    }

    public void openJson() {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the file name: ");

            File file = new File("/Users/yaz/Documents/Jsons/" + input.nextLine() + ".json");

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

    public void updateJsonObject() throws IOException {
        System.out.println("Enter the name of the file: ");
        Path file = Paths.get("/Users/yaz/Documents/Jsons/" + json.nextLine() + ".json");
        String input = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
        System.out.println(file);
        JSONObject obj = (JSONObject) JSONValue.parse(input);
        System.out.println("Enter the name of the element that should be removed: ");
        obj.remove("" + scan.nextLine());
        System.out.println("Enter new name: ");
        obj.put(scan.nextLine(), scan.nextLine());
        System.out.println(obj);
        String output = JSONValue.toJSONString(obj);
        Files.write(file, output.getBytes(StandardCharsets.UTF_8));
    }


    public void deleteJsonObject() throws IOException {
        System.out.println("Enter the name of the file: ");
        Path file = Paths.get("/Users/yaz/Documents/Jsons/" + json.nextLine() + ".json");
        String input = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
        JSONObject obj = (JSONObject) JSONValue.parse(input);


        System.out.println("Enter the name of the element that should be removed: ");
        obj.remove("" + scan.nextLine());
        System.out.println(obj);
        String output = JSONValue.toJSONString(obj);
        Files.write(file, output.getBytes(StandardCharsets.UTF_8));
    }

}