package apps;

import javafx.scene.Scene;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;

public class MyController {

	int red = 0;
	int green = 0;
	int blue = 0;
	int red_text_value = 0;
	int green_text_value = 0;
	int blue_text_value = 0;
	@FXML
	private TextField red_intensity_text;

	@FXML
	private TextField green_intensity_text;

	@FXML
	private TextField blue_intensity_text;

	@FXML
	private CheckBox color_change_image1;

	@FXML
	private CheckBox color_change_image2;

	@FXML
	private Slider red_slider;

	@FXML
	private Slider green_slider;

	@FXML
	private Slider blue_slider;

	@FXML
	private Button reset;
	@FXML
	private Label image_1;
	@FXML
	private Label image_2;

	@FXML
	private void initialize() {
		// Set color of both images by default to white.
		image_1.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		image_2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		// Function for red slider to get values from slider to text field and
		// also changes are listened by images.
		red_slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				red = newValue.intValue();
				red_intensity_text.setText(String.valueOf(red));

				checkBoxImage1();
				checkBoxImage2();

			}
		});

		// Function for green slider to get values from slider to text field and
		// also changes are listened by images.
		green_slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				green = newValue.intValue();
				green_intensity_text.setText(String.valueOf(green));
				checkBoxImage1();
				checkBoxImage2();

			}
		});

		// Function for blue slider to get values from slider to text field and
		// also changes are listened by images.
		blue_slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				blue = newValue.intValue();
				blue_intensity_text.setText(String.valueOf(blue));
				checkBoxImage1();
				checkBoxImage2();

			}
		});

		// When user enter desired value on text field of red intensity, colors
		// are changed accordingly.

		red_intensity_text.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				red_text_value = Integer.parseInt(newValue);
				textFieldControllerImage1();
				textFieldControllerImage2();

			}
		});

		// When user enter desired value on text field of green intensity,
		// colors are changed accordingly.

		green_intensity_text.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				green_text_value = Integer.parseInt(newValue);

				textFieldControllerImage1();
				textFieldControllerImage2();

			}
		});

		// When user enter desired value on text field of blue intensity, colors
		// are changed accordingly.
		blue_intensity_text.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				blue_text_value = Integer.parseInt(newValue);
				textFieldControllerImage1();
				textFieldControllerImage2();

			}
		});

	}

	// Method to reset the colors of image to default color. i.e. white
	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
		Stage stage = (Stage) reset.getScene().getWindow();
		stage.close();
	}

	// Method to set checkbox for image 1, when user click on check box, colors
	// can be change in image1.
	@FXML
	private void checkBoxImage1() {
		if (color_change_image1.isSelected()) {
			image_1.setBackground(
					new Background(new BackgroundFill(Color.rgb(red, green, blue), CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}

	// Method to set checkbox for image 2, when user click on check box, colors
	// can be change in image2.
	@FXML
	private void checkBoxImage2() {
		if (color_change_image2.isSelected()) {
			image_2.setBackground(
					new Background(new BackgroundFill(Color.rgb(red, green, blue), CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}

	// Method to change color of image1 from text field
	@FXML
	private void textFieldControllerImage1() {
		if (color_change_image1.isSelected()) {
			image_1.setBackground(new Background(new BackgroundFill(
					Color.rgb(red_text_value, green_text_value, blue_text_value), CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}

	// Method to change color of image2 from text field
	@FXML
	private void textFieldControllerImage2() {
		if (color_change_image2.isSelected()) {
			image_2.setBackground(new Background(new BackgroundFill(
					Color.rgb(red_text_value, green_text_value, blue_text_value), CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}
}