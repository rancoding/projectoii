/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoii;

import dao.Funcionario;
import dao.Tipoproduto;
import hibernate.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Gustavo Vieira
 */
public class Projetoii extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {

       Parent root = FXMLLoader.load(getClass().getResource("FXMLAccountType.fxml"));
       //Parent root = FXMLLoader.load(getClass().getResource("design/administrator/menu/top/FXMLAdministratorTopMenu.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("design/administrator/warehouse/data/product/list/FXMLListProduct.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("design/administrator/warehouse/data/product/add/FXMLAddProduct.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("design/administrator/warehouse/data/category/list/FXMLListCategory.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        
        StandardServiceRegistryBuilder.destroy(HibernateUtil.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
        Platform.exit();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
