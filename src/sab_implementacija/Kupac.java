/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sab_implementacija;

import java.sql.CallableStatement;
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
public class Kupac {

    private static Integer ID;
    private static Boolean ulogovan;

    public static Integer getID() {
        return ID;
    }

    public static Boolean getUlogovan() {
        return ulogovan;
    }

    public static void setID(Integer ID) {
        Kupac.ID = ID;
    }

    public static void setUlogovan(Boolean ulogovan) {
        Kupac.ulogovan = ulogovan;
    }

    public static Integer dohvatiIDProdavca(String korisnickoIme) {

        Connection con = DB.connection;
        Integer IDKupac = 0;

        String SQLStm = "SELECT IDKupac FROM Kupac WHERE KorisnickoIme = ?";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, korisnickoIme);

            ResultSet rezultat = stmt.executeQuery();
            rezultat.next();
            IDKupac = rezultat.getInt("IDKupac");

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IDKupac;
    }

    public static boolean registracijaKupca(String korisnickoIme, String lozinka, String EMail, String BrojTelefona, String Ime, String Prezime, String BrKreditneKartice) {
        Connection con = DB.connection;

        try {

            String SQLStm = "INSERT INTO Kupac(BrKreditneKartice,KorisnickoIme,Lozinka, EMail, BrojTelefona, Ime, Prezime) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, BrKreditneKartice);
            stmt.setString(2, korisnickoIme);
            stmt.setString(3, lozinka);
            stmt.setString(4, EMail);
            stmt.setString(5, BrojTelefona);
            stmt.setString(6, Ime);
            stmt.setString(7, Prezime);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static boolean prijavljivanjeKupca(String korisnickoIme, String lozinka) {
        Connection con = DB.connection;

        try {

            String SQLStm = "SELECT * FROM  Kupac WHERE KorisnickoIme = ? AND Lozinka = ?";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, korisnickoIme);
            stmt.setString(2, lozinka);

            stmt.execute();

            if (!stmt.getResultSet().next()) {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public static boolean uredjivanjePodatakaKupca(String korisnickoIme, String lozinka, String EMail, String BrojTelefona, String Ime, String Prezime, String BrKreditneKartice) {
        Connection con = DB.connection;

        try {

            String SQLStm = "UPDATE  Kupac SET BrKreditneKartice =? ,Lozinka =? , EMail =? , BrojTelefona=? , Ime=? , Prezime=?, KorisnickoIme =? WHERE IDKupac =? ";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, BrKreditneKartice);
            stmt.setString(2, lozinka);
            stmt.setString(3, EMail);
            stmt.setString(4, BrojTelefona);
            stmt.setString(5, Ime);
            stmt.setString(6, Prezime);
            stmt.setString(7, korisnickoIme);
            stmt.setInt(8, ID);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static boolean RezervisiSobu(Integer IDKupac, Integer IDSoba, String Dolazak, String Odlazak) {

        Connection con = DB.connection;

        try {

            String SQLStm = "INSERT INTO Rezervacija(IDSoba,IDKupac,DatumPrijave,DatumOdjave) VALUES(?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setInt(1, IDSoba);
            stmt.setInt(2, IDKupac);
            stmt.setString(3, Dolazak);
            stmt.setString(4, Odlazak);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    public static List<Rezervacija> pregledRezervacijaKupac(Integer IDKupac) {
        Connection con = DB.connection;
        List<Rezervacija> listaSoba = new LinkedList<Rezervacija>();

        try {

            CallableStatement cstmt = con.prepareCall("{CALL prelistavanjeRezervacijaKupac(?)}");

            cstmt.setInt(1, IDKupac);

            ResultSet rezultat = cstmt.executeQuery();

            while (rezultat.next()) {
                Rezervacija apt = new Rezervacija(rezultat.getString("Ime"), rezultat.getString("Prezime"), rezultat.getString("KorisnickoIme"), rezultat.getString("Email"), rezultat.getString("BrojTelefona"), rezultat.getInt("RdBroj"), rezultat.getString("Naziv"), rezultat.getString("UlicaIBroj"), rezultat.getInt("IDApartman"));
                listaSoba.add(apt);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSoba;

    }
}
