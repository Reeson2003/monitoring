package ru.reeson2003.model.domain;

/**
 * Date: 20.05.2017.
 * Time: 18:28.
 *
 * @author Pavel Gavrilov.
 */
public interface Parameter {
    String getName();

    void setName(String name);

    String getValue();

    void setValue(String value);

    Integer getRequestPeriod();

    void setRequestPeriod(Integer requestPeriod);

    boolean getRequestStatus();

    void setRequestStatus(boolean requestStatus);
}
