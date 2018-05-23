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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javax.swing.DefaultComboBoxModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
       
        
        ObservableList<Marca> marcaObservableList;

        List<Marca> marcaList = session.createCriteria(Marca.class).list();
        marcaObservableList = FXCollections.observableArrayList(marcaList);

        
        brandComboBox.setItems(marcaObservableList);
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
        session.close(); 
    }
    
    public void fillTypeProductComboBox(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        
        ObservableList<Tipoproduto> tipoProdutoObservableList;

        List<Tipoproduto> tipoProdutoList = session.createCriteria(Tipoproduto.class).list();
        tipoProdutoObservableList = FXCollections.observableArrayList(tipoProdutoList);

     
        typeComboBox.setItems(tipoProdutoObservableList);
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
       
        
        ObservableList<Tamanho> tamanhoObservableList;

        List<Tamanho> tamanhoList = session.createCriteria(Tamanho.class).list();
        tamanhoObservableList = FXCollections.observableArrayList(tamanhoList);

        
        sizeComboBox.setItems(tamanhoObservableList);
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
       
        
        ObservableList<Cor> corObservableList;

        List<Cor> corList = session.createCriteria(Cor.class).list();
        corObservableList = FXCollections.observableArrayList(corList);

     
        colorComboBox.setItems(corObservableList);
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
    
    public void addProduto(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        int exists = 0;
        
        Transaction tx = session.beginTransaction();
        
        
        
        List<Produto> products = new ArrayList<>();
        products = session.createCriteria(Produto.class).list(); 
        Produto prod = new Produto();
        prod.setCodbarras(Long.parseLong(barCodeText.getText()));
        prod.setDescricao(nameText.getText());
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
            if(prod.getPrecocompra()<prod.getPrecovenda()){
                session.save(prod);
                tx.commit();
            }
            
        }
        
        
        
        
        session.close();
    }
    
}
