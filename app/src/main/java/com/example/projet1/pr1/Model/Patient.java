package com.example.projet1.pr1.Model;

public class Patient {
    int age;
    boolean jeuner;
    float valeurMesuree;
    String tvReponse;
    //Flèche "Update" Controller --> Model
    public Patient(int age, boolean jeuner, float valeurMesuree) {
        this.age = age;
        this.jeuner = jeuner;
        this.valeurMesuree = valeurMesuree;
        calculer();
    }

    //Flèche "Notify" Model --> Controller
    public String getTvReponse() {
        return tvReponse;
    }

    public boolean isJeuner() {
        return jeuner;
    }


    public float getvaleurMesuree() {
        return valeurMesuree;
    }

    public int getAge() {
        return age;
    }


    public void calculer() {

        if (jeuner) {
            if (age >= 13) {
                if (valeurMesuree < 5.0)
                    tvReponse = "Niveau de glycémie est trop bas";
                else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                    tvReponse = "Niveau de glycémie est normale";
                else
                    tvReponse = "Niveau de glycémie est trop élevé";
            } else if (age >= 6 && age <= 12) {
                if (valeurMesuree < 5.0)
                    tvReponse = "Niveau de glycémie est trop bas";
                else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                    tvReponse = "Niveau de glycémie est normale";
                else
                    tvReponse = "Niveau de glycémie est trop élevé";
            } else if (age < 6) {
                if (valeurMesuree < 5.5)
                    tvReponse = "Niveau de glycémie est trop bas";
                else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                    tvReponse = "Niveau de glycémie est normale";
                else
                    tvReponse = "Niveau de glycémie est trop élevé";
            }
        } else {
            if (valeurMesuree > 10.5)
                tvReponse = "Niveau de glycémie est trop élevé";
            else
                tvReponse = "Niveau de glycémie est normale";
        }

    }


}


