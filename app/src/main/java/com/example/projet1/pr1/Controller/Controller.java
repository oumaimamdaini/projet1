package com.example.projet1.pr1.Controller;

import com.example.projet1.pr1.Model.Patient;

public final class Controller {
    public static Patient patient;
    private static Controller instance=null;
    private Controller() {super();
    }

    public static final Controller getinstance() {
        if (Controller.instance == null) {
            Controller.instance = new Controller();

        }
        return Controller.instance;
    }


    public void createPatient(int age, float valeurMesuree ,boolean jeuner){
        patient=new Patient(age,jeuner,valeurMesuree);


    }
    public String getResult(){
        return patient.getTvReponse();
    }
    public static Patient getPatient(){
        return patient;
    }

}