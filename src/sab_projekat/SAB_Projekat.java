/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sab_projekat;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import sab_implementacija.*;

/**
 *
 * @author Marija
 */
public class SAB_Projekat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        DB base = new DB();
       //Prodavac.registracijaProdavca("MJ", "1234","@gmail","063","marija","jankovic","1234POS"); ->>>>>> JOS UVEK NEMA PROVERA ZA UNIQUE I VALIDNE PODATKE
        //Kupac.registracijaKupca("MJ", "1234","@gmail","063","marija","jankovic","1234POS");
        // System.out.print(Prodavac.prijavljivanjeProdavca("MJJ", "1234"));
        //  System.out.print(Kupac.prijavljivanjeKupca("MJ", "1234"));
        // System.out.print(Prodavac.dohvatiIDProdavca("MJ"));
        //System.out.print( Prodavac.pregledApartmana(Prodavac.dohvatiIDProdavca("MJ")));
        //System.out.print( Prodavac.pregledApartmanaDrzava("Srbija"));
        //System.out.print( Prodavac.pregledApartmanaDrzavaGrad("Srbija", "Beograd"));

        //Prodavac.DodajApartman("Marko", "Rusija", "Lipeck", "bla bla bla", "PRELJEPOTICA", 2);
        //Prodavac.DodajSobu(2, 1, "Prelepa", 2);
        //Kupac.uredjivanjePodatakaKupca("MJ", "4321", "@gmail", "064", "Marija", "Jankovic", "POS");
        //Prodavac.RezervisiSobu(1, 1, "2013-03-02", "2013-04-02");
        //System.out.print( Prodavac.pregledSoba(1, "2013-01-01", "2013-02-01"));
        //Prodavac.RezervisiSobu(2, 2, "2013-03-02", "2013-04-02");Prodavac.RezervisiSobu(2, 2, "2013-03-02", "2013-04-02");
        //System.out.println( Prodavac.pregledRezervacijaProdavac(2));
        //System.out.println(Kupac.pregledRezervacijaKupac(2));

    }

}
