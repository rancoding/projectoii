package projetoii.design.administrator.menu.top;

import dao.Armazem;
import dao.Loja;
import dao.Marca;
import hibernate.HibernateUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import org.hibernate.Session;
import projetoii.design.administrator.shop.menu.top.FXMLShopTopMenuController;
import projetoii.design.administrator.warehouse.menu.top.FXMLWarehouseTopMenuController;

public class FXMLAdministratorTopMenuController implements Initializable {

    @FXML private ComboBox workLocationComboBox;
    @FXML private BorderPane adminTopMenu;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        /* Initializes and opens the database session using hibernate */
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        /* Retrieves all database brands to an arraylist and initializes the table values if it is not empty */
        List<Armazem> warehouseList = session.createCriteria(Armazem.class).list();
        List<Loja> shopList = session.createCriteria(Loja.class).list();
        
        /* Adds both lists to the combobox */
        if(!(warehouseList.isEmpty()))
        {
            workLocationComboBox.getItems().addAll(warehouseList);
        }
        if(!(warehouseList.isEmpty()))
        {
            workLocationComboBox.getItems().addAll(shopList);
        }
        
        setComboBoxConverter();
        switchCenter();
        
        /* Closes the database connection */
        session.close();
    }    
    
    /* * Switches center when initializing * */
    private void switchCenter()
    {
        workLocationComboBox.getSelectionModel().select(0);
            
        if(!(workLocationComboBox.getSelectionModel().isEmpty()))
        {
            if(workLocationComboBox.getSelectionModel().getSelectedItem() instanceof Armazem)
            {
                switchCenter(FXMLWarehouseTopMenuController.class, "FXMLWarehouseTopMenu.fxml");
            }
            else if(workLocationComboBox.getSelectionModel().getSelectedItem() instanceof Loja)
            {
                switchCenter(FXMLShopTopMenuController.class, "FXMLShopTopMenu.fxml");
            }
        }
    }
    
    /* * Switches border pane center depending on selected combobox item * */
    @FXML private void switchCenter(ActionEvent event)
    {
        if(((ComboBox) event.getSource()).getSelectionModel().getSelectedItem() instanceof Armazem)
        {
            switchCenter(FXMLWarehouseTopMenuController.class, "FXMLWarehouseTopMenu.fxml");
        }
        else if(((ComboBox) event.getSource()).getSelectionModel().getSelectedItem() instanceof Loja)
        {
            switchCenter(FXMLShopTopMenuController.class, "FXMLShopTopMenu.fxml");
        }
    }
    
    /* * Sets the border pane center * */
    private void switchCenter(Class controller, String file)
    {
        try
        {
            Pane newPane = FXMLLoader.load(controller.getResource(file));
            adminTopMenu.setCenter(newPane);
        }
        catch(Exception e)
        {
        }
    }
    
    /* * Converts combobox to show working place names * */
    private void setComboBoxConverter()
    {
        workLocationComboBox.setConverter(new StringConverter() {
            @Override
            public String toString(Object object)
            {
                if(object instanceof Armazem)
                {
                    return ((Armazem) object).getNome();
                }
                else if(object instanceof Loja)
                {
                    return ((Loja) object).getNome();
                }
                
                return "";
            }

            @Override
            public Object fromString(String string) {
                return "";
            }
        });
    }
    
}
