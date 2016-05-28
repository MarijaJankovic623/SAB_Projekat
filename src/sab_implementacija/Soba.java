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
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    public static List<Soba> slobodneSobe(Integer IDApartman,String DatumOd, String DatumDo){
    Connection con = DB.connection;
        List<Soba> listaSoba = new LinkedList<Soba>();

        try {

            CallableStatement cstmt = con.prepareCall("{CALL proveraSoba(?,?,?)}");

            cstmt.setInt(1, IDApartman);
            cstmt.setString(2, DatumOd);
            cstmt.setString(3, DatumDo);
            

            ResultSet rezultat = cstmt.executeQuery();

            while (rezultat.next()) {
                Soba soba = new Soba(rezultat.getInt("IDSoba"), rezultat.getInt("BrOsoba"), rezultat.getInt("RdBroj"), rezultat.getString("Opis"));
                listaSoba.add(soba);

            }
            
            

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSoba;     
    
    
    }
    
    public static Integer  dohvatiIDSobe(Integer RedniBroj, Integer IDApartman){
    
    
    
        Connection con = DB.connection;
        Integer ID = 0;

        String SQLStm = "SELECT IDSoba FROM Soba WHERE RdBroj = ? AND IDApartman = ?";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(SQLStm);

            stmt.setInt(1, RedniBroj);
            stmt.setInt(2, IDApartman);

            ResultSet rezultat = stmt.executeQuery();
            rezultat.next();
            ID = rezultat.getInt("IDSoba");

        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ID;
    

    
    }
    
    
        
    
    public static void rezervisiSobu(Integer IDSoba, Integer IDKupac, String VremeOd,String VremeDo){
        Connection con = DB.connection;
        Integer ID = 0;

        String SQLStm = "INSERT INTO Rezervacija(IDSoba,DatumPrijave,DatumOdjave,IDKupac) VALUES(?,?,?,?)";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(SQLStm);

            stmt.setInt(1, IDSoba);
            stmt.setString(2, VremeOd);
            stmt.setString(3, VremeDo);
            stmt.setInt(4, IDKupac);

            stmt.execute();



        } catch (SQLException ex) {
            Logger.getLogger(Prodavac.class.getName()).log(Level.SEVERE, null, ex);
        }
 
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
