package Mainn;



import java.io.IOException;

import Controller.controller;
import Model.model;
import View.view;

public class main {
	 public static void main(String[] args) {
	        model textFile = new model();
	        view textView = new view();
	        controller c = new controller(textFile, textView);

	        textView.setVisible(true);
	    }

}
