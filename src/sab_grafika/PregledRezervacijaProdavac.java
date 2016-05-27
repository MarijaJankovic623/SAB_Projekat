/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sab_grafika;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.ScrollPaneLayout;
import sab_implementacija.Apartman;
import sab_implementacija.Kupac;
import sab_implementacija.Prodavac;
import sab_implementacija.Rezervacija;

/**
 *
 * @author Marija
 */
public class PregledRezervacijaProdavac extends javax.swing.JPanel {

    private SAB_Projekat Home;

    /**
     * Creates new form Apartman
     */
    public PregledRezervacijaProdavac(SAB_Projekat Home) {
        initComponents();
        this.Home = Home;

        List<Rezervacija> rezervacije = null;

        rezervacije = Prodavac.pregledRezervacijaProdavac();

        String ispis = "";
        for (int i = 0; i < rezervacije.size(); i++) {
            ispis += rezervacije.get(0).toString() + "\n";
        }
        this.jTextPane1.setText(Prodavac.getID()+ "");        this.jTextPane1.setText(ispis);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        ImeApartmana = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Detalji = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        ImeApartmana.setText("jTextField1");
        ImeApartmana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImeApartmanaActionPerformed(evt);
            }
        });

        jLabel3.setText("Naziv apartmana");

        Detalji.setText("Detaljnije");
        Detalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(ImeApartmana, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel3)))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Detalji)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ImeApartmana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Detalji)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ImeApartmanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImeApartmanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImeApartmanaActionPerformed

    private void DetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetaljiActionPerformed
        Integer IDApartmana = Apartman.dohvatiIDApartmana(this.ImeApartmana.getText());
        this.jTextPane1.setText(IDApartmana + "");
        //this.Home.Switch(new ApartmanDetaljnoPanel(this.Home, IDApartman));
    }//GEN-LAST:event_DetaljiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Detalji;
    private javax.swing.JTextField ImeApartmana;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
