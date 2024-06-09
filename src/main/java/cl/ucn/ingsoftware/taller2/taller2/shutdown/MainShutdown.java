package cl.ucn.ingsoftware.taller2.taller2.shutdown;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainShutdown {

    private final Set<Shutdown> shutdowns;

    public MainShutdown() {
        shutdowns = new HashSet<>();
    }

    public void add(Shutdown shutdown) {
        shutdowns.add(shutdown);
    }

    public void shutdown() {
        for (Shutdown shutdown : shutdowns) {
            shutdown.shutdown();
        }
    }

}
