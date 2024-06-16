package cl.ucn.ingsoftware.taller2.taller2.adapter;

import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import cl.ucn.ingsoftware.taller2.taller2.model.Payment;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class PaymentAdapter implements JsonSerializer<Payment> {

    private final JsonSerializer<CreditCard> creditCardJsonSerializer;

    public PaymentAdapter(JsonSerializer<CreditCard> creditCardJsonSerializer) {
        this.creditCardJsonSerializer = creditCardJsonSerializer;
    }

    /**
     * Adapter for serialize a credential object
     * @param payment object
     * @param type the gson type
     * @param jsonSerializationContext the serialization context from gson
     * @return A Json element that contain the object serialized
     */

    @Override
    public JsonElement serialize(Payment payment,
                                 Type type,
                                 JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = (JsonObject) creditCardJsonSerializer.serialize(
                payment.getCreditCard(),
                type,
                jsonSerializationContext
        );

        jsonObject.addProperty("descripcion", payment.getDescription());
        jsonObject.addProperty("monto", payment.getAmount());

        return jsonObject;
    }
}
