package com.example.sauceda.patrondiseoobserver.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by sauceda on 17/05/18.
 */

public class Boletos extends Observable {

    int total=20;
    int boleto;
    public static Observer observer;


    public Boletos() {
    }

    public int getBoleto() {
        return total;
    }

    public void setBoleto(int boleto) {
        int boletos;
        boletos=total-boleto;
        total=boletos;
        setChanged();
        notifyObservers(total);

    }

    @Override
    public synchronized void addObserver(Observer o) {
        this.observer=o;
    }

    @Override
    public void notifyObservers(Object total) {
        if(observer!=null){
            observer.update(this,total);
        }
    }
}
