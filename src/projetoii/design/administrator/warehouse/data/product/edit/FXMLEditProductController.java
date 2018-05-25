/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoii.design.administrator.warehouse.data.product.edit;

import dao.Produto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.text.WordUtils;
import projetoii.design.administrator.warehouse.data.product.list.FXMLListProductController;

/**
 * FXML Controller class
 *
 * @author Gustavo Vieira
 */
public class FXMLEditProductController implements Initializable {

    @FXML private TextField barCodeText;
    @FXML private TextField nameText;
    @FXML private ComboBox brandComboBox;
    @FXML private ComboBox typeComboBox;
    @FXML private ComboBox sizeComboBox;
    @FXML private ComboBox genderComboBox;
    @FXML private ComboBox colorComboBox;
    @FXML private TextField buyPriceText;
    @FXML private TextField sellPriceText;
    
    private FXMLListProductController listProductController;
    private ObservableList<Produto> productList;
    private Produto product;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initializeOnControllerCall(FXMLListProductController listProductsController, ObservableList<Produto> productList, Produto product)
    {
         /* Sets all variables accordingly to received parameters */
        setListProductController(listProductsController);
        setProductList(productList);
        setProduct(product);
        setField();
        
    }
    
    private void setListProductController(FXMLListProductController listProductController)
    {
        this.listProductController = listProductController;
    }
    
    private void setProductList(ObservableList<Produto> productList)
    {
        this.productList = productList;
    }
    
    private void setProduct(Produto product)
    {
        this.product = product;
    }
    
    private void setField()
    {
        this.barCodeText.setText(String.valueOf(product.getCodbarras()));
        this.nameText.setText(product.getDescricao());
        this.brandComboBox.setValue(product.getMarca().getNome());
        this.sizeComboBox.setValue(product.getTamanho().getDescricao());
        this.typeComboBox.setValue(product.getTipoproduto().getNome());
        this.genderComboBox.setValue(product.getGenero());
        this.colorComboBox.setValue(product.getCor().getNome());
        this.buyPriceText.setText(String.valueOf(product.getPrecocompra()));
        this.sellPriceText.setText(String.valueOf(product.getPrecovenda()));     
    }
    
    /* * Sets the new product name, updates in the database, refreshes the list controller table and closes current window * */
    @FXML
    void onEditButtonClick(ActionEvent event) throws IOException
    {
        //product.setCodbarras(WordUtils.capitalizeFully(Long.valueOf(barCodeText.getText())));
        
        
        //updateCategory();
        
        //this.listCategoryController.categoryTable.refresh();
        //closeStage(event);
    }
    
}
