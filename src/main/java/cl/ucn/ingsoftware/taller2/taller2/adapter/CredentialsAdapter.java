package cl.ucn.ingsoftware.taller2.taller2.adapter;

import cl.ucn.ingsoftware.taller2.taller2.authenticate.Credentials;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class CredentialsAdapter implements JsonSerializer<Credentials> {
    @Override
    public JsonElement serialize(Credentials credentials, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", credentials.getIdentifier());
        jsonObject.addProperty("password", credentials.getPassword());

        return jsonObject;
    }
}
