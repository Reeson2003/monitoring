package ru.reeson2003.model.domain;

/**
 * Date: 20.05.2017.
 * Time: 13:40.
 *
 * @author Pavel Gavrilov.
 */
public class ParameterImpl implements Parameter {
    private String name;
    private String value;
    private Integer requestPeriod;
    private boolean requestStatus;

    public ParameterImpl(String name, String value, Integer requestPeriod, boolean requestStatus) {
        this.name = name;
        this.value = value;
        this.requestPeriod = requestPeriod;
        this.requestStatus = requestStatus;
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Integer getRequestPeriod() {
        return requestPeriod;
    }

    @Override
    public void setRequestPeriod(Integer requestPeriod) {
        this.requestPeriod = requestPeriod;
    }

    @Override
    public boolean getRequestStatus() {
        return requestStatus;
    }

    @Override
    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }
}
