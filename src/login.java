
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;

public class login extends javax.swing.JFrame {
    int tipo = 0;
    
    public login() {
        initComponents();
        
        GraphicsDevice Gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = Gd.getDisplayMode().getWidth();
        int height = Gd.getDisplayMode().getHeight();
        this.setSize(width,height);
        Color azul = new Color(111, 115, 210); // Color azul
        this.getContentPane().setBackground(azul); //Cambiar color de fondo
        setExtendedState(MAXIMIZED_BOTH); //this.setExtendedState(MAXIMIZED_BOTH); //Tamaño
        
        
    }
    
    public void conectar(){
        String BD = "jdbc:postgresql://localhost:5432/Proyecto";
        String usuario = "postgres";
        String contra = "AD41uq6&";
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(BD, usuario, contra);
            JOptionPane.showMessageDialog(null, "Base de datos conectada");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar" + e);
        
        }
    }
    
    public void LogIn(){
        String BD = "jdbc:postgresql://localhost:5432/Proyecto";
        String usuario = "postgres";
        String contra = "AD41uq6&";
        Connection conn = null;
        String user, pass;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(BD, usuario, contra);
            java.sql.Statement st = conn.createStatement();
            
            String sql = "select * from usuario";
            ResultSet res = st.executeQuery(sql);
            
            while(res.next()){
                user = res.getString("username");
                pass = res.getString("contra");
                if(user.equals(txtuser.getText()) && pass.equals(String.valueOf(txtpass.getPassword()))){
                    tipo = Integer.parseInt(res.getString("tipo"));
                }
            }
            st.executeUpdate(sql);
            conn.close();
            st.close();
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error " + e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lbllogin = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, -1, -1));

        txtuser.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 291, 48));
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, 291, 48));

        jButton1.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 55, 87));
        jButton1.setText("Iniciar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 178, 44));

        lbllogin.setFont(new java.awt.Font("Microsoft YaHei", 1, 40)); // NOI18N
        lbllogin.setForeground(new java.awt.Color(255, 255, 255));
        lbllogin.setText("INICIAR SESIÓN");
        getContentPane().add(lbllogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        panel1.setBackground(new java.awt.Color(111, 115, 210));
        panel1.setForeground(new java.awt.Color(111, 115, 110));
        panel1.setToolTipText("");
        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 290, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String valorPass = new String(txtpass.getPassword());
        if(txtuser.getText().isEmpty() || valorPass.isEmpty()){
                JOptionPane.showMessageDialog(null, "Ningun campo puede quedar vacio");
        }else{
            LogIn();
            switch(tipo){
                case 0:
                    JOptionPane.showMessageDialog(null, "Username o Contraseña incorrecta");
                    txtuser.setText(null);
                    txtpass.setText(null);
                    break;
                case 1:
                    empleados ven=new empleados();
                    ven.setVisible(true);
                    dispose();
                    break;
                case 2:
                    clientes cont=new clientes();
                    cont.setVisible(true);
                    dispose();
                    break;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbllogin;
    private javax.swing.JPanel panel1;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
