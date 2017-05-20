package ru.reeson2003.model.main;

import ru.reeson2003.model.Model;

/**
 * Date: 20.05.2017.
 * Time: 14:10.
 *
 * @author Pavel Gavrilov.
 */
public class AppContext {
    private Model model;
    private static AppContext ourInstance = new AppContext();
    private Modelresolver modelresolver;

    {
        modelresolver = new Modelresolver();
        model = modelresolver.getModel();
    }

    public static AppContext getInstance() {
        return ourInstance;
    }

    private AppContext() {
    }

    public Model getModel() {
        return model;
    }
}
