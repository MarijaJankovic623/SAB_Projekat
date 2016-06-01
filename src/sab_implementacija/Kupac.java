
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

    public static Integer dohvatiIDKupca(String korisnickoIme) {

        Connection con = DB.connection;
        Integer IDKupac = 0;

        String SQLStm = "SELECT IDKupac FROM Kupac WHERE KorisnickoIme = ?";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, korisnickoIme);

            ResultSet rezultat = stmt.executeQuery();
            if(rezultat.next()){
            IDKupac = rezultat.getInt("IDKupac");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IDKupac;
    }

    public static List<String> dohvatiKupca() {
        List<String> informacije = new LinkedList<String>();
        Connection con = DB.connection;
        try {
            String SQLStm = "SELECT * FROM Kupac WHERE IDKupac = ?";
            PreparedStatement stmt = con.prepareStatement(SQLStm);
            stmt.setInt(1, ID);

            ResultSet rezultat = stmt.executeQuery();

            while (rezultat.next()) {
                informacije.add(rezultat.getString("BrKreditneKartice"));
                  informacije.add(rezultat.getString("BrojTelefona"));
                   informacije.add(rezultat.getString("EMail"));
                informacije.add(rezultat.getString("KorisnickoIme"));
                informacije.add(rezultat.getString("Lozinka"));
              
               
                informacije.add(rezultat.getString("Ime"));
                informacije.add(rezultat.getString("Prezime"));
                

            }

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
      

        return informacije;
    }
    
    
     public static Integer mogucaRegistracija(String KorisnickoIme){
        Connection con = DB.connection;
       Integer ID = 0;

        CallableStatement cstmt = null;
        try {
        cstmt = con.prepareCall("{? = CALL registracijaKupca(?)}");
        cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
        cstmt.setString(2, KorisnickoIme);
        cstmt.execute();
        ID = cstmt.getInt(1);
        
         } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ID;
    }

    public static boolean registracijaKupca(String korisnickoIme, String lozinka, String EMail, String BrojTelefona, String Ime, String Prezime, String BrKreditneKartice) {
        Connection con = DB.connection;
         if(mogucaRegistracija(korisnickoIme) != 0) return false;
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
            Logger.getLogger(Prodavac.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Prodavac.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public static boolean uredjivanjePodatakaKupca(String lozinka, String EMail, String BrojTelefona, String Ime, String Prezime, String BrKreditneKartice) {
        Connection con = DB.connection;

        try {

            String SQLStm = "UPDATE  Kupac SET BrKreditneKartice =? ,Lozinka =? , EMail =? , BrojTelefona=? , Ime=? , Prezime=? WHERE IDKupac =? ";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, BrKreditneKartice);
            stmt.setString(2, lozinka);
            stmt.setString(3, EMail);
            stmt.setString(4, BrojTelefona);
            stmt.setString(5, Ime);
            stmt.setString(6, Prezime);
            stmt.setInt(7, ID);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Prodavac.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    public static List<Rezervacija> pregledRezervacijaKupac() {
        Connection con = DB.connection;
        List<Rezervacija> listaSoba = new LinkedList<Rezervacija>();

        try {

            CallableStatement cstmt = con.prepareCall("{CALL prelistavanjeRezervacijaKupac(?)}");

            cstmt.setInt(1, ID);

            ResultSet rezultat = cstmt.executeQuery();

            while (rezultat.next()) {
                Rezervacija apt = new Rezervacija(rezultat.getString("Ime"), rezultat.getString("Prezime"), rezultat.getString("KorisnickoIme"), rezultat.getString("Email"), rezultat.getString("BrojTelefona"), rezultat.getInt("RdBroj"), rezultat.getString("Naziv"), rezultat.getString("UlicaIBroj"), rezultat.getInt("IDApartman"));
                listaSoba.add(apt);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return listaSoba;

    }
}
