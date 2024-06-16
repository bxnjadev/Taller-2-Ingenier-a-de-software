package cl.ucn.ingsoftware.taller2.taller2.adapter;

import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ServiceDeserializer implements JsonDeserializer<Service> {

    /**
     * Deserialize a Json Element in a Service Object
     * @param jsonElement the Json Element serialized
     * @param type the gson type
     * @param jsonDeserializationContext the serialization context from gson
     * @return A new service object
     * @throws JsonParseException throw when any field not exists
     */

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
