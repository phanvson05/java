package Controller;

import java.io.BufferedWriter;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import Model.model;
import View.view;

public class controller {
    private model textFile;
    private view textView;

    public controller(model textFile, view textView) {
        this.textFile = textFile;
        this.textView = textView;

        textView.getSaveButton().addActionListener(e -> saveToFile());
        textView.getLoadButton().addActionListener(e -> loadFromFile());
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(textView);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textView.getTextArea().getText());
                System.out.println("lưu thành công");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Lỗi lưu.");
            }
        }
    }

    private void loadFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(textView);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
      System.out.println("khúc này k lỗi(loadFromFile)");
            try {
                textFile.loadFromFile(file);
                StringBuilder sb = new StringBuilder();
                textFile.getLinesStream().forEach(line -> sb.append(line).append("\n"));
                textView.getTextArea().setText(sb.toString());
                System.out.println("successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("lỗi ");
            }
        }
    }
}