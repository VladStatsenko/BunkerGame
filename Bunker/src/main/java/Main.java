import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    private static String dataFile = "src/main/resources/mpa.json";

    public static void main(String[] args) {
        parseJson(dataFile);
        changeLife();
    }

    private static Object randomCard(JSONArray array) {
        int n = (int) Math.floor(Math.random() * array.size());
        return array.get(n);
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public static void parseJson(String dataFile) {
        JSONParser parser = new JSONParser();
        JSONObject jsonData = null;
        try {
            jsonData = (JSONObject) parser.parse(getJsonFile());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject playerInfoArray = (JSONObject) jsonData.get("PLAYERINFO");

        JSONArray gender = (JSONArray) playerInfoArray.get("GENDER");
        JSONArray age = (JSONArray) playerInfoArray.get("AGE");
        JSONArray sex = (JSONArray) playerInfoArray.get("SEX");
        JSONArray phobiesArray = (JSONArray) jsonData.get("PHOBIES");
        JSONArray characterArray = (JSONArray) jsonData.get("CHARACTER");
        JSONArray hobbiesArray = (JSONArray) jsonData.get("HOBBIES");
        JSONArray skillsArray = (JSONArray) jsonData.get("SKILLS");
        JSONArray lifeArray = (JSONArray) jsonData.get("LIFE");
        JSONArray invArray = (JSONArray) jsonData.get("INV");
        JSONArray profArray = (JSONArray) jsonData.get("PROF");
        JSONArray actionCardsArray = (JSONArray) jsonData.get("ACTIONCARDS");

        System.out.println("Общая информация: " + randomCard(gender) + " , " + randomCard(age));
        System.out.println("Фобия: " + randomCard(phobiesArray));
        System.out.println("Черта характера: " + randomCard(characterArray));
        System.out.println("Хобби: " + randomCard(hobbiesArray));
        System.out.println("Доп. Информация: " + randomCard(skillsArray));
        System.out.println("Здоровье: " + randomCard(lifeArray));
        System.out.println("Багаж: " + randomCard(invArray));
        System.out.println("Профессия: " + randomCard(profArray));
        System.out.println("Действие: " + randomCard(actionCardsArray));
        System.out.println("Действие: " + randomCard(actionCardsArray));

    }

    private static void changePhobies() {
        JSONParser parser = new JSONParser();
        JSONObject jsonData = null;
        try {
            jsonData = (JSONObject) parser.parse(getJsonFile());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray phobiesArray = (JSONArray) jsonData.get("PHOBIES");
        System.out.println("Новая Фобия: " + randomCard(phobiesArray));
    }

    private static void changeLife() {
        JSONParser parser = new JSONParser();
        JSONObject jsonData = null;
        try {
            jsonData = (JSONObject) parser.parse(getJsonFile());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray lifeArray = (JSONArray) jsonData.get("LIFE");
        System.out.println("Новое Здоровье: " + randomCard(lifeArray));
    }

    private static void changeProf() {
        JSONParser parser = new JSONParser();
        JSONObject jsonData = null;
        try {
            jsonData = (JSONObject) parser.parse(getJsonFile());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray profArray = (JSONArray) jsonData.get("PROF");
        System.out.println("Новая Профессия: " + randomCard(profArray));
    }
}
