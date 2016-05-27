/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sab_implementacija;

/**
 *
 * @author Marija
 */
public class Soba {

    private int BrOsoba;
    private int RrBr;
    private String Opis;
    private int IDSoba;

    public Soba(int IDSoba, int BrOsoba, int RrBr, String Opis) {
        this.IDSoba = IDSoba;
        this.BrOsoba = BrOsoba;
        this.RrBr = RrBr;
        this.Opis = Opis;
    }

    public int getIDSoba() {
        return IDSoba;
    }

    public void setIDSoba(int IDSoba) {
        this.IDSoba = IDSoba;
    }

    public int getBrOsoba() {
        return BrOsoba;
    }

    public void setBrOsoba(int BrOsoba) {
        this.BrOsoba = BrOsoba;
    }

    public int getRrBr() {
        return RrBr;
    }

    public void setRrBr(int RrBr) {
        this.RrBr = RrBr;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String Opis) {
        this.Opis = Opis;
    }

    @Override
    public String toString() {
        return "Soba{" + "BrOsoba=" + BrOsoba + ", RrBr=" + RrBr + ", Opis=" + Opis + ", IDSoba=" + IDSoba + '}';
    }

}
