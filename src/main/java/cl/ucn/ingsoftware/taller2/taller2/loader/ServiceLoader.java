package cl.ucn.ingsoftware.taller2.taller2.loader;

import cl.ucn.ingsoftware.taller2.taller2.adapter.ServiceDeserializer;
import cl.ucn.ingsoftware.taller2.taller2.adapter.UserDeserializer;
import cl.ucn.ingsoftware.taller2.taller2.model.Service;
import cl.ucn.ingsoftware.taller2.taller2.model.User;
import cl.ucn.ingsoftware.taller2.taller2.service.ServicesRegistry;
import cl.ucn.ingsoftware.taller2.taller2.util.Reader;
import cl.ucn.ingsoftware.taller2.taller2.util.ReaderUtil;
import cl.ucn.ingsoftware.taller2.taller2.util.StringReaderAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class represent a service loader
 */

public class ServiceLoader implements Loader {

    private final ServicesRegistry servicesRegistry;

    private static final String FILE_NAME = "services.json";
    private static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(Service.class, new ServiceDeserializer())
            .create();

    public ServiceLoader(ServicesRegistry servicesRegistry) {
        this.servicesRegistry = servicesRegistry;
    }

    /**
     * Load the component from service loader
     * this component load every serviced from a json file
     */

    @Override
    public void load() {

        Reader reader = new StringReaderAdapter(FILE_NAME);
        String body = ReaderUtil.readAllAsString(reader);

        Service[] services = GSON.fromJson(body, Service[].class);
        fill(services);
    }

    private void fill(Service[] services) {
        for (Service service : services) {
            System.out.println("Loading service: " + service.getName());
            servicesRegistry.add(service);
        }
    }

}
