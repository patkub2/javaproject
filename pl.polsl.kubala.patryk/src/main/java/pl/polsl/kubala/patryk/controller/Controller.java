package pl.polsl.kubala.patryk.controller;
import pl.polsl.kubala.patryk.model.*;
import pl.polsl.kubala.patryk.view.*;
/**
 * Class responsible for accurately calling {@link pl.polsl.kubala.patryk.model.Model} and {@link pl.polsl.kubala.patryk.view.Window} methods
 *
 * @deprecated
 * @author Mateusz Grabowski
 * @version 3.0
 */
public class Controller {

    /** A {@link pl.polsl.kubala.patryk.model.Model} object used to call its methods */
    private Model model;
    /** A {@link pl.polsl.kubala.patryk.view.Window} object used to call its methods */
    //private Window window;
    
    private View view;


    /**
     * A {@link Controller} initializer. It takes command line arguments and passes it to controller method.
     * It also initializes the {@link pl.polsl.kubala.patryk.view.Window} and {@link pl.polsl.kubala.patryk.model.Model} objects present inside of this class
     *
     * @param args command line parameters passed from main
     */
    Controller(String[] args)
    {
        this.model = new Model();
        this.view = new View();
        //this.window= new Window();
        //window.startingWindow();
        this.controller(args);
    }

    /**
     * Function that operates the whole program, deciding when to call which method from {@link pl.polsl.kubala.patryk.view.Window} or {@link pl.polsl.kubala.patryk.model.Model}
     *
     * @param args command line arguments passed from main through the {@link Controller} initializer
     */
    private void controller(String[] args)
    {
// catch from domand line -s key and -d for decrypt
        try
        {
            model.takeFromCommandLine(args);
        }
        catch(InvalidCLInputException e)
        {
            
            view.printErrorMsg(e);
            model.setFromCL(false);
        }

        while (true) {
            //model.setNoError(true);
            //System.out.print(model.getFromCL());
            if (model.getFromCL()) { //check if data comes from CL
                System.out.print("got seed from CL\n");
              //  window.cleanText();
            }
            //System.out.print(model.getFromCL());
            if (!model.getFromCL()) {
                System.out.print("gotn't seed from CL\n");
                System.exit(0);
              //  window.buttonClicked();
              //  window.cleanText();
                model.setSeed(view.getKeySeed());
                view.showMenu();
                model.setChoice(view.getChoice());
            }
            model.setKey(); //set key
            
            System.out.print("key: "+model.getKey()+"\n");
            model.setChoose(model.getChoice());
            System.out.print("model choice: "+model.getChoose()+"\n");
            switch (model.getChoose()) {
                case ENCRYPT ->  {
                    if (!model.getFromCL()) {
                        model.setText(view.toEncode());
                        //model.setText(view.getText());
                    }
                    try {
                        view.printString(model.encryptText());
                       // window.setText(model.encryptText());
                    } catch (IncorrectEncryptOrDecryptTextException e) {
                       // window.notifyWaiter();
                      //  window.printErrorMsg(e);
                      //  window.setText(e.getMessage());
                        model.setFromCL(false);
                        model.setNoError(false);
                    }
                }
                case DECRYPT ->  {
                    System.out.print("decrypt\n");
                    System.out.print("Got from CL?: "+model.getFromCL()+"\n");
                    if (!model.getFromCL()) {
                        model.setText(view.toDecode());
                       // model.setText(window.getText());
                       System.out.print("yolo\n");
                    }
                    try {
                        System.out.print("HERE---------------------\n");
                        view.printString(model.decryptText());
                      model.setText(model.decryptText());
                    } catch (IncorrectEncryptOrDecryptTextException e) {
                       // window.notifyWaiter();
                       // window.printErrorMsg(e);
                      //  window.setText(e.getMessage());
                        model.setFromCL(false);
                        model.setNoError(false);
                    }

                }
                case BOTH ->  {
                    if (!model.getFromCL()) {
                        model.setText(view.toEncode());
                       // model.setText(window.getText());
                    }
                    try {
                        model.setText(model.encryptText());
                       // model.setText(model.encryptText());
                    } catch (IncorrectEncryptOrDecryptTextException e) {
                      //  window.notifyWaiter();
                      //  window.printErrorMsg(e);
                      //  window.setText(e.getMessage());
                        model.setFromCL(false);
                        model.setNoError(false);
                    }
                    view.printString(model.getText());
                   // window.setText(model.getText());
                    try {
                        view.printString(model.decryptText());
                       // window.setText(model.decryptText());
                    } catch (IncorrectEncryptOrDecryptTextException e) {
                      //  window.notifyWaiter();
                      //  window.printErrorMsg(e);
                      //  window.setText(e.getMessage());
                        model.setFromCL(false);
                        model.setNoError(false);
                    }
                }
            }
           // window.notifyWaiter();
            model.destroyKey();
            model.setFromCL(false);
        }
    }
}
