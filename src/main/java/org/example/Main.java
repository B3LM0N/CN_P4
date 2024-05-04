package org.example;

import Controlador.FederacionController;
import Modelo.Entidades.Federacion;


public class Main {
    public static void main(String[] args) {

        FederacionController federacionController = new FederacionController();


        Federacion fede = federacionController.porId(1);
        System.out.println(fede.getNombreFederacion());

    }
}