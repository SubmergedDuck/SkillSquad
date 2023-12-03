/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import data_access.InMemoryUsersDataAccessObject;
import entity.Users.CommonUser;
import entity.Users.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.signup.*;
import org.json.Property;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupUserDataAccessInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.security.Key;

/**
 *
 * @author submergedduck
 */
public class SignupView extends javax.swing.JFrame implements ActionListener, PropertyChangeListener {

    public final String viewName = "sign up";
    private final SignupViewModel signupViewModel;
    private final SignupController signupController;
    private ButtonGradient Back_BUTTON;
    private javax.swing.JPanel Main_PANEL;
    private javax.swing.JLabel PasswordSignupFailed_LABEL;
    private javax.swing.JLabel Password_LABEL;
    private javax.swing.JPasswordField Password_PASSWORDFIELD;
    private javax.swing.JPasswordField Password_PASSWORDFIELD1;
    private javax.swing.JLabel ReEnterPassword_LABEL;
    private ButtonGradient SignUp_BUTTON;
    private javax.swing.JLabel SocialSquadTitle_LABEL;
    private javax.swing.JPanel TopSeperator_PANEL;
    private keeptoo.KGradientPanel Top_GRADIENTPANEL;
    private javax.swing.JLabel UsernameSignupFailed_LABEL;
    private javax.swing.JLabel Username_LABEL;
    private javax.swing.JTextField Username_TEXTFIELD;


    /**
     * Creates new form signupView
     */
    public SignupView(SignupController controller, SignupViewModel signupViewModel) {
        initComponents();
        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        this.signupViewModel.addPropertyChangeListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        Main_PANEL = new javax.swing.JPanel();
        Top_GRADIENTPANEL = new keeptoo.KGradientPanel();
        SocialSquadTitle_LABEL = new javax.swing.JLabel();
        TopSeperator_PANEL = new javax.swing.JPanel();
        Username_LABEL = new javax.swing.JLabel();
        Password_LABEL = new javax.swing.JLabel();
        Password_PASSWORDFIELD = new javax.swing.JPasswordField();
        Username_TEXTFIELD = new javax.swing.JTextField();
        UsernameSignupFailed_LABEL = new javax.swing.JLabel();
        Password_PASSWORDFIELD1 = new javax.swing.JPasswordField();
        ReEnterPassword_LABEL = new javax.swing.JLabel();
        PasswordSignupFailed_LABEL = new javax.swing.JLabel();
        SignUp_BUTTON = new ButtonGradient();
        Back_BUTTON = new ButtonGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Main_PANEL.setBackground(new java.awt.Color(255, 255, 255));

        Top_GRADIENTPANEL.setkEndColor(new java.awt.Color(140, 100, 255));
        Top_GRADIENTPANEL.setkGradientFocus(30);
        Top_GRADIENTPANEL.setkStartColor(new java.awt.Color(223, 131, 255));

        SocialSquadTitle_LABEL.setFont(new java.awt.Font("Gotham", 1, 25)); // NOI18N
        SocialSquadTitle_LABEL.setForeground(new java.awt.Color(255, 255, 255));
        SocialSquadTitle_LABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SocialSquadTitle_LABEL.setText("Social Squad");

        TopSeperator_PANEL.setBackground(new java.awt.Color(118, 43, 236));
        TopSeperator_PANEL.setPreferredSize(new java.awt.Dimension(100, 1));
        TopSeperator_PANEL.setSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout TopSeperator_PANELLayout = new javax.swing.GroupLayout(TopSeperator_PANEL);
        TopSeperator_PANEL.setLayout(TopSeperator_PANELLayout);
        TopSeperator_PANELLayout.setHorizontalGroup(
                TopSeperator_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        TopSeperator_PANELLayout.setVerticalGroup(
                TopSeperator_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Top_GRADIENTPANELLayout = new javax.swing.GroupLayout(Top_GRADIENTPANEL);
        Top_GRADIENTPANEL.setLayout(Top_GRADIENTPANELLayout);
        Top_GRADIENTPANELLayout.setHorizontalGroup(
                Top_GRADIENTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SocialSquadTitle_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TopSeperator_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        Top_GRADIENTPANELLayout.setVerticalGroup(
                Top_GRADIENTPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Top_GRADIENTPANELLayout.createSequentialGroup()
                                .addContainerGap(67, Short.MAX_VALUE)
                                .addComponent(SocialSquadTitle_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TopSeperator_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Username_LABEL.setFont(new java.awt.Font("Gotham Medium", 0, 12)); // NOI18N
        Username_LABEL.setForeground(new java.awt.Color(140, 100, 255));
        Username_LABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Username_LABEL.setText("Username");

        Password_LABEL.setFont(new java.awt.Font("Gotham Medium", 0, 12)); // NOI18N
        Password_LABEL.setForeground(new java.awt.Color(140, 100, 255));
        Password_LABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Password_LABEL.setText("Password");

        Password_PASSWORDFIELD.setBackground(new java.awt.Color(251, 247, 255));
        Password_PASSWORDFIELD.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        Password_PASSWORDFIELD.setForeground(new java.awt.Color(196, 182, 206));
        Password_PASSWORDFIELD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Password_PASSWORDFIELD.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 222, 233), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        Password_PASSWORDFIELD.setCaretColor(new java.awt.Color(196, 182, 206));
        Password_PASSWORDFIELD.setSelectionColor(new java.awt.Color(140, 100, 255));

        Password_PASSWORDFIELD.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setPassword(Password_PASSWORDFIELD.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );//random comment

        Username_TEXTFIELD.setBackground(new java.awt.Color(251, 247, 255));
        Username_TEXTFIELD.setFont(new java.awt.Font("Gotham Medium", 3, 12)); // NOI18N
        Username_TEXTFIELD.setForeground(new java.awt.Color(196, 182, 206));
        Username_TEXTFIELD.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 222, 233), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        Username_TEXTFIELD.setCaretColor(new java.awt.Color(196, 182, 206));
        Username_TEXTFIELD.setSelectionColor(new java.awt.Color(140, 100, 255));
        Username_TEXTFIELD.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        String text = Username_TEXTFIELD.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        UsernameSignupFailed_LABEL.setFont(new java.awt.Font("Gotham Medium", 3, 10)); // NOI18N
        UsernameSignupFailed_LABEL.setForeground(new java.awt.Color(255, 102, 197));
        UsernameSignupFailed_LABEL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
//        UsernameSignupFailed_LABEL.setText("*Signup Failed: username taken");

        Password_PASSWORDFIELD1.setBackground(new java.awt.Color(251, 247, 255));
        Password_PASSWORDFIELD1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        Password_PASSWORDFIELD1.setForeground(new java.awt.Color(196, 182, 206));
        Password_PASSWORDFIELD1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Password_PASSWORDFIELD1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 222, 233), 1, true), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        Password_PASSWORDFIELD1.setCaretColor(new java.awt.Color(196, 182, 206));
        Password_PASSWORDFIELD1.setSelectionColor(new java.awt.Color(140, 100, 255));
        Password_PASSWORDFIELD1.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(Password_PASSWORDFIELD1.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        ReEnterPassword_LABEL.setFont(new java.awt.Font("Gotham Medium", 0, 12)); // NOI18N
        ReEnterPassword_LABEL.setForeground(new java.awt.Color(140, 100, 255));
        ReEnterPassword_LABEL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ReEnterPassword_LABEL.setText("Re-Enter Password");

        PasswordSignupFailed_LABEL.setFont(new java.awt.Font("Gotham Medium", 3, 10)); // NOI18N
        PasswordSignupFailed_LABEL.setForeground(new java.awt.Color(255, 102, 197));
        PasswordSignupFailed_LABEL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
//        PasswordSignupFailed_LABEL.setText("*Signup Failed: password doesn't match");

        SignUp_BUTTON.setText("Sign Up");

        SignUp_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUp_BUTTONActionPerformed(evt);
            }
        });

        Back_BUTTON.setText("Back");
        Back_BUTTON.setColor1(new java.awt.Color(255, 102, 197));
        Back_BUTTON.setColor2(new java.awt.Color(255, 102, 197));
        Back_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_BUTTONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Main_PANELLayout = new javax.swing.GroupLayout(Main_PANEL);
        Main_PANEL.setLayout(Main_PANELLayout);
        Main_PANELLayout.setHorizontalGroup(
                Main_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Main_PANELLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Top_GRADIENTPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Main_PANELLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Main_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ReEnterPassword_LABEL)
                                        .addComponent(Password_PASSWORDFIELD1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PasswordSignupFailed_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Password_LABEL)
                                        .addComponent(Password_PASSWORDFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Username_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Username_LABEL)
                                        .addComponent(UsernameSignupFailed_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(Main_PANELLayout.createSequentialGroup()
                                                .addComponent(Back_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(SignUp_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46))
        );
        Main_PANELLayout.setVerticalGroup(
                Main_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Main_PANELLayout.createSequentialGroup()
                                .addComponent(Top_GRADIENTPANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(Username_LABEL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Username_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(UsernameSignupFailed_LABEL)
                                .addGap(5, 5, 5)
                                .addComponent(Password_LABEL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Password_PASSWORDFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(ReEnterPassword_LABEL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Password_PASSWORDFIELD1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PasswordSignupFailed_LABEL)
                                .addGap(102, 102, 102)
                                .addGroup(Main_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Back_BUTTON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SignUp_BUTTON, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(106, 106, 106))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Main_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Main_PANEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Password_TEXTFIELDActionPerformed(java.awt.event.ActionEvent evt) {
        new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                SignupState currentState = signupViewModel.getState();
                currentState.setPassword(Password_PASSWORDFIELD.getText() + e.getKeyChar());
                signupViewModel.setState(currentState);

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }

    private void RepeatPassword_TEXTFIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Username_TEXTFIELDActionPerformed
        new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                currentState.setRepeatPassword(Password_PASSWORDFIELD1.getText() + e.getKeyChar());
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }

    private void Username_TEXTFIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Username_TEXTFIELDActionPerformed

        new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                SignupState currentState = signupViewModel.getState();
                String text = Username_TEXTFIELD.getText() + e.getKeyChar();
                currentState.setUsername(text);
                signupViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };// TODO add your handling code here:
    }//GEN-LAST:event_Username_TEXTFIELDActionPerformed


    private void SignUp_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUp_BUTTONActionPerformed
        if (evt.getSource().equals(SignUp_BUTTON)) {
            signupController.execute(Username_TEXTFIELD.getText(),"",
                    String.valueOf(Password_PASSWORDFIELD.getPassword()),
                    String.valueOf(Password_PASSWORDFIELD1.getPassword()),"tempsex","0","tempcontact",false);
            System.out.println("sign up");
        }
    }//GEN-LAST:event_SignUp_BUTTONActionPerformed

    private void Back_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_BUTTONActionPerformed
        signupController.execute("", "",
                "",
                "", "", "", "", true);
    }//GEN-LAST:event_Back_BUTTONActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
        if (state.getPasswordError() != null) {
            JOptionPane.showMessageDialog(this, state.getPasswordError());
        }

    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatLaf Light".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewmodel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        CommonUserFactory factory = new CommonUserFactory();
        SignupOutputBoundary presenter = new SignupPresenter(viewManagerModel, signupViewmodel, loginViewModel);

        SignupUserDataAccessInterface inMemoryUserDAO = new InMemoryUsersDataAccessObject();
        inMemoryUserDAO.save(new CommonUser("123", "123", 1, "f", "contact"));
        SignupInputBoundary interactor = new SignupInteractor(new InMemoryUsersDataAccessObject(), presenter, factory);

        SignupController controller = new SignupController(interactor);
        SignupView signupView = new SignupView(controller, signupViewmodel);
        signupViewmodel.addPropertyChangeListener(signupView);

        signupView.setVisible(true);
    }
//    public static void main(String args[]) {
//        /* Create and display the form (for seeing how view looks purposes)*/
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                SignupView signupView = new SignupView();
//                signupView.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables


}
