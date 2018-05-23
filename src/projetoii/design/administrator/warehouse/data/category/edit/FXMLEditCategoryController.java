/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoii.design.administrator.warehouse.data.category.edit;

import dao.Tipoproduto;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import projetoii.design.administrator.warehouse.data.category.list.FXMLListCategoryController;

/**
 * FXML Controller class
 *
 * @author Gustavo Vieira
 */
public class FXMLEditCategoryController implements Initializable {

    @FXML private TextField categoryName;
    private List<Tipoproduto> productTypeList;
    private Tipoproduto productType;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }    
    
    public void setProductTypeList(List<Tipoproduto> productTypeList)
    {
        this.productTypeList = productTypeList;
    }
    
    public void setProductType(Tipoproduto productType)
    {
        this.productType = productType;
    }
    
    public void setField()
    {
        this.categoryName.setText(productType.getNome());
    }
    
}
