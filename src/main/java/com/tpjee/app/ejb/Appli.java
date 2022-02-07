package com.lol.app.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.lol.app.model.Range;

@Stateless
public class Appli {

    private static List<Range> champs = new ArrayList<>();

    public List<Range> getCrewMembers() {
        return champs;
    }

    public void addCrewMember(Range addchamp) {
        champs.add(addchamp);
    }

    public void deleteCrewMemberByName(String name) {

        List<Range> tempList = new ArrayList<>();
        for (var champdel : champs) {
            if (!champdel.getName().equals(name)) {
                tempList.add(champdel);
            }
        }
        champs.clear();
        champs.addAll(tempList);
    }

    public void update(Range champ) {

        String Name = champ.getName();
        String Leposte = champ.getPoste();
        List<Range> tempList = new ArrayList<>();

        for (var Poste : champs) {
            if (Poste.getName().equals(Name)) {
                Poste.setPoste(Leposte);
            }
            tempList.add(Poste);
        }
        champs.clear();
        champs.addAll(tempList);
    }
}
