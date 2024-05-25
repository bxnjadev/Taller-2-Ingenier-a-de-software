package cl.ucn.ingsoftware.taller2.taller2.loader;

import java.util.HashSet;
import java.util.Set;

public class MainLoader implements Loader {

    private final Set<Loader> loaders;

    public MainLoader() {
        loaders = new HashSet<>();
    }

    public void newLoader(Loader loader) {
        loaders.add(loader);
    }

    @Override
    public void load() {
        for (Loader loader : loaders) {
            loader.load();
        }

    }
}
