/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Aditya
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField tbcv;
    @FXML
    private Button btn;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private ImageView iv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btAction(ActionEvent event) throws FileNotFoundException {
        MSQ m1 = new MSQ();
        String name = tbcv.getText();
        String a[] = m1.getI(name);
        l1.setText("Id : "+a[0]);
        l2.setText("Path : "+a[1]);
        l3.setText("Entry : "+a[2]);
        //l4.setText("Result : "+a[3]);
        Image i1;
        try {
            i1 = new Image(new FileInputStream("F:\\EclipPref\\FirstFProj\\lib\\images\\"+name));
            iv.setImage(i1);
        } catch (FileNotFoundException ex) {
            l1.setText("File could not be found : "+name);
            i1 = new Image(new FileInputStream("F:\\fnf.png"));
            iv.setImage(i1);
        }
    }
}
