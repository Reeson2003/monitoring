package ru.reeson2003.model.main;

import ru.reeson2003.model.MockModel;
import ru.reeson2003.model.Model;

/**
 * Date: 20.05.2017.
 * Time: 14:46.
 *
 * @author Pavel Gavrilov.
 */
public class Modelresolver {
    public Model getModel() {
        return new MockModel();
    }
}
