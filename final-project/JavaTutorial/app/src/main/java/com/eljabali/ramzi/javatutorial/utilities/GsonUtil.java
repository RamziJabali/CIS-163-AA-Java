package com.eljabali.ramzi.javatutorial.utilities;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class GsonUtil {

    private GsonUtil() {
    }

    public static String toJsonString(Object object) {
        Gson gson = new GsonBuilder().create();
        final String json = gson.toJson(object);
        return json;
    }

    public static <T extends Object> List<T> getModelsFromJsonArray(JSONArray args,
                                                                    Class<T> clazz) {
        List<T> parsedModels = new ArrayList<>();
        try {
            for (int i = 0; i < args.length(); i++) {
                JSONObject jsonObject = args.getJSONObject(i);
                T model = getModelFromJson(jsonObject, clazz);
                if (model != null) {
                    parsedModels.add(model);
                }
            }
        } catch (Exception e) {
        }
        return parsedModels;
    }

    public static <T extends Object> T getModelFromJson(JsonObject jsonObject, Class<T> clazz) {
        final Gson gson = new GsonBuilder().create();
        final String jsonText = jsonObject.toString();
        final JsonObject gsonJson = new JsonParser().parse(jsonText).getAsJsonObject();
        return gson.fromJson(gsonJson, clazz);
    }

    public static <T extends Object> T getModelFromJson(JSONObject jsonObject, Class<T> clazz) {
        final Gson gson = new GsonBuilder().create();
        final String jsonText = jsonObject.toString();
        final JsonObject gsonJson = new JsonParser().parse(jsonText).getAsJsonObject();
        return gson.fromJson(gsonJson, clazz);
    }

    public static <T extends Object> T getModelFromJsonString(String jsonString,
                                                              Class<T> clazz) {
        final Gson gson = new GsonBuilder().create();
        final JsonObject gsonJson = new JsonParser().parse(jsonString).getAsJsonObject();
        return gson.fromJson(gsonJson, clazz);
    }

    public static <T> List<T> getModelsFromJsonString(JsonElement json, T type) {
        ArrayList<T> newArray = new ArrayList<>();
        Gson gson = new Gson();

        JsonArray array = json.getAsJsonArray();
        Iterator<JsonElement> iterator = array.iterator();

        while (iterator.hasNext()) {
            JsonElement json2 = iterator.next();
            T object = (T) gson.fromJson(json2, (Class<?>) type);
            newArray.add(object);
        }

        return newArray;
    }

    public static <T> List<T> getModelsFromJsonString(String jsonString, Class<T> clazz) {
        try {
            Gson gson = new Gson();
            List<T> listObjects = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                listObjects.add(gson.fromJson(jsonObject.toString(), clazz));
            }
            return listObjects;
        } catch (Exception e) {
        }
        return null;
    }

    public static <T extends Object> T getModelClone(T model, Class<T> clazz) {
        final Gson gson = new GsonBuilder().create();
        final JsonObject gsonJson = new JsonParser().parse(toJsonString(model)).getAsJsonObject();
        return gson.fromJson(gsonJson, clazz);
    }

}