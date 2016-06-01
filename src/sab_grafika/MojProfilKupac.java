/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sab_grafika;

import java.util.List;
import javax.swing.JFrame;
import sab_implementacija.Kupac;
import sab_implementacija.Prodavac;

/**
 *
 * @author Marija
 */
public class MojProfilKupac extends javax.swing.JPanel {

    private SAB_Projekat Home;

    /**
     * Creates new form RegistracijaKupca
     */
    public MojProfilKupac(SAB_Projekat Home) {
        initComponents();
        this.Home = Home;
        List<String> informacije = Kupac.dohvatiKupca();
        BrKredKart.setText(informacije.get(0));
        BrojTelefona.setText(informacije.get(1));
        Email.setText(informacije.get(2));
        KorisnickoIme.setText(informacije.get(3));
        Lozinka.setText(informacije.get(4));
                Ime.setText(informacije.get(5));
        Prezime.setText(informacije.get(6));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KorisnickoIme = new javax.swing.JTextField();
        BrojTelefona = new javax.swing.JTextField();
        Ime = new javax.swing.JTextField();
        Prezime = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Lozinka = new javax.swing.JPasswordField();
        BrKredKart = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Izmeni = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1600, 600));

        BrojTelefona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrojTelefonaActionPerformed(evt);
            }
        });

        Ime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImeActionPerformed(evt);
            }
        });

        Prezime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrezimeActionPerformed(evt);
            }
        });

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        Lozinka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LozinkaActionPerformed(evt);
            }
        });

        jLabel1.setText("Korisnicko ime");

        jLabel2.setText("Lozinka");

        jLabel3.setText("Ime");

        jLabel4.setText("Prezime");

        jLabel5.setText("Email");

        jLabel6.setText("Broj telefona");

        jLabel7.setText("Broj kreditne kartice");

        Izmeni.setText("Izmeni podatke");
        Izmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Izmeni)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Email, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Prezime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lozinka, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KorisnickoIme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addComponent(BrKredKart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Prezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(BrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(BrKredKart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(Izmeni)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void IzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IzmeniActionPerformed

        if (Kupac.uredjivanjePodatakaKupca(this.Lozinka.getText(), this.Email.getText(), this.BrojTelefona.getText(), this.Ime.getText(), this.Prezime.getText(), this.BrKredKart.getText())) {
            this.Home.Switch(new PretragaApartmanaLokacija(this.Home));
        } else {
            this.Home.Switch(new MojProfilKupac(this.Home));
        }
    }//GEN-LAST:event_IzmeniActionPerformed

    private void ImeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImeActionPerformed

    private void PrezimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrezimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrezimeActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void BrojTelefonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrojTelefonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BrojTelefonaActionPerformed

    private void LozinkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LozinkaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LozinkaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BrKredKart;
    private javax.swing.JTextField BrojTelefona;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Ime;
    private javax.swing.JButton Izmeni;
    private javax.swing.JTextField KorisnickoIme;
    private javax.swing.JPasswordField Lozinka;
    private javax.swing.JTextField Prezime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
