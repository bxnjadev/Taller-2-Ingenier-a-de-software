package cl.ucn.ingsoftware.taller2.taller2.adapter;

import cl.ucn.ingsoftware.taller2.taller2.model.ObjectToken;
import com.google.gson.*;

import java.lang.reflect.Type;

public class TokenAdapter implements JsonDeserializer<ObjectToken> {

    /**
     * Deserialize a Json Element in a ObjectToken Object
     * @param jsonElement the Json Element serialized
     * @param type the gson type
     * @param jsonDeserializationContext the serialization context from gson
     * @return A new service object
     * @throws JsonParseException throw when any field not exists
     */

    @Override
    public ObjectToken deserialize(JsonElement jsonElement,
                                   Type type,
                                   JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) jsonElement;

        return new ObjectToken(jsonObject.get("access_token").getAsString());
    }
}
