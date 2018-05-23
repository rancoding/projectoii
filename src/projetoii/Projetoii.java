/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoii;

import dao.Funcionario;
import hibernate.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hibernate.Session;

/**
 *
 * @author Gustavo Vieira
 */
public class Projetoii extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        List<Funcionario> employeeList = session.createCriteria(Funcionario.class).list();
        for(Funcionario employee : employeeList)
        {
            System.out.println(employee.getNome());
        }
        
        session.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
