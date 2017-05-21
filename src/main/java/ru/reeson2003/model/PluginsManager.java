package ru.reeson2003.model;

import java.util.List;

/**
 * Date: 21.05.2017.
 * Time: 16:02.
 *
 * @author Pavel Gavrilov.
 */
public interface PluginsManager {
    List<String> getPluginsNames();
    void addPlugin(String name, String jarPath);
    void removePlugin(String name);
    void selectPlugin(String name);
}
