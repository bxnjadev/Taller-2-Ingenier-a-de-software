package cl.ucn.ingsoftware.taller2.taller2.adapter;

import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class CreditCardAdapter implements JsonSerializer<CreditCard> {

    @Override
    public JsonElement serialize(CreditCard creditCard,
                                 Type type,
                                 JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("numero_tarjeta", creditCard.getNumber());
        jsonObject.addProperty("mes_vencimiento", creditCard.getMouth());
        jsonObject.addProperty("anio_vencimiento", creditCard.getYear());
        jsonObject.addProperty("codigo_seguridad", creditCard.getCode());

        return jsonObject;
    }
}
