
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
        System.out.println("Общая информация: " + randomCard(gender) + " , " + randomCard(age) + " , " + randomCard(sex));


        JSONArray phobiesArray = (JSONArray) jsonData.get("PHOBIES");
        System.out.println("Фобия: " + randomCard(phobiesArray));
        JSONArray characterArray = (JSONArray) jsonData.get("CHARACTER");
        System.out.println("Черта характера: " + randomCard(characterArray));
        JSONArray hobbiesArray = (JSONArray) jsonData.get("HOBBIES");
        System.out.println("Хобби: " + randomCard(hobbiesArray));
        JSONArray skillsArray = (JSONArray) jsonData.get("SKILLS");
        System.out.println("Скилл: " + randomCard(skillsArray));
        JSONArray lifeArray = (JSONArray) jsonData.get("LIFE");
        System.out.println("Здоровье: " + randomCard(lifeArray));
        JSONArray invArray = (JSONArray) jsonData.get("INV");
        System.out.println("Багаж: " + randomCard(invArray));
        JSONArray profArray = (JSONArray) jsonData.get("PROF");
        System.out.println("Профессия: " + randomCard(profArray));
        JSONArray actionCardsArray = (JSONArray) jsonData.get("ACTIONCARDS");
        System.out.println("Действие: " + randomCard(actionCardsArray));
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
}
