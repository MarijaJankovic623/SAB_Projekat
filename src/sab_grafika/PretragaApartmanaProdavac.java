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

/**
 *
 * @author Marija
 */
public class PretragaApartmanaProdavac extends javax.swing.JPanel {

    private SAB_Projekat Home;

    /**
     * Creates new form Apartman
     */
    public PretragaApartmanaProdavac(SAB_Projekat Home) {
        initComponents();
        this.Home = Home;

        List<Apartman> apartmani = Prodavac.pregledApartmana();

        if (apartmani.size()>0) {

            String ispis = "";
            for (int i = 0; i < apartmani.size(); i++) {
                ispis += "\n"+ apartmani.get(i).getIDApartman() +".  Naziv:    " + apartmani.get(i).getNaziv() + "    Adresa:    " + apartmani.get(i).getUlicaIBroj() + "\n";

            }
            this.jTextPane1.setText(Prodavac.getID() + "");
            this.jTextPane1.setText(ispis);
        }
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

        setMinimumSize(new java.awt.Dimension(1600, 600));

        jScrollPane1.setViewportView(jTextPane1);

        ImeApartmana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImeApartmanaActionPerformed(evt);
            }
        });

        jLabel3.setText("Unesite redni broj apartmana za kog zelite da vidite rezervacije");

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
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Detalji)
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImeApartmana, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(1061, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Detalji)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImeApartmana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ImeApartmanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImeApartmanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImeApartmanaActionPerformed

    private void DetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetaljiActionPerformed
        if (this.ImeApartmana.getText().isEmpty()) {
            return;
        }
        
        Integer IDApartmana = Integer.parseInt(this.ImeApartmana.getText());
        Apartman apt  = Apartman.dohvatiApartman(IDApartmana);
        
        if (apt == null) {
            this.Home.Switch(new PretragaApartmanaProdavac(this.Home));
            this.ImeApartmana.setText("Niste uneli validan redni broj apartmana");
        }
        else{
        this.Home.Switch(new UredjivanjeApartmana(this.Home, IDApartmana));
        }
    }//GEN-LAST:event_DetaljiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Detalji;
    private javax.swing.JTextField ImeApartmana;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
