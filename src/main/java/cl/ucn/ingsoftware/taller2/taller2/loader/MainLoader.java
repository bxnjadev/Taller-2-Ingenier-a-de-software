package cl.ucn.ingsoftware.taller2.taller2.loader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The kernel loader, this loader load all components
 */

public class MainLoader implements Loader {

    private final Set<Loader> loaders;

    public MainLoader() {
        loaders = new HashSet<>();
    }

    /**
     * Add a new component for load
     * @param loader the loader
     */

    public void newLoader(Loader loader) {
        loaders.add(loader);
    }

    /**
     * Add many new componets for load
     * @param loadersCollection a set components
     */

    public void addAll(Loader... loadersCollection) {
        loaders.addAll(Arrays.asList(loadersCollection));
    }

    /**
     * Load all components
     */

    @Override
    public void load() {
        for (Loader loader : loaders) {
            loader.load();
        }

    }
}
