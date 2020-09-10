package com.quimplex.q_shopdrc.Models;

import java.lang.reflect.Constructor;

public class PresentationModel {

    public PresentationModel(){
        // constructeur vide
    }

    private int presentation_img;

    public PresentationModel(int presentation_img) {
        this.presentation_img = presentation_img;
    }

    public int getPresentation_img() {
        return presentation_img;
    }

    public void setPresentation_img(int presentation_img) {
        this.presentation_img = presentation_img;
    }

}
