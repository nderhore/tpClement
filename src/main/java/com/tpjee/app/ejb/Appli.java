package com.tpjee.app.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.tpjee.app.model.Vin;

@Stateless
public class Appli {

    private static List<Vin> vins = new ArrayList<>();

    public List<Vin> getAllVin() {
        return vins;
    }

    public void addVin(Vin vin) {
        vins.add(vin);
    }

    public void deleteVinByName(String name) {
        List<Vin> tempList = new ArrayList<>();
        for (Vin unVin : vins) {
            if (!unVin.getNomVin().equals(name)) {
                tempList.add(unVin);
            }
        }
        vins.clear();
        vins.addAll(tempList);
    }

    public void update(Vin oldVin) {

        String name = oldVin.getNomVin();
        String millesime = oldVin.getMillesime();
        List<Vin> tempList = new ArrayList<>();

        for (Vin vin : vins) {
            if (vin.getNomVin().equals(name)) {
                vin.setMillesime(millesime);
            }
            tempList.add(vin);
        }
        vins.clear();
        vins.addAll(tempList);
    }
}
