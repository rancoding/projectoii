/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoii.design.administrator.warehouse.data.product.add;

import dao.Cor;
import dao.Funcionario;
import dao.Marca;
import dao.Produto;
import dao.Tamanho;
import dao.Tipoproduto;
import hibernate.HibernateUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.apache.commons.lang3.text.WordUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import projetoii.design.administrator.warehouse.data.brand.add.FXMLAddBrandController;
import projetoii.design.administrator.warehouse.data.category.add.FXMLAddCategoryController;
import projetoii.design.administrator.warehouse.data.color.add.FXMLAddColorController;
import projetoii.design.administrator.warehouse.data.size.add.FXMLAddSizeController;

/**
 * FXML Controller class
 *
 * @author Gustavo Vieira
 */
public class FXMLAddProductController implements Initializable {
    
    @FXML private TextField barCodeText;
    @FXML private TextField nameText;
    @FXML private ComboBox brandComboBox;
    @FXML private ComboBox typeComboBox;
    @FXML private ComboBox sizeComboBox;
    @FXML private ComboBox genderComboBox;
    @FXML private ComboBox colorComboBox;
    @FXML private TextField buyPriceText;
    @FXML private TextField sellPriceText;
    
    ObservableList<Marca> marcaObservableList;
    ObservableList<Tipoproduto> tipoProdutoObservableList;
    ObservableList<Tamanho> tamanhoObservableList;
    ObservableList<Cor> corObservableList;
    
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fillBrandComboBox();
        fillTypeProductComboBox();
        fillSizeComboBox();
        fillGenderComboBox();
        fillColorComboBox();
    }    
    

    
        
    public void fillBrandComboBox(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        
        

        List<Marca> marcaList = session.createCriteria(Marca.class).list();
        this.marcaObservableList = FXCollections.observableArrayList(marcaList);

        
        brandComboBox.setItems(this.marcaObservableList);
        brandComboBox.setConverter(new StringConverter<Marca>()
        {
                    @Override
                    public String toString(Marca object) {
                        return object.getNome();
                    }

                    @Override
                    public Marca fromString(String string) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
        });    
        
    }
    
    public void fillTypeProductComboBox(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        
        

        List<Tipoproduto> tipoProdutoList = session.createCriteria(Tipoproduto.class).list();
        this.tipoProdutoObservableList = FXCollections.observableArrayList(tipoProdutoList);

     
        typeComboBox.setItems(this.tipoProdutoObservableList);
        typeComboBox.setConverter(new StringConverter<Tipoproduto>()
        {
                    @Override
                    public String toString(Tipoproduto object) {
                        return object.getNome();
                    }

                    @Override
                    public Tipoproduto fromString(String string) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
        });    
        session.close();

    }
    
    public void fillSizeComboBox(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        
        

        List<Tamanho> tamanhoList = session.createCriteria(Tamanho.class).list();
        this.tamanhoObservableList = FXCollections.observableArrayList(tamanhoList);

        
        sizeComboBox.setItems(this.tamanhoObservableList);
        sizeComboBox.setConverter(new StringConverter<Tamanho>()
        {
                    @Override
                    public String toString(Tamanho object) {
                        return object.getDescricao();
                    }

                    @Override
                    public Tamanho fromString(String string) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
        });  
        session.close();
    }
    
    public void fillGenderComboBox(){
    
        
        ObservableList genderObservableList;

        List genderList = new ArrayList<>();
        
        genderList.add("UniSexo");
        genderList.add("Masculino");
        genderList.add("Feminino");
        
        genderObservableList = FXCollections.observableArrayList(genderList);
        
        
    
        genderComboBox.setItems(genderObservableList);
        
        
    }
    
    public void fillColorComboBox(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        
        

        List<Cor> corList = session.createCriteria(Cor.class).list();
        this.corObservableList = FXCollections.observableArrayList(corList);

     
        colorComboBox.setItems(this.corObservableList);
        colorComboBox.setConverter(new StringConverter<Cor>()
        {
                    @Override
                    public String toString(Cor object) {
                        return object.getNome();
                    }

                    @Override
                    public Cor fromString(String string) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
        });  
        session.close();
    }
    
    private char getComboBoxGender(int posicao) {
        switch(posicao){
            case 0 : 
                return 'U';
            case 1: 
                return 'M';
            case 2: 
                return 'F';
        }    
        return 0;
    }
    
    public void addProduto(ActionEvent event){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        int exists = 0;
        int empty = emptyVariables();
        
        Transaction tx = session.beginTransaction();
        
        
        
        List<Produto> products = new ArrayList<>();
        products = session.createCriteria(Produto.class).list(); 
        
        Produto prod = new Produto();
        
        if (empty == 1){
            this.showConfirmation("Aviso", "Introduza todos os campos");
        }else{
        
        prod.setCodbarras(Long.parseLong(barCodeText.getText()));
        prod.setDescricao(WordUtils.capitalizeFully(nameText.getText()));
        prod.setMarca((Marca) brandComboBox.getSelectionModel().getSelectedItem());
        prod.setTamanho((Tamanho) sizeComboBox.getSelectionModel().getSelectedItem());
        prod.setTipoproduto((Tipoproduto) typeComboBox.getSelectionModel().getSelectedItem());
        prod.setGenero(getComboBoxGender(genderComboBox.getSelectionModel().getSelectedIndex()));
        prod.setCor((Cor) colorComboBox.getSelectionModel().getSelectedItem());
        prod.setPrecocompra(Long.parseLong(buyPriceText.getText()));
        prod.setPrecovenda(Long.parseLong(sellPriceText.getText()));
        
        for(Produto u: products){
            if(prod.getCodbarras() == u.getCodbarras()){
                exists = 1;
                
            }
        }
        
        
        
            if(exists == 1){
                if(this.showConfirmation("Aviso", "O produto que introduziu já existe")){

                    this.resetInputs(event);
                }
            }else{
                if(prod.getPrecocompra()>prod.getPrecovenda()){
                    if(this.showConfirmation("Aviso", "O Preço de Venda deve ser superior ao Preço de Compra")){
                        this.resetInputs(event);
                    }   
                }else{    
                    session.save(prod);
                }

            }
        }
        tx.commit();
        session.close();
        prod = null;
        this.resetInputs(event);
    }
    
    private boolean showConfirmation(String title, String header){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        
        Optional<ButtonType> option = alert.showAndWait();
        return option.get() == ButtonType.OK;
    }
    
    public int emptyVariables(){
        if(barCodeText.getText().isEmpty() || 
                nameText.getText().isEmpty() ||
                brandComboBox.getSelectionModel().isEmpty() || 
                sizeComboBox.getSelectionModel().isEmpty() || 
                genderComboBox.getSelectionModel().isEmpty() || 
                typeComboBox.getSelectionModel().isEmpty() ||
                colorComboBox.getSelectionModel().isEmpty() ||
                buyPriceText.getText().isEmpty() || sellPriceText.getText().isEmpty() ) {
            
            return 1;
        } else{
            return 0;
        }
    
    }
    
    public void resetInputs(ActionEvent event){
        this.barCodeText.setText(null);
        this.nameText.setText(null);
        this.brandComboBox.setValue(null);
        this.typeComboBox.setValue(null);
        this.sizeComboBox.setValue(null);
        this.colorComboBox.setValue(null);
        this.buyPriceText.setText(null);
        this.sellPriceText.setText(null);  
    }
    
    
    
    @FXML
    private void changetoAddBrand(ActionEvent event) throws IOException{
       
        
        FXMLLoader loader = new FXMLLoader(FXMLAddBrandController.class.getResource("FXMLAddBrand.fxml"));
        Parent root = (Parent) loader.load();
        FXMLAddBrandController addController = (FXMLAddBrandController) loader.getController();
        addController.setList(marcaObservableList);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    private void changetoAddSize(ActionEvent event) throws IOException{
       
        
        FXMLLoader loader = new FXMLLoader(FXMLAddSizeController.class.getResource("FXMLAddSize.fxml"));
        Parent root = (Parent) loader.load();
        FXMLAddSizeController addController = (FXMLAddSizeController) loader.getController();
        addController.setList(marcaObservableList);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void changetoAddCategory(ActionEvent event) throws IOException{
       
        
        FXMLLoader loader = new FXMLLoader(FXMLAddCategoryController.class.getResource("FXMLAddCategory.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void changetoAddColor(ActionEvent event) throws IOException{
       
        
        FXMLLoader loader = new FXMLLoader(FXMLAddColorController.class.getResource("FXMLAddColor.fxml"));
        Parent root = (Parent) loader.load();
        FXMLAddColorController addController = (FXMLAddColorController) loader.getController();
        addController.setList(marcaObservableList);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    
    
    
}
