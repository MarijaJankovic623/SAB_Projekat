/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sab_implementacija;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marija
 */
public class Apartman {

    private Integer IDApartman;
    private String Drzava;
    private String Grad;
    private String UlicaIBroj;
    private String Naziv;

    public Apartman(Integer ID, String Drzava, String Grad, String UlicaIBroj, String Naziv) {
        this.IDApartman = ID;
        this.Drzava = Drzava;
        this.Grad = Grad;
        this.UlicaIBroj = UlicaIBroj;
        this.Naziv = Naziv;
    }

    public Integer getIDApartman() {
        return IDApartman;
    }

    public static Integer dohvatiIDApartmana(String Naziv) {

        Connection con = DB.connection;
        Integer ID = 0;

        String SQLStm = "SELECT IDApartman FROM Apartman WHERE Naziv = ?";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, Naziv);

            ResultSet rezultat = stmt.executeQuery();
            rezultat.next();
            ID = rezultat.getInt("IDApartman");

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ID;
    }

    public void setIDApartman(Integer IDApartman) {
        this.IDApartman = IDApartman;
    }

    public String getDrzava() {
        return Drzava;
    }

    public void setDrzava(String Drzava) {
        this.Drzava = Drzava;
    }

    public String getGrad() {
        return Grad;
    }

    public void setGrad(String Grad) {
        this.Grad = Grad;
    }

    public String getUlicaIBroj() {
        return UlicaIBroj;
    }

    public void setUlicaIBroj(String UlicaIBroj) {
        this.UlicaIBroj = UlicaIBroj;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    @Override
    public String toString() {
        return "Apartman{" + "IDApartman=" + IDApartman + ", Drzava=" + Drzava + ", Grad=" + Grad + ", UlicaIBroj=" + UlicaIBroj + ", Naziv=" + Naziv + '}';
    }

    public static List<Apartman> pregledApartmanaDrzava(String Drzava) {
        Connection con = DB.connection;
        List<Apartman> listaApartmana = new LinkedList<Apartman>();

        try {

            String SQLStm = "SELECT * FROM Apartman WHERE Drzava = ?";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, Drzava);

            ResultSet rezultat = stmt.executeQuery();

            while (rezultat.next()) {
                Apartman apt = new Apartman(rezultat.getInt("IDApartman"), rezultat.getString("Drzava"), rezultat.getString("Grad"), rezultat.getString("UlicaIBroj"), rezultat.getString("Naziv"));
                listaApartmana.add(apt);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaApartmana;
    }

    public static List<Apartman> pregledApartmanaDrzavaGrad(String Drzava, String Grad) {
        Connection con = DB.connection;
        List<Apartman> listaApartmana = new LinkedList<Apartman>();

        try {

            String SQLStm = "SELECT * FROM Apartman WHERE Drzava = ? AND Grad = ?";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, Drzava);
            stmt.setString(2, Grad);

            ResultSet rezultat = stmt.executeQuery();

            while (rezultat.next()) {
                Apartman apt = new Apartman(rezultat.getInt("IDApartman"), rezultat.getString("Drzava"), rezultat.getString("Grad"), rezultat.getString("UlicaIBroj"), rezultat.getString("Naziv"));
                listaApartmana.add(apt);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaApartmana;
    }

}
