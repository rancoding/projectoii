package projetoii.design.administrator.warehouse.data.category.list;

import dao.Tipoproduto;
import hibernate.HibernateUtil;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.hibernate.Session;
import projetoii.design.administrator.warehouse.data.category.add.FXMLAddCategoryController;
import projetoii.design.administrator.warehouse.data.category.edit.FXMLEditCategoryController;

public class FXMLListCategoryController implements Initializable {

    // FXML Table Variables
    @FXML private TableView<Tipoproduto> categoryTable;
    @FXML private TableColumn<Tipoproduto, String> nameColumn;
    @FXML private TableColumn<Tipoproduto, String> editColumn;
    private ObservableList<Tipoproduto> productTypeObservableList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        /* Initializes and opens the database session */
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        /* Retrieves all database product types to an arraylist and initializes the table values if it is not empty */
        List<Tipoproduto> productTypeList = session.createCriteria(Tipoproduto.class).list();
        
        if(!(productTypeList.isEmpty()))
        {
            initializeTable(productTypeList);
        }
        
        /* Closes the database connection */
        session.close();
    }
    
    // Initializes table values
    // - Set a cell value factory for each column
    // - Creates a new image with an edit icon
    // - Sets the cell factory for the edit column by calling the getButtonCell function
    // - Adds a list of product types of the observable list
    // - Sets the table items with the observable list product types
    private void initializeTable(List<Tipoproduto> productTypeList)
    {
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.editColumn.setCellValueFactory(new PropertyValueFactory<>(""));
        
        Image image = new Image(getClass().getResourceAsStream("image/edit.png"));
        Image imageHover = new Image(getClass().getResourceAsStream("image/edit_hover.png"));
        editColumn.setCellFactory(getButtonCell(image, imageHover));
        
        productTypeObservableList = FXCollections.observableArrayList(productTypeList);
        this.categoryTable.setItems(productTypeObservableList);
    }
    
    // Creates a button and its set on action
    private Callback getButtonCell(Image image, Image imageHover)
    {
        Callback<TableColumn<Tipoproduto, String>, TableCell<Tipoproduto, String>> cellFactory;
        cellFactory = new Callback<TableColumn<Tipoproduto, String>, TableCell<Tipoproduto, String>>()
        {
            @Override
            public TableCell call(final TableColumn<Tipoproduto, String> param)
            {
                final TableCell<Tipoproduto, String> cell = new TableCell<Tipoproduto, String>()
                {
                    final Button button = new Button();
                    
                    @Override
                    public void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if(empty)
                        {
                            setGraphic(null);
                            setText(null);
                        }
                        else
                        {
                            button.setOnAction((event) -> {
                                Tipoproduto type = getTableView().getItems().get(getIndex());
                                loadNewEditWindow(FXMLEditCategoryController.class, "FXMLEditCategory.fxml", "Armazém - Editar Categoria", "Não foi possível carregar o ficheiro FXMLEditCategory.fxml", type);
                            });
                            
                            setGraphic(button);
                            setText(null);
                            
                            ImageView imageView = new ImageView();
                            setButtonImageView(imageView, image, 12, 12);
                            setRowButton(button, imageView, image, imageHover);
                        }
                    }
                };
                
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        };
        
        return cellFactory;
    }
    
    
    // Sets the image to be used on a button
    private void setButtonImageView(ImageView imageView, Image image, double width, double height)
    {
        imageView.setImage(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
    }
    
    // Sets the row button listener, graphics and background
    private void setRowButton(Button button, ImageView imageView, Image image, Image imageHover)
    {
        button.setBackground(Background.EMPTY);
        button.setGraphic(imageView);

        button.hoverProperty().addListener((ov, oldValue, newValue) -> {
            if(newValue)
            {
                setButtonImageView(imageView, imageHover, 14, 14);
                button.setGraphic(imageView);
            }
            else
            {
                setButtonImageView(imageView, image, 12, 12);
                button.setGraphic(imageView);
            }
        });
    }
    
    @FXML
    void handleAddButtonAction(ActionEvent event)
    {
        loadNewWindow(FXMLAddCategoryController.class, "FXMLAddCategory.fxml", "Armazém - Adicionar Categoria", "Não foi possível carregar o ficheiro FXMLAddCategory.fxml");
    }
    
    private void loadNewWindow(Class controller, String fileName, String title, String message)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(controller.getResource(fileName));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(Exception e)
        {
            System.out.println(message);
        }
    }
    
    private void loadNewEditWindow(Class controller, String fileName, String title, String message, Tipoproduto type)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(controller.getResource(fileName));
            Parent root = (Parent) loader.load();
            
            FXMLEditCategoryController editController = (FXMLEditCategoryController) loader.getController();
            editController.setProductTypeList(productTypeObservableList);
            editController.setProductType(type);
            editController.setField();
            
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(Exception e)
        {
            System.out.println(message);
        }
    }
}
