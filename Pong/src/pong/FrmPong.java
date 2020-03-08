package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Moreano
 */
public class FrmPong extends javax.swing.JFrame implements KeyListener
{

    int pelotaX = 495;
    int pelotaY = 230;
    int signo = 1;
    int signo1 = 1;
    int pale1 = 200;
    int pale2 = 200;
    int puntajeDer = 0;
    int puntajeIzq = 0;
    
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e)
    {
       System.out.println(e.getKeyCode());//imprimir codigos ascii en pantalla
       if(e.getKeyCode() == 87)
       {
           pale1-=2;
       }
       if(e.getKeyCode() == 83)
       {
           pale1+=2;
       }
       if(e.getKeyCode() == 79)
       {
           pale2-=2;
       }
       if(e.getKeyCode() == 75)
       {
           pale2+=2;
       }
       
    }

    Timer temporizador = new Timer(10, new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            //Moviemiento de pelota
            pelotaX += signo*1;
            pelotaY += signo1*1;
//            if(pelotaX <= 60 ||  pelotaX >= 910)
//            {
//                signo*=-1;
//            }
            if(pelotaY <= 60 || pelotaY >= 430)
            {
                signo1*=-1;
            }
            
            //Condicion para rebote paleta 1:
            if((pelotaX <= 80) && (pelotaY >= pale1) && (pelotaY <= pale1+80))
            {
                signo*=-1;
            }
            //Condicion para el rebote paleta 2:
            if((pelotaX >= 910) && (pelotaY >= pale2) && (pelotaY <= pale2+80))
            {
                signo*=-1;              
            }
            //Para que salda de la mitad:
            if(pelotaX >= 960)
            {
                pelotaX = 495;
                pelotaY = 230;
                signo *= -1;
            }
            repaint();
            if(pelotaX <= 30)
            {
                pelotaX = 495;
                pelotaY = 230;
                signo *= -1;
            }
            
            
            
            repaint();
        }
      
        
    });
    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.yellow);
        g.drawLine(80, 60, 80, 460);
        g.drawLine(940,60,940,460);
        g.setColor(new Color(10,80,10));
        g.fillRect(60, 60, 900, 400);
        g.setColor(Color.white);
        g.drawLine(510, 60, 510, 460);  
        g.fillOval(480,230,60,60);
        g.setColor(Color.black);
        g.fillOval(pelotaX, pelotaY, 30, 30);
        g.fillRect(60, pale1, 20, 80);
        g.fillRect(940, pale2, 20, 80);
          
    }
    public FrmPong()
    {
        initComponents();
        addKeyListener(this);    
    }
    

    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPunDer = new javax.swing.JLabel();
        lblPunIzq = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblPunDer.setPreferredSize(new java.awt.Dimension(100, 50));

        lblPunIzq.setPreferredSize(new java.awt.Dimension(100, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(lblPunIzq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                .addComponent(lblPunDer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(375, 375, 375))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPunIzq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPunDer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(499, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        temporizador.start();
        lblPunIzq.setText(String.valueOf(puntajeIzq));
        lblPunDer.setText(String.valueOf(puntajeDer));
    }//GEN-LAST:event_formWindowOpened


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblPunDer;
    private javax.swing.JLabel lblPunIzq;
    // End of variables declaration//GEN-END:variables
}
