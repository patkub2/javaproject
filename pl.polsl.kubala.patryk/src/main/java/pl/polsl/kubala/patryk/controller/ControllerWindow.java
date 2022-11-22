package pl.polsl.kubala.patryk.controller;

import pl.polsl.kubala.patryk.view.*;
import pl.polsl.kubala.patryk.model.*;

/**
 * Class responsible for exact calling of
 * {@link pl.polsl.kubala.patryk.model.Model} methods
 *
 * @author Patryk Kubala
 * @version 1.1
 */
public class ControllerWindow {

    /**
     * A {@link pl.polsl.kubala.patryk.model.View} object used to for calling view
     */
    private View view;
    /**
     * A {@link pl.polsl.kubala.patryk.model.Model} object used to for calling
     * methods
     */
    private Model model;
    /**
     * A {@link pl.polsl.kubala.patryk.model.Window} object used to for calling
     * methods
     */
    private Window window;

    /**
     * {@link Controller} It takes command line arguments and passes it to
     * controller method. {@link pl.polsl.kubala.patryk.model.Window}
     * Initializes the objects present inside of this class.
     * {@link pl.polsl.kubala.patryk.model.Model} It also initializes the
     * objects present inside of this class.
     *
     * @param args initial comand line parameters passed from main function
     */
    ControllerWindow(String[] args) {
        this.model = new Model();
        //this.view = new View();
        this.window = new Window();
        this.controller(args);
    }

    /**
     * Function controller operates the whole program, calling methods from
     * {@link pl.polsl.kubala.patryk.model.Model}
     *
     * @param args command line arguments passed from main through the
     * {@link Controller} initializer
     */
    private void controller(String[] args) {
        window.setVisible(true);
        try {
            model.takeFromCommandLine(args);
        } catch (IncorrectInputException e) {
            window.printErrorMsg(e);
            model.setFromCL(false);
        }

        while (true) {
            model.setNoError(true);
            if (model.getFromCL()) {
                window.setVieldsFromCmd(model.getSeed(), model.getText());
            }
            if (!model.getFromCL()) {
                window.buttonWaitForClicked();
                try {
                    model.setSeed(window.getKeySeed());
                } catch (NumberFormatException e) {
                    window.printErrorMsg(e);
                }
                model.setChoice(window.getChoice());
            }
            model.setKey();
            model.setchoiceEnum(model.getChoice());
            switch (model.getchoiceEnum()) {
                // DECODE ------------------------
                case DECODE -> {
                    if (!model.getFromCL()) {
                        model.setText(window.getText());
                    }

                    try {
                        window.printToTextOutput(model.decodeText());
                        model.setText(model.decodeText());
                    } catch (IncorrectTextException e) {
                        window.cleanFields();
                        window.notifyWaiter();
                        window.printErrorMsg(e);
                        model.setFromCL(false);
                        model.setNoError(false);
                    }

                }
                // ENCODE ------------------------
                case ENCODE -> {
                    if (!model.getFromCL()) {
                        model.setText(window.getText());
                    }
                    try {
                        window.printToTextOutput(model.encodeText());
                    } catch (IncorrectTextException e) {
                        window.cleanFields();
                        window.notifyWaiter();
                        window.printErrorMsg(e);
                        model.setFromCL(false);
                        model.setNoError(false);
                    }
                }
            }
            window.notifyWaiter();
            model.destroyKey();
            model.setFromCL(false);
        }
    }
}
