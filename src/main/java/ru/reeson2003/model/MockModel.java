package ru.reeson2003.model;

import ru.reeson2003.model.domain.Parameter;
import ru.reeson2003.model.domain.ParameterImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Date: 20.05.2017.
 * Time: 14:37.
 *
 * @author Pavel Gavrilov.
 */
public class MockModel implements Model, Runnable {
    private List<Parameter> parameters;

    public MockModel() {
        parameters = new ArrayList<>();
        parameters.add(new ParameterImpl("Колпино", "23", 6, true));
        parameters.add(new ParameterImpl("New York", "15", 3, false));
        parameters.add(new ParameterImpl("Казань", "28", 10, true));
        parameters.add(new ParameterImpl("Москва", "23", 6, false));
        parameters.add(new ParameterImpl("Mexico", "31", 20, false));
        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public String getModuleName() {
        return "Мониторинг погоды";
    }

    @Override
    public List<Parameter> getParameters() {
        return parameters;
    }

    @Override
    public Parameter getParameter(String name) {
        for (Parameter p :
                parameters) {
            if (p.getName().equals(name))
                return p;
        }
        return null;
    }

    @Override
    public void run() {
        Random random = new Random(new Date().getTime());
        while (true) {
            for (Parameter p :
                    parameters) {
                if (p.getRequestStatus())
                    p.setValue(String.valueOf((random.nextInt(100) - 50)));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
