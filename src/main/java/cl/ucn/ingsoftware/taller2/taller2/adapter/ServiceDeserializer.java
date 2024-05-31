package cl.ucn.ingsoftware.taller2.taller2.adapter;

import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ServiceDeserializer implements JsonDeserializer<Service> {

    @Override
    public Service deserialize(JsonElement jsonElement,
                               Type type,
                               JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = (JsonObject) jsonElement;

        return new Service(
                jsonObject.get("name").getAsString(),
                jsonObject.get("price").getAsInt()
        );
    }

}
