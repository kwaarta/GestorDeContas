package GerenciadorDeContas;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duane Lopes <duwaynelopez@gmail.com>
 * @version 1.0
 */

public class Main extends javax.swing.JFrame {
int Token;
String Auth;
Conta conta = null;
Usuario user = null;
ControlDAO control = null;
DefaultTableModel tabelaconta = null;
ArrayList <Conta>   contas    = new ArrayList<>();
ArrayList <Integer> vectorid  = new ArrayList<>();

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPMain = new javax.swing.JPanel();
        JPrincipal = new javax.swing.JPanel();
        JPBanner = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JPBody = new javax.swing.JPanel();
        jbcriar = new javax.swing.JButton();
        jbentrar = new javax.swing.JButton();
        JPCadastro = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        JTCriarUsername = new javax.swing.JTextField();
        jbcriar_conta = new javax.swing.JButton();
        JLCadastroVoltar = new javax.swing.JLabel();
        JTCriarConfirmarPassword = new javax.swing.JPasswordField();
        JTCriarPassword = new javax.swing.JPasswordField();
        JPBanner4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JPLogin = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        JTLoginUsername = new javax.swing.JTextField();
        jbLogin = new javax.swing.JButton();
        JLLoginVoltar = new javax.swing.JLabel();
        JTLoginPassword = new javax.swing.JPasswordField();
        JPBanner5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        JPManager = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        JPConta = new javax.swing.JPanel();
        JTManagerUsername = new javax.swing.JTextField();
        JTManagerEmail = new javax.swing.JTextField();
        JBAdicionarConta = new javax.swing.JButton();
        JBActualizar_Conta = new javax.swing.JButton();
        JTManagerSite = new javax.swing.JTextField();
        JTManagerPassword = new javax.swing.JPasswordField();
        JPListaContas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTTabelaContas = new javax.swing.JTable();
        JBEditar_Conta = new javax.swing.JButton();
        JBEliminar_Conta = new javax.swing.JButton();
        JPBanner6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMMenuPrincipal = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GERENCIADOR DE CONTAS");
        setResizable(false);

        JPMain.setPreferredSize(new java.awt.Dimension(746, 600));
        JPMain.setLayout(new java.awt.CardLayout());

        JPBanner.setBackground(new java.awt.Color(204, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("G E R E N C I A D O R  DE  C O N T AS");

        javax.swing.GroupLayout JPBannerLayout = new javax.swing.GroupLayout(JPBanner);
        JPBanner.setLayout(JPBannerLayout);
        JPBannerLayout.setHorizontalGroup(
            JPBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPBannerLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(77, 77, 77))
        );
        JPBannerLayout.setVerticalGroup(
            JPBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPBannerLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(61, 61, 61))
        );

        JPBody.setBackground(new java.awt.Color(255, 255, 255));

        jbcriar.setBackground(new java.awt.Color(204, 204, 204));
        jbcriar.setText("CRIAR UMA CONTA");
        jbcriar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 0, 0)));
        jbcriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcriarActionPerformed(evt);
            }
        });

        jbentrar.setText("ENTRAR NA SUA CONTA");
        jbentrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 0, 0)));
        jbentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbentrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPBodyLayout = new javax.swing.GroupLayout(JPBody);
        JPBody.setLayout(JPBodyLayout);
        JPBodyLayout.setHorizontalGroup(
            JPBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPBodyLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jbcriar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        JPBodyLayout.setVerticalGroup(
            JPBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPBodyLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(JPBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbcriar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(250, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPrincipalLayout = new javax.swing.GroupLayout(JPrincipal);
        JPrincipal.setLayout(JPrincipalLayout);
        JPrincipalLayout.setHorizontalGroup(
            JPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPrincipalLayout.setVerticalGroup(
            JPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPrincipalLayout.createSequentialGroup()
                .addComponent(JPBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPMain.add(JPrincipal, "TelaPrincipal");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        JTCriarUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jbcriar_conta.setBackground(new java.awt.Color(255, 255, 255));
        jbcriar_conta.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jbcriar_conta.setText("C R I A R");
        jbcriar_conta.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 0, 0)));
        jbcriar_conta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcriar_contaActionPerformed(evt);
            }
        });

        JLCadastroVoltar.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        JLCadastroVoltar.setText("V O L T A R");
        JLCadastroVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLCadastroVoltarMouseClicked(evt);
            }
        });

        JTCriarConfirmarPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirmar Password", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 12), new java.awt.Color(204, 0, 0))); // NOI18N

        JTCriarPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 12), new java.awt.Color(204, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTCriarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(JTCriarConfirmarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTCriarUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jbcriar_conta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(JLCadastroVoltar))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(JTCriarUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(JTCriarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(JTCriarConfirmarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbcriar_conta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JLCadastroVoltar)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        JPBanner4.setBackground(new java.awt.Color(204, 0, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("G E R E N C I A D O R  DE  C O N T AS");

        javax.swing.GroupLayout JPBanner4Layout = new javax.swing.GroupLayout(JPBanner4);
        JPBanner4.setLayout(JPBanner4Layout);
        JPBanner4Layout.setHorizontalGroup(
            JPBanner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPBanner4Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(77, 77, 77))
        );
        JPBanner4Layout.setVerticalGroup(
            JPBanner4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPBanner4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel5)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPCadastroLayout = new javax.swing.GroupLayout(JPCadastro);
        JPCadastro.setLayout(JPCadastroLayout);
        JPCadastroLayout.setHorizontalGroup(
            JPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPBanner4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPCadastroLayout.setVerticalGroup(
            JPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPCadastroLayout.createSequentialGroup()
                .addComponent(JPBanner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPMain.add(JPCadastro, "TelaCadastro");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(622, 348));

        JTLoginUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0))); // NOI18N

        jbLogin.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jbLogin.setText("E N T R A R");
        jbLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 0, 0)));
        jbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoginActionPerformed(evt);
            }
        });

        JLLoginVoltar.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        JLLoginVoltar.setText("V O L T A R");
        JLLoginVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLLoginVoltarMouseClicked(evt);
            }
        });

        JTLoginPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 12), new java.awt.Color(204, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(JLLoginVoltar))
                    .addComponent(JTLoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(JTLoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(JTLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JLLoginVoltar)
                .addGap(88, 88, 88))
        );

        JPBanner5.setBackground(new java.awt.Color(204, 0, 0));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("G E R E N C I A D O R  DE  C O N T AS");

        javax.swing.GroupLayout JPBanner5Layout = new javax.swing.GroupLayout(JPBanner5);
        JPBanner5.setLayout(JPBanner5Layout);
        JPBanner5Layout.setHorizontalGroup(
            JPBanner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPBanner5Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(77, 77, 77))
        );
        JPBanner5Layout.setVerticalGroup(
            JPBanner5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPBanner5Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout JPLoginLayout = new javax.swing.GroupLayout(JPLogin);
        JPLogin.setLayout(JPLoginLayout);
        JPLoginLayout.setHorizontalGroup(
            JPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addComponent(JPBanner5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPLoginLayout.setVerticalGroup(
            JPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPLoginLayout.createSequentialGroup()
                .addComponent(JPBanner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
        );

        JPMain.add(JPLogin, "TelaLogin");

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        JPConta.setBackground(new java.awt.Color(255, 255, 255));

        JTManagerUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0))); // NOI18N

        JTManagerEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0))); // NOI18N

        JBAdicionarConta.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        JBAdicionarConta.setText("A D I C I O N A R");
        JBAdicionarConta.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 102), new java.awt.Color(0, 204, 102)));
        JBAdicionarConta.setContentAreaFilled(false);
        JBAdicionarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAdicionarContaActionPerformed(evt);
            }
        });

        JBActualizar_Conta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JBActualizar_Conta.setText("A C T U A L I Z A R");
        JBActualizar_Conta.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 204), new java.awt.Color(0, 153, 204)));
        JBActualizar_Conta.setContentAreaFilled(false);
        JBActualizar_Conta.setEnabled(false);
        JBActualizar_Conta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBActualizar_ContaActionPerformed(evt);
            }
        });

        JTManagerSite.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Site", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0))); // NOI18N

        JTManagerPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 12), new java.awt.Color(204, 0, 0))); // NOI18N

        javax.swing.GroupLayout JPContaLayout = new javax.swing.GroupLayout(JPConta);
        JPConta.setLayout(JPContaLayout);
        JPContaLayout.setHorizontalGroup(
            JPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContaLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(JPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JTManagerUsername)
                    .addComponent(JTManagerEmail)
                    .addComponent(JTManagerSite)
                    .addGroup(JPContaLayout.createSequentialGroup()
                        .addComponent(JBAdicionarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(JBActualizar_Conta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JTManagerPassword))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        JPContaLayout.setVerticalGroup(
            JPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPContaLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(JTManagerUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JTManagerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JTManagerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JTManagerSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAdicionarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBActualizar_Conta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" CONTA", JPConta);

        JPListaContas.setBackground(new java.awt.Color(255, 255, 255));
        JPListaContas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                JPListaContasComponentShown(evt);
            }
        });

        JTTabelaContas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JTTabelaContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USUARIO", "EMAIL", "PASSWORD", "SITE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTTabelaContas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTTabelaContas.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(JTTabelaContas);
        if (JTTabelaContas.getColumnModel().getColumnCount() > 0) {
            JTTabelaContas.getColumnModel().getColumn(0).setResizable(false);
            JTTabelaContas.getColumnModel().getColumn(1).setResizable(false);
            JTTabelaContas.getColumnModel().getColumn(2).setResizable(false);
            JTTabelaContas.getColumnModel().getColumn(3).setResizable(false);
        }

        JBEditar_Conta.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        JBEditar_Conta.setText("E D I T A R");
        JBEditar_Conta.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 102, 255), new java.awt.Color(51, 153, 255)));
        JBEditar_Conta.setContentAreaFilled(false);
        JBEditar_Conta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditar_ContaActionPerformed(evt);
            }
        });

        JBEliminar_Conta.setBackground(new java.awt.Color(255, 0, 0));
        JBEliminar_Conta.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        JBEliminar_Conta.setText("E L I M I N A R");
        JBEliminar_Conta.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.red, java.awt.Color.red));
        JBEliminar_Conta.setContentAreaFilled(false);
        JBEliminar_Conta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminar_ContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPListaContasLayout = new javax.swing.GroupLayout(JPListaContas);
        JPListaContas.setLayout(JPListaContasLayout);
        JPListaContasLayout.setHorizontalGroup(
            JPListaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPListaContasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBEditar_Conta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(JBEliminar_Conta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JPListaContasLayout.setVerticalGroup(
            JPListaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPListaContasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPListaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBEliminar_Conta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBEditar_Conta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("LISTA CONTAS", JPListaContas);

        JPBanner6.setBackground(new java.awt.Color(204, 0, 0));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("G E R E N C I A D O R  DE  C O N T AS");

        javax.swing.GroupLayout JPBanner6Layout = new javax.swing.GroupLayout(JPBanner6);
        JPBanner6.setLayout(JPBanner6Layout);
        JPBanner6Layout.setHorizontalGroup(
            JPBanner6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPBanner6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(77, 77, 77))
        );
        JPBanner6Layout.setVerticalGroup(
            JPBanner6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPBanner6Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout JPManagerLayout = new javax.swing.GroupLayout(JPManager);
        JPManager.setLayout(JPManagerLayout);
        JPManagerLayout.setHorizontalGroup(
            JPManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(JPBanner6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPManagerLayout.setVerticalGroup(
            JPManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPManagerLayout.createSequentialGroup()
                .addComponent(JPBanner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        JPMain.add(JPManager, "TelaManager");

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        JMMenuPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        JMMenuPrincipal.setText("Menu Principal");
        JMMenuPrincipal.setEnabled(false);
        JMMenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JMMenuPrincipalMouseClicked(evt);
            }
        });
        jMenuBar1.add(JMMenuPrincipal);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbcriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcriarActionPerformed
//        Esse botão chama a tela de cadastro ao ser clicado
        JTCriarUsername.setText("");
        JTCriarPassword.setText("");
        JTCriarConfirmarPassword.setText("");
        CardLayout jpmain = (CardLayout) JPMain.getLayout();
        jpmain.show(JPMain,"TelaCadastro");
    }//GEN-LAST:event_jbcriarActionPerformed

    private void jbentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbentrarActionPerformed
//        Esse botão chama a tela de Login ao ser clicado
        CardLayout jpmain = (CardLayout) JPMain.getLayout();
        jpmain.show(JPMain,"TelaLogin");
    }//GEN-LAST:event_jbentrarActionPerformed

    private void JLCadastroVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLCadastroVoltarMouseClicked
//        Esse Label chama a tela Principal ao ser clicado
        CardLayout jpmain = (CardLayout) JPMain.getLayout();
        jpmain.show(JPMain,"TelaPrincipal");
    }//GEN-LAST:event_JLCadastroVoltarMouseClicked

    private void JLLoginVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLLoginVoltarMouseClicked
//        Esse Label chama a tela Principal ao ser clicado    
        JTLoginUsername.setText("");
        JTLoginPassword.setText("");
        CardLayout jpmain = (CardLayout) JPMain.getLayout();
        jpmain.show(JPMain,"TelaPrincipal");
    }//GEN-LAST:event_JLLoginVoltarMouseClicked

    private void jbcriar_contaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcriar_contaActionPerformed
//        Verifica se todos os campos estão preenchidos, se o tamanho da senha esta no intervalo de carateres e se 
//        os campos de senha conscidem, se for tudo verdade cria a nova conta e adiciona o usuario na base de dados
        if( JTCriarUsername.getText().equals("") || JTCriarPassword.getPassword().equals("") || 
            JTCriarConfirmarPassword.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "Preenche todos os campos");
        }else if(!(JTCriarPassword.getPassword().length >= 8) || !(JTCriarPassword.getPassword().length <= 64) ){
            JOptionPane.showMessageDialog(null, "Senha de 8 a 64 caracteres");
        }else if(!String.valueOf(JTCriarPassword.getPassword()).equals(String.valueOf(JTCriarConfirmarPassword.getPassword()))){
            JOptionPane.showMessageDialog(null, "Senhas não conscidem");
        }else{
            user = new Usuario();
            control = new ControlDAO();
            user.setNome(JTCriarUsername.getText());
            user.setPassword(String.valueOf(JTCriarPassword.getPassword()));
            if(control.VerificaNome(user.getNome())){ /**verfica Se ja existe algum usuario com esse nome*/
                 JOptionPane.showMessageDialog(null, "Esse usuario ja existe, Tenta outro nome!");
            }else{    
                if(!control.CreateTable(user)){ /**verfica Se existe algum erro ao criar as tabelas no banco de dados*/
                    JOptionPane.showMessageDialog(null, "Erro ao conectar a base de dados, tente novamente!");
                }else{
                    if(!control.InsertUser(user)){ /**verfica Se ja existe algum erro ao adicionar o usuario na tabela */
                            JOptionPane.showMessageDialog(null, "Erro ao cadastrar, tente novamente!");
                            JTCriarUsername.setText("");
                            JTCriarPassword.setText("");
                            JTCriarConfirmarPassword.setText("");
                    }else{ /**Se tudo estiver correcto então*/
                        JOptionPane.showMessageDialog(null, "Usuario Registrado com sucesso!");
                        JTCriarUsername.setText("");
                        JTCriarPassword.setText("");
                        JTCriarConfirmarPassword.setText("");
                    }
                }
            }
        }
    }//GEN-LAST:event_jbcriar_contaActionPerformed

    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoginActionPerformed
//      Verifica se todos os campos estão preenchidos e se o tamanho da senha esta no intervalo de carateres 
//      se for verdade faz Login na conta registrada
        if(JTLoginUsername.getText().equals("") || JTLoginPassword.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }else if(!(JTLoginPassword.getPassword().length >= 8) || !(JTLoginPassword.getPassword().length <= 64) ){
            JOptionPane.showMessageDialog(null, "Senha de 8 a 64 caracteres");
        }else{
            user = new Usuario();
            control = new ControlDAO();
            user.setNome(JTLoginUsername.getText());
            user.setPassword(String.valueOf(JTLoginPassword.getPassword()));
            if(control.ExisteDatabase(JTLoginUsername.getText())){ /**verfica Se existe uma conta com esse usuario*/
//                retorna os dados do usuario
                user = control.SelectUser(user); 
                if(user != null){
                     JOptionPane.showMessageDialog(null, "Login efectuado com sucesso");
//                     Esse token é usado para passar o id do usuario e adicionar quando registrar um conta
                     Token = user.getIduser(); 
//                     Usado para passar o nome do usuario e usa-lo para passar para o connect
                     Auth = JTLoginUsername.getText(); 
                     CardLayout jpmain = (CardLayout) JPMain.getLayout();
                     jpmain.show(JPMain,"TelaManager");
                     JMMenuPrincipal.setEnabled(true);
                     JTLoginUsername.setText("");
                     JTLoginPassword.setText("");
                }else{
                     JOptionPane.showMessageDialog(null, "Senha ou username invalido, tente novamente");
                }   
            }else{
                JOptionPane.showMessageDialog(null, "Usuario inexistente, cria uma conta!");
            }
            
        }  
    }//GEN-LAST:event_jbLoginActionPerformed

    private void JMMenuPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMMenuPrincipalMouseClicked
//        Esse botão chama a tela principal ao ser clicado
//        E apaga as linhas da tabela listarcontas para que outro usuario ao fazer login
//        não visualize os dados do usuario anterior
        JMMenuPrincipal.setEnabled(false);
        jTabbedPane1.setSelectedIndex(0);
        tabelaconta = (DefaultTableModel) JTTabelaContas.getModel();
        if(tabelaconta.getRowCount() > 0){
            for (int i = tabelaconta.getRowCount()-1; 0 < tabelaconta.getRowCount(); i--) {
                tabelaconta.removeRow(i);
            }
        }
        CardLayout jpmain = (CardLayout) JPMain.getLayout();
        jpmain.show(JPMain,"TelaPrincipal");
        JTManagerUsername.setText("");
        JTManagerPassword.setText("");
        JTManagerEmail.setText("");
        JTManagerSite.setText("");
    }//GEN-LAST:event_JMMenuPrincipalMouseClicked

    private void JBAdicionarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAdicionarContaActionPerformed
//      Verifica se todos os campos estão preenchidos, se estiverem então adiciona um nova conta
        if( JTManagerUsername.getText().equals("") || JTManagerEmail.getText().equals("") || JTManagerPassword.getPassword().equals("") || 
                JTManagerSite.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preenche todos os campos");
        }else{
            conta = new Conta();
            control = new ControlDAO();
            conta.setUsername(JTManagerUsername.getText());
            conta.setEmail(JTManagerEmail.getText());
            conta.setPassword(String.valueOf(JTManagerPassword.getPassword()));
            conta.setSite(JTManagerSite.getText());
            conta.setId_user(Token);
            if(!control.InsertConta(conta,Auth)){ /**Verifica se existem algum erro ao adicionar a conta*/
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar conta, tente novamente!");
                    JTManagerUsername.setText("");
                    JTManagerPassword.setText("");
                    JTManagerEmail.setText("");
                    JTManagerSite.setText("");
            }else{/**Se estiver tudo certo, então...*/
                JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso!");
                JTManagerUsername.setText("");
                JTManagerPassword.setText("");
                JTManagerEmail.setText("");
                JTManagerSite.setText("");
            }
        }    
    }//GEN-LAST:event_JBAdicionarContaActionPerformed

    private void JPListaContasComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_JPListaContasComponentShown
//        Chama o metodo ListarConta
        ListaConta();
    }//GEN-LAST:event_JPListaContasComponentShown

    private void JBEliminar_ContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminar_ContaActionPerformed
//        Verifica se existe alguma linha da tabela selecionada, existe então elimina essa conta
        if(JTTabelaContas.getSelectedRow() >= 0){
//            O id da conta a ser elimina é achada, pelo posicao que a conta se encontra na tabela, 
//            que é passada para o vector que retorna o valor que estiver nessa mesma posicao
            int id = vectorid.get(JTTabelaContas.getSelectedRow());
            control = new ControlDAO();
            if(!control.DeleteConta(Auth, id)){ /**Verifica se exite algum erro ao eliminar a conta*/
                 JOptionPane.showMessageDialog(null, "Erro ao Eliminar a conta, verifique a base de dados ou se existe essa conta!");
                 
            }else{ /**Se estiver tudo certo, então...*/
                JOptionPane.showMessageDialog(null, "Conta Eliminada com sucesso!");
//                o id da conta da conta é removido tambem do vector,
//                e em seguida é actualizada a lista chamando o metodo ListarConta
                vectorid.remove(JTTabelaContas.getSelectedRow());
                ListaConta();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleciona uma Conta para ser Eliminada!");
        }
    }//GEN-LAST:event_JBEliminar_ContaActionPerformed

    private void JBEditar_ContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditar_ContaActionPerformed
//        Verifica se existe alguma linha da tabela selecionada, existe então os dados de cada
//        coluna vão para os seus respectivos campos na aba conta para ser editado
        if(JTTabelaContas.getSelectedRow() >= 0){
            JTManagerUsername.setText(JTTabelaContas.getValueAt(JTTabelaContas.getSelectedRow(), 0).toString());
            JTManagerEmail.setText(JTTabelaContas.getValueAt(JTTabelaContas.getSelectedRow(), 1).toString());
            JTManagerPassword.setText(JTTabelaContas.getValueAt(JTTabelaContas.getSelectedRow(), 2).toString());
            JTManagerSite.setText(JTTabelaContas.getValueAt(JTTabelaContas.getSelectedRow(), 3).toString());
            jTabbedPane1.setSelectedIndex(0);
            JBActualizar_Conta.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Seleciona a Conta para ser Editada!");
        }
    }//GEN-LAST:event_JBEditar_ContaActionPerformed

    private void JBActualizar_ContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBActualizar_ContaActionPerformed
//      Verifica se existe todos os campos estão preenchido
        if( JTManagerUsername.getText().equals("") || JTManagerEmail.getText().equals("") || JTManagerPassword.getPassword().equals("") || 
                JTManagerSite.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preenche todos os campos");
        }else{
            conta = new Conta();
            control = new ControlDAO();
            conta.setIdconta(vectorid.get(JTTabelaContas.getSelectedRow()));
            conta.setUsername(JTManagerUsername.getText());
            conta.setPassword(String.valueOf(JTManagerPassword.getPassword()));
            conta.setEmail(JTManagerEmail.getText());
            conta.setSite(JTManagerSite.getText());
            if(control.UpdateConta(Auth, conta)){ /**Verifica se existem algum erro ao actualizar os dados no banco de dados*/
//               actualiza os dados na linha que foi selecionada 
                tabelaconta = (DefaultTableModel) JTTabelaContas.getModel();
                JTTabelaContas.setValueAt(JTManagerUsername.getText(), JTTabelaContas.getSelectedRow(), 0);
                JTTabelaContas.setValueAt(JTManagerEmail.getText(), JTTabelaContas.getSelectedRow(), 1);
                JTTabelaContas.setValueAt(JTManagerPassword.getPassword(), JTTabelaContas.getSelectedRow(), 2);
                JTTabelaContas.setValueAt(JTManagerSite.getText(), JTTabelaContas.getSelectedRow(), 3);
                JTManagerUsername.setText("");
                JTManagerPassword.setText("");
                JTManagerEmail.setText("");
                JTManagerSite.setText("");
                JOptionPane.showMessageDialog(null, "Dados da Conta Actualizado com Sucesso");
                JBActualizar_Conta.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao acessar a base de dados, tente novamente");
            }
        }
    }//GEN-LAST:event_JBActualizar_ContaActionPerformed

    private void ListaConta(){
//        Metodo reponsavel por listar os dados das contas na tabela
        tabelaconta = (DefaultTableModel) JTTabelaContas.getModel();
        control = new ControlDAO();
        conta   = new Conta();
        try {
            contas =  control.SelectConta(Auth);
            if(!contas.listIterator().hasNext()){ /**Verifica se existe dados no arraylist contas*/
                if(tabelaconta.getRowCount() > 0){ /**Verifica se ja existe dados na tabela, se existe elimina esses dados*/
                    for (int i = tabelaconta.getRowCount()-1; 0 < tabelaconta.getRowCount(); i--) {
                        tabelaconta.removeRow(i);
                    }
                }
//                Se não existe dados na tabela, então...
                JOptionPane.showMessageDialog(null, "Lista vazia, adiciona uma conta!");
                jTabbedPane1.setSelectedIndex(0);
            }else{
                if(tabelaconta.getRowCount() > 0){/**Verifica se ja existe dados na tabela, se existe elimina esses dados*/
                    for (int i = tabelaconta.getRowCount()-1; 0 < tabelaconta.getRowCount(); i--) {
                        tabelaconta.removeRow(i);
                    }
                }
//                Faz a iteração enquanto o tamanho de contas menor que i e retorna as contas que possui,
//                a cada iteração os dados da conta são adiciondas na tabela e o id das contas é adicionada 
//                em um vector que sera usado quando for necessario eliminar uma conta
                for(int i = 0; i < contas.size();i++){
                    conta = (Conta) contas.get(i);
                    Object[] dados = {conta.getUsername(),conta.getEmail(),conta.getPassword(),conta.getSite()};
                    tabelaconta.addRow(dados);
                    vectorid.add(conta.getIdconta());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBActualizar_Conta;
    private javax.swing.JButton JBAdicionarConta;
    private javax.swing.JButton JBEditar_Conta;
    private javax.swing.JButton JBEliminar_Conta;
    private javax.swing.JLabel JLCadastroVoltar;
    private javax.swing.JLabel JLLoginVoltar;
    private javax.swing.JMenu JMMenuPrincipal;
    private javax.swing.JPanel JPBanner;
    private javax.swing.JPanel JPBanner4;
    private javax.swing.JPanel JPBanner5;
    private javax.swing.JPanel JPBanner6;
    private javax.swing.JPanel JPBody;
    private javax.swing.JPanel JPCadastro;
    private javax.swing.JPanel JPConta;
    private javax.swing.JPanel JPListaContas;
    private javax.swing.JPanel JPLogin;
    private javax.swing.JPanel JPMain;
    private javax.swing.JPanel JPManager;
    private javax.swing.JPanel JPrincipal;
    private javax.swing.JPasswordField JTCriarConfirmarPassword;
    private javax.swing.JPasswordField JTCriarPassword;
    private javax.swing.JTextField JTCriarUsername;
    private javax.swing.JPasswordField JTLoginPassword;
    private javax.swing.JTextField JTLoginUsername;
    private javax.swing.JTextField JTManagerEmail;
    private javax.swing.JPasswordField JTManagerPassword;
    private javax.swing.JTextField JTManagerSite;
    private javax.swing.JTextField JTManagerUsername;
    private javax.swing.JTable JTTabelaContas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbLogin;
    private javax.swing.JButton jbcriar;
    private javax.swing.JButton jbcriar_conta;
    private javax.swing.JButton jbentrar;
    // End of variables declaration//GEN-END:variables
}
