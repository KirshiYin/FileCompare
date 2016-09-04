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
	
	public Button browse;
	public Button compare;
	public TextArea textArea1;
	public TextArea textArea2;
	public Stage primaryStage;
	public File selectedFile;
	TextArea textAreaToFill;

	public void displayFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		selectedFile = fileChooser.showOpenDialog(primaryStage);
		try {
			Scanner fileScanner = new Scanner(new File(selectedFile.toString()));
			if (textArea1.getText().trim().equals("")) {
				textAreaToFill = textArea1;
			} else {
				textAreaToFill = textArea2;
			}
			while (fileScanner.hasNext()) {
				if (fileScanner.hasNext()) {
					textAreaToFill.appendText(fileScanner.next() + " ");
				}
				// Platform.runLater(() -> textArea.appendText(s.next()));
				// System.out.println(s.next());
			}
			fileScanner.close();

		} catch (FileNotFoundException | NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("an error has occured: " + e.getMessage());
		} 

	}
	
	public boolean compareFilesStrings(String text1, String text2){
		boolean result=true;
		int shorterTextLength=0;
		if(text1.length()>text2.length()){
			shorterTextLength=text2.length();
		}else{
			shorterTextLength=text1.length();
		}
		
		for (int i =0;i<shorterTextLength;i++){
			if(text1.charAt(i)!=(text2.charAt(i))){
				result= false;
			}
		}
		return result;
	}
	public void compareFiles(){
		boolean results = compareFilesStrings(textArea1.getText(), textArea2.getText());
		System.out.println(results);
	}
}
