package exercise10;
/*
 * 
 * @Author : Ramesh Kumar
 */
import javafx.scene.Scene;
import java.util.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {
	int widthadjuster = 0;
	int red = 0;
	int green = 0;
	int blue = 0;
	int heightadjuster = 0;

	@FXML
	private Slider width;

	@FXML
	private AnchorPane mainLayout;
	@FXML
	private Slider height;
	@FXML
	private Slider redslider;
	@FXML
	private Slider greenslider;
	@FXML
	private Slider blueslider;

	@FXML
	private Button redbutton;

	@FXML
	private Button greenbutton;

	@FXML
	private Button bluebutton;

	@FXML
	private ComboBox<String> selectimagesComboBox;
	@FXML
	private ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();

	@FXML
	private ArrayList<Circle> circleList = new ArrayList<Circle>();

	@FXML
	private ArrayList<Separator> horizontalseparator = new ArrayList<Separator>();

	@FXML
	private ArrayList<Separator> verticalseparator = new ArrayList<Separator>();

	@FXML
	private ArrayList<Rectangle> blackboxes = new ArrayList<Rectangle>();
	@FXML
	private ArrayList<Rectangle> whiteboxes = new ArrayList<Rectangle>();

	@FXML
	private ArrayList<Separator> horizontallinesinimage2 = new ArrayList<Separator>();

	@FXML
	private Label image1;

	@FXML
	private Label image2;
	@FXML
	ObservableList<String> selectimageslist = FXCollections.observableArrayList();

	@FXML
	private void initialize() {
		
		selectimageslist.add("Image1");
		selectimageslist.add("Image2");
		selectimagesComboBox.setItems(selectimageslist);
		selectimagesComboBox.setValue("Image1");
	
		selectimagesComboBox.setOnAction((event) -> {
			
			if (selectimagesComboBox.getSelectionModel().getSelectedItem().toString().equals("Image1")) {
				
				colorChangeImage1(); 
				widthChangeImage1();
				heightChangeImage1();
				
				}

			
			else {
				colorChangeImage2();
				widthChangeImage2();
				heightChangeImage2();
				
			}
		});
		
		
		
		//Coloring images by default.
		image1.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		image2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

}

	@FXML
	private void widthChangeImage1(){
		width.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				widthadjuster = newValue.intValue();
				for (Rectangle rectangle : rectangleList){
					rectangle.setWidth(widthadjuster);
				}
				
			}
		});
	}
	
	@FXML
	private void heightChangeImage1(){
		height.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				heightadjuster = newValue.intValue();
				for (Rectangle rectangle : rectangleList){
					rectangle.setHeight(heightadjuster);
					
				}
				
			}
		});
	}
	
	@FXML
	private void colorChangeImage1() {
		
		redslider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				red = newValue.intValue();
				
				
				for (Rectangle rectangle : rectangleList){
					rectangle.setFill(Color.rgb(red, 0, 0));
				}
				
				
			}
		});
		
		greenslider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				green = newValue.intValue();
				for (Circle circle : circleList){
					circle.setFill(Color.rgb(0, green, 0));
				}
			}
		});
		
		blueslider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				blue = newValue.intValue();
				for (Separator separator : horizontalseparator){
					separator.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				}
				for (Separator separator : verticalseparator){
					separator.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				}
				
			}
		});
		
	}
	
	
	@FXML
	private void colorChangeImage2() {
		
		redslider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				red = newValue.intValue();
				
				
				for (Rectangle rectangle : blackboxes){
					rectangle.setFill(Color.rgb(red, 0, 0));
				}
				
				
			}
		});
		
		greenslider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				green = newValue.intValue();
				for (Rectangle rectangle : whiteboxes){
					rectangle.setFill(Color.rgb(0, green, 0));
				}
			}
		});
		
		blueslider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				blue = newValue.intValue();
				for (Separator separator : horizontallinesinimage2){
					separator.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				}
			
				
			}
		});
		
	}
	@FXML
	private void widthChangeImage2(){
		width.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				widthadjuster = newValue.intValue();
				for (Rectangle rectangle : blackboxes){
					rectangle.setWidth(widthadjuster);
				}
				for (Rectangle rectangle : whiteboxes){
					rectangle.setWidth(widthadjuster);
				}
				
			}
		});
	}
	
	@FXML
	private void heightChangeImage2(){
		height.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				heightadjuster = newValue.intValue();
				for (Rectangle rectangle : blackboxes){
					rectangle.setHeight(heightadjuster);
					
				}
				for (Rectangle rectangle : whiteboxes){
					rectangle.setHeight(heightadjuster);
					
				}
				
			}
		});
	}
	
	
	

}
