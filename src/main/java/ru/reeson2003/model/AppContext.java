package ru.reeson2003.model;

import ru.reeson2003.Model;

/**
 * Date: 20.05.2017.
 * Time: 14:10.
 *
 * @author Pavel Gavrilov.
 */
public class AppContext {
    private static AppContext ourInstance = new AppContext();

    private Model model;
    private PluginsManager pluginsManager;
    private ModelResolver modelResolver;
    {
        pluginsManager = new PluginsManagerImpl();
    }

    public static AppContext getInstance() {
        return ourInstance;
    }

    private AppContext() {
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public PluginsManager getPluginsManager() {
        return pluginsManager;
    }

    public void setPluginsManager(PluginsManager pluginsManager) {
        this.pluginsManager = pluginsManager;
    }

    public ModelResolver getModelResolver() {
        if (modelResolver == null)
            modelResolver = new JarModelResolver();
        return modelResolver;
    }

    public void setModelResolver(ModelResolver modelResolver) {
        this.modelResolver = modelResolver;
    }
}
