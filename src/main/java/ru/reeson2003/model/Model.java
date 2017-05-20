package ru.reeson2003.model;

import ru.reeson2003.model.domain.Parameter;

import java.util.List;

/**
 * Date: 20.05.2017.
 * Time: 14:08.
 *
 * @author Pavel Gavrilov.
 */
public interface Model {
    String getModuleName();
    List<Parameter> getParameters();
    Parameter getParameter(String name);
}
