package app;

import app.controller.AppController;

public class App {
    public static void main(String[] args) {

        new AppController().runOption(AppController.getOption());
    }
}
