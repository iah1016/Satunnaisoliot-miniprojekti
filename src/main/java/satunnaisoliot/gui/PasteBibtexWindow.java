/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satunnaisoliot.gui;

import satunnaisoliot.util.BibtexParser;

/**
 *
 * @author jambo
 */
public class PasteBibtexWindow extends javax.swing.JFrame {

    /**
     * Creates new form pasteBibtexWindow
     */
    FormController fc;

    public PasteBibtexWindow(FormController fc) {
        this.fc = fc;
        initComponents();
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
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Give reference in Bibtex format");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Add reference");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BibtexParser parser = new BibtexParser(this.jTextArea1.getText());

        if (parser.typeIsArticle()) {

            fc.saveArticle(parser.getBibkey(), parser.getAuthor(), parser.getTitle(),
                    parser.getJournal(), parser.getYear(), parser.getVolume(),
                    parser.getNumber(), parser.getPages(), parser.getMonth(),
                    parser.getNote(), parser.getKey());
        } else if (parser.typeIsBoook()) {
            fc.saveBook(parser.getBibkey(), parser.getAuthor(), parser.getTitle(),
                    parser.getPublisher(), parser.getYear(), parser.getVolume(),
                    parser.getSeries(), parser.getAddress(), parser.getMonth(),
                    parser.getNote(), parser.getKey());
        } else if (parser.typeIsProceedings()) {
            fc.saveProceeding(parser.getBibkey(), parser.getTitle(), parser.getYear(),
                    parser.getEditor(), parser.getVolume(), parser.getSeries(),
                    parser.getAddress(), parser.getMonth(), parser.getPublisher(),
                    parser.getOrganization(), parser.getNote(), parser.getKey());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void showForm() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
