/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sab_implementacija;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marija
 */
public class Rezervacija {

    private String Ime;
    private String Prezime;
    private String Username;
    private String Email;
    private String BrojTelefona;
    private Integer RdBRSobe;
    private String NazivApartmana;
    private String UlicaIBroj;
    private Integer IDApartman;

    public Rezervacija(String Ime, String Prezime, String Username, String Email, String BrojTelefona, int RdBRSobe, String NazivApartmana, String UlicaIBroj, Integer IDApartman) {
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.Username = Username;
        this.Email = Email;
        this.BrojTelefona = BrojTelefona;
        this.RdBRSobe = RdBRSobe;
        this.NazivApartmana = NazivApartmana;
        this.UlicaIBroj = UlicaIBroj;
        this.IDApartman = IDApartman;
    }

    public static void brisanjeIsteklihRezervacija() {
        try {

            Date now = new Date();
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String TrenutnoVreme = formatter.format(now);
            Connection con = DB.connection;

            CallableStatement cstmt = con.prepareCall("{CALL istekleRezervacije(?)}");

            cstmt.setString(1, TrenutnoVreme);

           cstmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Integer getRdBRSobe() {
        return RdBRSobe;
    }

    public void setRdBRSobe(Integer RdBRSobe) {
        this.RdBRSobe = RdBRSobe;
    }

    public Integer getIDApartman() {
        return IDApartman;
    }

    public void setIDApartman(Integer IDApartman) {
        this.IDApartman = IDApartman;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String Prezime) {
        this.Prezime = Prezime;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getBrojTelefona() {
        return BrojTelefona;
    }

    public void setBrojTelefona(String BrojTelefona) {
        this.BrojTelefona = BrojTelefona;
    }

    public String getNazivApartmana() {
        return NazivApartmana;
    }

    public void setNazivApartmana(String NazivApartmana) {
        this.NazivApartmana = NazivApartmana;
    }

    public String getUlicaIBroj() {
        return UlicaIBroj;
    }

    public void setUlicaIBroj(String UlicaIBroj) {
        this.UlicaIBroj = UlicaIBroj;
    }

    @Override
    public String toString() {
        return "\n" + Ime + " " + Prezime + " " + Username + "\nEMAIL= " + Email + ", BROJ TELEFONA= " + BrojTelefona + "\n" + IDApartman + "." + "NAZIV: " + NazivApartmana + "REDNI BROJ SOBE " + RdBRSobe + "\nADRESA: " + UlicaIBroj;
    }

}
