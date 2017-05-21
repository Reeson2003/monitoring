package ru.reeson2003.model;

import ru.reeson2003.Model;

/**
 * Date: 21.05.2017.
 * Time: 12:10.
 *
 * @author Pavel Gavrilov.
 */
public interface ModelResolver {
    Model getModel();
    void setJarPath(String jarPath);
}
