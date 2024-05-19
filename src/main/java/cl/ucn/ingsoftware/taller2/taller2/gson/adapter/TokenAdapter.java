package cl.ucn.ingsoftware.taller2.taller2.gson.adapter;

import cl.ucn.ingsoftware.taller2.taller2.model.ObjectToken;
import com.google.gson.*;

import java.lang.reflect.Type;

public class TokenAdapter implements JsonDeserializer<ObjectToken> {

    @Override
    public ObjectToken deserialize(JsonElement jsonElement,
                                   Type type,
                                   JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) jsonElement;

        return new ObjectToken(jsonObject.get("access_token").getAsString());
    }
}
