package ru.reeson2003.model;

import ru.reeson2003.Model;

import java.io.*;
import java.util.*;

/**
 * Date: 21.05.2017.
 * Time: 17:59.
 *
 * @author Pavel Gavrilov.
 */
public class PluginsManagerImpl implements PluginsManager {
    private Map<String, Model> models;
    private Properties properties;

    public PluginsManagerImpl() {
    }

    @Override
    public List<String> getPluginsNames() {
        if (properties == null)
            properties = getProperties();
        if (properties != null && models == null) {
            models = new HashMap<>();
            for (Map.Entry<Object, Object> pair : properties.entrySet()) {
                String jarPath = (String) pair.getValue();
                Model model = getModel(jarPath);
                if (model != null)
                    models.put((String) pair.getKey(), model);
            }
        }
        return new ArrayList<>(models.keySet());
    }

    @Override
    public void addPlugin(String name, String jarPath) {
        Model model = getModel(jarPath);
        if (model != null) {
            properties.put(name, jarPath);
            models.put(name, model);
//            updateProperties();
        }
    }

    @Override
    public void removePlugin(String name) {
        properties.remove(name);
        models.remove(name);
//        updateProperties();
    }

    @Override
    public void selectPlugin(String name) {
        Model model = models.get(name);
        AppContext.getInstance().setModel(model);
    }

    private Model getModel(String jarPath) {
        AppContext appContext = AppContext.getInstance();
        ModelResolver modelResolver = appContext.getModelResolver();
        modelResolver.setJarPath(jarPath);
        Model model = modelResolver.getModel();
        return model;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
//        try (InputStream is = new FileInputStream("META-INF/plugins.properties")) {
        try(InputStream is = this.getClass().getResourceAsStream("META-INF/plugins.properties")) {
            if (is != null && is.available() > 0) {
                properties.load(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

//    private void updateProperties() {
//        try (OutputStream os = new FileOutputStream("META-INF/plugins.properties")) {
//            properties.store(os, " Plugin properties");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
