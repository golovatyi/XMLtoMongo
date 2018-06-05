package xmltomongo.gui;

import xmltomongo.FileParser;

/**
 *
 * @author rootsu
 */
public class FileSelector extends javax.swing.JFrame{

    /**
     * Creates new form FileSelector
     */

    
    public FileSelector() {
        initComponents();
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adress = new javax.swing.JTextField();
        approveAdress = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adress.setText("/home/rootsu/Desktop/XML");

        approveAdress.setText("OK");
        approveAdress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                approveAdressMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adress, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(approveAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(approveAdress)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void approveAdressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approveAdressMouseClicked
        String folder; 
        try{
            folder = adress.getText();
            FileParser fileParser = new FileParser(folder);
        }
//        catch(NullPointerException e){
//            
//            adress.setText("/home");
//        }
        catch(Exception e){System.out.println(e + "folder" + adress.getText());}
        
        
        
    }//GEN-LAST:event_approveAdressMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adress;
    private javax.swing.JButton approveAdress;
    // End of variables declaration//GEN-END:variables
}
