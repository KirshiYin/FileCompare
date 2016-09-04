package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
	public Button Browse;
	public TextArea textArea1;
	public TextArea textArea2;
	public Stage primaryStage;
	public File selectedFile;
	
	public void displayFile(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		 selectedFile = fileChooser.showOpenDialog(primaryStage);
		 TextArea textAreaToFill = null;
		 try {
			Scanner s = new Scanner(new File(selectedFile.toString()));
			if(textArea1.getText().trim().equals("")){
				textAreaToFill = textArea1;
			}else {
				textAreaToFill = textArea2;
			}
			while(s.hasNext()){
				if(s.hasNext()){
					textAreaToFill.appendText(s.next() + " ");
				}
					//Platform.runLater(() -> textArea.appendText(s.next()));
					// System.out.println(s.next());
				}
			s.close();
			//}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (NoSuchElementException ne){
			System.out.println(ne.getMessage());
		}
		
	}
}
