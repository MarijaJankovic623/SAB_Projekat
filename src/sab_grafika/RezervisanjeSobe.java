/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sab_grafika;

import java.awt.BorderLayout;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ScrollPaneLayout;
import sab_implementacija.Apartman;
import sab_implementacija.Kupac;
import sab_implementacija.Soba;

/**
 *
 * @author Marija
 */
public class RezervisanjeSobe extends javax.swing.JPanel {

    private SAB_Projekat Home;
    private Integer IDApartman;
    private String Od;
    private String Do;

    /**
     * Creates new form Apartman
     */
    public RezervisanjeSobe(SAB_Projekat Home, Integer IDApartman) {
        initComponents();
        this.Home = Home;
        this.IDApartman = IDApartman;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Pretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        RBSobe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Rezervisi = new javax.swing.JButton();
        VremeOd = new org.jdesktop.swingx.JXDatePicker();
        VremeDo = new org.jdesktop.swingx.JXDatePicker();

        setMinimumSize(new java.awt.Dimension(1600, 600));

        jLabel1.setText("Vreme prijavljivanje");

        jLabel2.setText("Vreme odjavljivanje");

        Pretrazi.setText("Pretrazi");
        Pretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PretraziActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        RBSobe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBSobeActionPerformed(evt);
            }
        });

        jLabel3.setText("Unesite redni broj sobe");

        Rezervisi.setText("Rezervisi");
        Rezervisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RezervisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(RBSobe, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rezervisi)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pretrazi)
                            .addComponent(VremeOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VremeDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(1240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(VremeOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(VremeDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Pretrazi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RBSobe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rezervisi)
                .addContainerGap(198, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PretraziActionPerformed
        Apartman apt = Apartman.dohvatiApartman(IDApartman);
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.Od = formatter.format(this.VremeOd.getDate());
        this.Do = formatter.format(this.VremeDo.getDate());

        List<Soba> sobe = Soba.slobodneSobe(IDApartman, Od, Do);
        String ispis = apt.toString();
        for (int i = 0; i < sobe.size(); i++) {
            ispis += sobe.get(i).toString() + "\n";
        }

        this.jTextPane1.setText(ispis);


    }//GEN-LAST:event_PretraziActionPerformed

    private void RezervisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RezervisiActionPerformed
        Integer IDSoba = Soba.dohvatiIDSobe(Integer.parseInt(this.RBSobe.getText()), IDApartman);
        if (IDSoba != 0) {
            Soba.rezervisiSobu(IDSoba, Kupac.getID(), Od, Do);
            this.Home.Switch(new PregledRezervacijaKupac(this.Home));
        } else {
            this.RBSobe.setText("Niste uneli validan broj sobe");
        }
    }//GEN-LAST:event_RezervisiActionPerformed

    private void RBSobeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBSobeActionPerformed

    }//GEN-LAST:event_RBSobeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pretrazi;
    private javax.swing.JTextField RBSobe;
    private javax.swing.JButton Rezervisi;
    private org.jdesktop.swingx.JXDatePicker VremeDo;
    private org.jdesktop.swingx.JXDatePicker VremeOd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
