package bar;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import bar.bar.Cocktail;
import bar.bar.DrinkType;
import bar.bar.GlassType;
import bar.bar.Ingredient;
import bar.dto.DTO;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import bar.exceptions.CocktailsGetException;


public class RestClient {
    private final int ingredientsMaxCount = 15;


    public DTO<DrinkType> getAllDrinkTypes() {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list";
        DTO<DrinkType> obj = null;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format(url)))
                .GET()
                .build();
        try {
            var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = null;
            List<DrinkType> drinkTypes = new ArrayList<>();
            jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            obj = new Gson().fromJson(response.body(), DTO.class);
            if (obj.drinks != null) {
                JsonArray arr = jsonObject.getAsJsonArray("drinks");
                for (int i = 0; i < arr.size(); i++) {
                    DrinkType dt = new DrinkType(arr.get(i).getAsJsonObject().get("strCategory").getAsString());
                    drinkTypes.add(dt);
                }
                obj.setList(drinkTypes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * List of all glass types.
     *
     * @return
     */
    public DTO<GlassType> getAllGlassTypes() {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/list.php?g=list";
        DTO<GlassType> obj = null;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format(url)))
                .GET()
                .build();
        try {
            var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = null;
            List<GlassType> glassTypes = new ArrayList<>();
            jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            obj = new Gson().fromJson(response.body(), DTO.class);
            if (obj.drinks != null) {
                JsonArray arr = jsonObject.getAsJsonArray("drinks");
                for (int i = 0; i < arr.size(); i++) {
                    GlassType gt = new GlassType(arr.get(i).getAsJsonObject().get("strGlass").getAsString());
                    glassTypes.add(gt);
                }
                obj.setList(glassTypes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * List of all ingredients.
     *
     * @return
     */
    public DTO<Ingredient> getAllIngredinets() {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/list.php?i=list";
        DTO<Ingredient> obj = null;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format(url)))
                .GET()
                .build();
        try {
            var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = null;
            List<Ingredient> ingredientList = new ArrayList<>();
            jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            obj = new Gson().fromJson(response.body(), DTO.class);
            if (obj.drinks != null) {
                JsonArray arr = jsonObject.getAsJsonArray("drinks");
                for (int i = 0; i < arr.size(); i++) {
                    Ingredient ing = new Ingredient(arr.get(i).getAsJsonObject().get("strIngredient1").getAsString());
                    ingredientList.add(ing);
                }
                obj.setList(ingredientList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * List of all cocktails by first letter.
     *
     * @param letter
     * @return
     */
    public DTO<Cocktail> getAllCocktailsByFirstLetter(String letter) {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=" + letter;
        DTO<Cocktail> cocktailDTO = new DTO<Cocktail>();
        List<Cocktail> cocktailList = new ArrayList<>();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format(url)))
                .GET()
                .build();
        try {

            cocktailDTO = createCocktailsList(httpRequest, client);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cocktailDTO;
    }

    /**
     * Search cocktail by name.
     *
     * @param name
     * @return
     */
    public DTO<Cocktail> getAllCocktailsByName(String name) {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + name;
        DTO<Cocktail> cocktailDTO = new DTO<Cocktail>();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format(url)))
                .GET()
                .build();
        try {
            cocktailDTO = createCocktailsList(httpRequest, client);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cocktailDTO;
    }

    public DTO<String> getDataListByFilter(String filter, String value) {
//        filter = "c=";
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?" + filter + value;
        DTO<String> obj = null;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.format(url)))
                .GET()
                .build();
        try {
            var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = null;
            jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            List<String> listByFilter = new ArrayList<>();
            obj = new Gson().fromJson(response.body(), DTO.class);
            if (obj.drinks != null) {
                JsonArray arr = jsonObject.getAsJsonArray("drinks");
                for (int i = 0; i < arr.size(); i++) {
                    String dt = arr.get(i).getAsJsonObject().get("strDrink").getAsString();
                    listByFilter.add(dt);
                }
                obj.setList(listByFilter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    /**
     * Get all possible cocktails from API
     *
     * @return
     */
    public List<Cocktail> getAllCocktailsFromDB() {
//        String possibleChars = "0123456789abcdefghijklmnopqrstuvwxyz";
        String possibleChars = "12345679abcdefghijklmnopqrstvwyz";
//        Map<String, List<Cocktail>> map = new HashMap<>();
        List<Cocktail> cocktailList = new ArrayList<>();
        try {
            for (int i = 0; i < possibleChars.length(); i++) {
                String letter = Character.toString(possibleChars.charAt(i));
                List<Cocktail> cocktails = getAllCocktailsByFirstLetter(letter).getList();

                if (cocktails != null) {
//                    map.put(letter, cocktails);
                    for (Cocktail c : cocktails) {
                        cocktailList.add(c);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cocktailList;
    }


    /**
     * Generates cocktail list and returns as DTO<Cocktail> object.
     *
     * @param httpRequest
     * @param client
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public DTO<Cocktail> createCocktailsList(HttpRequest httpRequest, HttpClient client)
            throws IOException, InterruptedException {
        DTO<Cocktail> cocktailDTO = new DTO<Cocktail>();
        JsonObject jsonObject = null;
        var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
        DTO<Cocktail> obj = new Gson().fromJson(response.body(), DTO.class);
        if (obj.drinks != null) {
            JsonArray arr = jsonObject.getAsJsonArray("drinks");
            List<Cocktail> cocktailList = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                Cocktail cocktail = new Cocktail();
                cocktail.setStrDrink(arr.get(i).getAsJsonObject().get("strDrink").getAsString());
                cocktail.setStrCategory(arr.get(i).getAsJsonObject().get("strCategory").getAsString());
                cocktail.setStrGlass(arr.get(i).getAsJsonObject().get("strGlass").getAsString());
                cocktail.setIdDrink(arr.get(i).getAsJsonObject().get("idDrink").getAsString());
                if (arr.get(i).getAsJsonObject().get("strAlcoholic").getAsString().equals("Alcoholic")) {
                    cocktail.setAlcoholic(true);
                } else {
                    cocktail.setAlcoholic(false);
                }
                List<String> ingredientList = new ArrayList<>();
                for (int j = 1; j <= ingredientsMaxCount; j++) {
                    if (!arr.get(i).getAsJsonObject().get("strIngredient" + j).isJsonNull()) {
                        String strIngredient = arr.get(i).getAsJsonObject().get("strIngredient" + j).getAsString();
                        ingredientList.add(strIngredient);
                    }
                }
                cocktail.setIngredientsList(ingredientList);
                cocktailList.add(cocktail);
            }
            cocktailDTO.setList(cocktailList);
        } else {
            throw new CocktailsGetException("Get request failed. No objects.");
        }
        return cocktailDTO;
    }


}
