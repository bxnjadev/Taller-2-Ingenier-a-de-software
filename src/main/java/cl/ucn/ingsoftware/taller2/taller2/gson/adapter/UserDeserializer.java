package cl.ucn.ingsoftware.taller2.taller2.gson.adapter;

import cl.ucn.ingsoftware.taller2.taller2.model.RolType;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

public class UserDeserializer implements JsonDeserializer<User> {

    @Override
    public User deserialize(JsonElement jsonElement,
                            Type type,
                            JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = (JsonObject) jsonElement;


        return new User(
                jsonObject.get("username").getAsString(),
                jsonObject.get("age").getAsInt(),
                jsonObject.get("mail").getAsString(),
                jsonObject.get("password").getAsString(),
                RolType.valueOf(jsonObject.get("rolType").getAsString())
        );
    }
}
