/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sab_implementacija;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marija
 */
public class Prodavac {

    private static Integer ID;
    private static Boolean ulogovan;

    public static Integer getID() {
        return ID;
    }

    public static void setID(Integer ID) {
        Prodavac.ID = ID;
    }

    public static Boolean getUlogovan() {
        return ulogovan;
    }

    public static void setUlogovan(Boolean ulogovan) {
        Prodavac.ulogovan = ulogovan;
    }
    
    public static Integer mogucaRegistracija(String KorisnickoIme){
        Connection con = DB.connection;
       Integer ID = 0;

        CallableStatement cstmt = null;
        try {
        cstmt = con.prepareCall("{? = CALL registracijaProdavca(?)}");
        cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
        cstmt.setString(2, KorisnickoIme);
        cstmt.execute();
        ID = cstmt.getInt(1);
        
         } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ID;
    }

    public static boolean registracijaProdavca(String korisnickoIme, String lozinka, String EMail, String BrojTelefona, String Ime, String Prezime, String POS) {
        Connection con = DB.connection;
        if (mogucaRegistracija(korisnickoIme) != 0) {
            return false;
        }

        try {

            String SQLStm = "INSERT INTO Prodavac(POS,KorisnickoIme,Lozinka, EMail, BrojTelefona, Ime, Prezime) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, POS);
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

    public static boolean prijavljivanjeProdavca(String korisnickoIme, String lozinka) {
        Connection con = DB.connection;

        try {

            String SQLStm = "SELECT * FROM  Prodavac WHERE KorisnickoIme = ? AND Lozinka = ?";

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

    public static boolean uredjivanjePodatakaProdavca(String lozinka, String EMail, String BrojTelefona, String Ime, String Prezime, String POS) {
        Connection con = DB.connection;

        try {

            String SQLStm = "UPDATE  Prodavac SET  POS =? ,Lozinka =? , EMail =? , BrojTelefona=? , Ime=? , Prezime=? WHERE IDProdavac =? ";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, POS);
            stmt.setString(2, lozinka);
            stmt.setString(3, EMail);
            stmt.setString(4, BrojTelefona);
            stmt.setString(5, Ime);
            stmt.setString(6, Prezime);
            stmt.setInt(7, ID);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static Integer dohvatiIDProdavca(String korisnickoIme) {

        Connection con = DB.connection;
        Integer IDProdavac = 0;

        String SQLStm = "SELECT IDProdavac FROM Prodavac WHERE KorisnickoIme = ?";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, korisnickoIme);

            ResultSet rezultat = stmt.executeQuery();
           if( rezultat.next()){
            IDProdavac = rezultat.getInt("IDProdavac");
           }

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IDProdavac;
    }

    public static List<String> dohvatiProdavca() {
        List<String> informacije = new LinkedList<String>();
        Connection con = DB.connection;
        try {
            String SQLStm = "SELECT * FROM Prodavac WHERE IDProdavac = ?";
            PreparedStatement stmt = con.prepareStatement(SQLStm);
            stmt.setInt(1, ID);

            ResultSet rezultat = stmt.executeQuery();

            while (rezultat.next()) {
                informacije.add(rezultat.getString("POS"));
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

    public static List<Apartman> pregledApartmana() {
        Connection con = DB.connection;
        List<Apartman> listaApartmana = new LinkedList<Apartman>();

        try {

            String SQLStm = "SELECT * FROM Apartman WHERE IDProdavac = ?";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setInt(1, ID);

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

    public static boolean DodajApartman(String Naziv, String Drzava, String Grad, String UlicaIBroj, String Opis, Integer IDProdavac) {
        Connection con = DB.connection;

        try {

            String SQLStm = "INSERT INTO Apartman(Naziv,Drzava,Grad, UlicaIBroj, Opis, IDProdavac) VALUES(?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setString(1, Naziv);
            stmt.setString(2, Drzava);
            stmt.setString(3, Grad);
            stmt.setString(4, UlicaIBroj);
            stmt.setString(5, Opis);
            stmt.setInt(6, IDProdavac);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    public static boolean DodajSobu(Integer BrOsoba, Integer RdBroj, String Opis, Integer IDApartman) {
        Connection con = DB.connection;

        try {

            String SQLStm = "INSERT INTO Soba(BrOsoba,RdBroj,Opis,IDApartman) VALUES(?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(SQLStm);

            stmt.setInt(1, BrOsoba);
            stmt.setInt(2, RdBroj);
            stmt.setString(3, Opis);
            stmt.setInt(4, IDApartman);

            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static List<Soba> pregledSoba(Integer IDApartman, String Dolazak, String Odlazak) {
        Connection con = DB.connection;
        List<Soba> listaSoba = new LinkedList<Soba>();

        try {

            CallableStatement cstmt = con.prepareCall("{CALL proveraSoba(?,?,?)}");

            cstmt.setInt(1, IDApartman);
            cstmt.setString(2, Dolazak);
            cstmt.setString(3, Odlazak);

            ResultSet rezultat = cstmt.executeQuery();

            while (rezultat.next()) {
                Soba apt = new Soba(rezultat.getInt("IDSoba"), rezultat.getInt("BrOsoba"), rezultat.getInt("RdBroj"), rezultat.getString("Opis"));
                listaSoba.add(apt);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSoba;
    }

    public static List<Rezervacija> pregledRezervacijaProdavac() {
        Connection con = DB.connection;
        List<Rezervacija> listaSoba = new LinkedList<Rezervacija>();

        try {

            CallableStatement cstmt = con.prepareCall("{CALL prelistavanjeRezervacijaProdavac(?)}");

            cstmt.setInt(1, ID);

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
