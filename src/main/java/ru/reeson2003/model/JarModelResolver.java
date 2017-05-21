package ru.reeson2003.model;

import ru.reeson2003.Model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Date: 21.05.2017.
 * Time: 14:30.
 *
 * @author Pavel Gavrilov.
 */
public class JarModelResolver implements ModelResolver {
    String jarPath;

    public JarModelResolver(String jarPath) {
        this.jarPath = jarPath;
    }

    public JarModelResolver() {
    }

    @Override
    public Model getModel() {
        return loadModel();
    }

    private Model loadModel() {
        if (jarPath == null)
            return null;
        File jarFile = new File(jarPath);
        Properties properties = null;
        try {
            properties = getPluginPropserties(jarFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String modelClassName = getModelClassName(properties);
        if (modelClassName == null)
            return null;
        String[] classNames = getClassNames(properties);
        if (classNames == null)
            return null;
        Model model = null;
        try {
        URL jarURL = jarFile.toURI().toURL();
        ClassLoader currentClassLoader  = Thread.currentThread().getContextClassLoader();
        URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL},currentClassLoader);
        Thread.currentThread().setContextClassLoader(classLoader);
            for (String s: classNames  ) {
                Class<?> c = classLoader.loadClass(s);
                if(s.equals(modelClassName))
                    model = (Model) c.newInstance();
            }
        } catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }

    private Properties getPluginPropserties(File file) throws IOException {
        Properties result = null;
        JarFile jar = new JarFile(file);
        Enumeration entries = jar.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = (JarEntry) entries.nextElement();
            if (entry.getName().equals("description.properties")) {
                InputStream is = null;
                try {
                    is = jar.getInputStream(entry);
                    result = new Properties();
                    result.load(is);
                } finally {
                    if (is != null)
                        is.close();
                }
            }
        }
        return result;
    }

    private String[] getClassNames(Properties properties) {
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        if (entries.size()==0)
            return null;
        String[] result = new String[entries.size()];
        int i = 0;
        for (Map.Entry<Object, Object> pair: entries) {
            result[i++] = (String) pair.getValue();
        }
        return result;
    }

    private String getModelClassName(Properties properties) {
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> pair: entries) {
            if(pair.getKey().equals("Model.class"));
            return (String) pair.getValue();
        }
        return null;
    }

    public String getJarPath() {
        return jarPath;
    }

    @Override
    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }
}
