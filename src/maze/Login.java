package maze;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.prefs.Preferences;

public class Login extends JPanel {
    
    private Image backgroundImage;
    private static final String PREFS_USER_ID = "userID";
    private static final String PREFS_PASSWORD = "password";
    private Preferences prefs;
    Audio audio = new Audio();

    //Class Declaration and Initialization
    public Login() {
        try {
            URL imageUrl = new URL("https://t3.ftcdn.net/jpg/06/31/61/62/360_F_631616239_lBevD3A9Iu4dYOxc1UE1nQGOlB0hIRzr.jpg");
            backgroundImage = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        prefs = Preferences.userNodeForPackage(Login.class);
        initComponents();
        loadSavedCreditials();
        replaceContinueButtonWithRoundButton(); //Call the function that make the button to be curve rectangle shape
        playBGM(0);
    }
    
    public void playBGM(int i) {       
        audio.setFile(i);
        audio.play();
        audio.loop();
    }
    
   
    public void playSoundEffect(int i) {     
        audio.setFile(i);
        audio.play();
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    //Methods of Loading and Saving Credentials
    private void loadSavedCreditials(){
        String savedUserID = prefs.get(PREFS_USER_ID,"");
        String savedPassword = prefs.get(PREFS_PASSWORD, "");
        UserIDTBox.setText(savedUserID);
        PasswordTBox.setText(savedPassword);
    }
    
    private void saveCredentials(String userID, String password){
        prefs.put(PREFS_USER_ID, userID);
        prefs.put(PREFS_PASSWORD,password);
    }

    //Declare the round button function
    private void replaceContinueButtonWithRoundButton() {
        RoundButton roundContinueButton = new RoundButton("CONTINUE");
        roundContinueButton.setBackground(new Color(0, 153, 51));
        roundContinueButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        roundContinueButton.setForeground(Color.WHITE);
        roundContinueButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            continueButtonActionPerformed(evt);
        });

        // Replace the existing continueButton with the roundContinueButton
        GroupLayout layout = (GroupLayout) this.getLayout();
        layout.replace(continueButton, roundContinueButton);
        continueButton = roundContinueButton;
    }
    
    //Main Methods
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() { 
            public void run() {
                JFrame frame = new JFrame("Login");
                frame.setContentPane(new Login());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setResizable(false);
                frame.setVisible(true);
                
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        continueButton = new javax.swing.JButton();
        UserIDTBox = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        SignInToContinue = new javax.swing.JLabel();
        UserID = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        GameDescription = new javax.swing.JLabel();
        HorizontalLine = new javax.swing.JSeparator();
        PasswordTBox = new javax.swing.JPasswordField();
        ShowPassword = new javax.swing.JCheckBox();

        continueButton.setBackground(new java.awt.Color(0, 153, 51));
        continueButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        continueButton.setForeground(new java.awt.Color(255, 255, 255));
        continueButton.setText("CONTINUE");
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        UserIDTBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        UserIDTBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIDTBoxActionPerformed(evt);
            }
        });

        Password.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setText("Password");

        SignInToContinue.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        SignInToContinue.setForeground(new java.awt.Color(255, 255, 255));
        SignInToContinue.setText("Sign up to continue");

        UserID.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        UserID.setForeground(new java.awt.Color(255, 255, 255));
        UserID.setText("User ID");

        Title.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("WHISPERS OF THE PAST");
        Title.setAlignmentX(0.5F);
        Title.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        GameDescription.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        GameDescription.setForeground(new java.awt.Color(255, 255, 255));
        GameDescription.setText("A Maze of Secrets");

        PasswordTBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        ShowPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ShowPassword.setForeground(new java.awt.Color(255, 255, 255));
        ShowPassword.setText("Show Password");
        ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(GameDescription))
                            .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(SignInToContinue)
                                    .addGap(79, 79, 79))
                                .addComponent(HorizontalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ShowPassword)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(UserID, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(UserIDTBox, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PasswordTBox)))))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GameDescription)
                .addGap(57, 57, 57)
                .addComponent(SignInToContinue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HorizontalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserIDTBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordTBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShowPassword)
                .addGap(17, 17, 17)
                .addComponent(continueButton)
                .addGap(69, 69, 69))
        );

        Title.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        //Event Handling for Continue Button
        if (UserIDTBox.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in username"); // user will be prompt when not filling any username
        } else if (PasswordTBox.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in password"); // user will be prompt when not filling any password
        } else if (UserIDTBox.getText().equals("user") && PasswordTBox.getText().equals("user")) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            
            //To display the user ID and password
            String userID = UserIDTBox.getText();
            String password = new String(PasswordTBox.getPassword());
            JOptionPane.showMessageDialog(this,"User ID: "  +userID + "\nPassword:" + password);
            
            saveCredentials(userID, password);
            

            //To dispose of the current frame
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (parentFrame != null) {
                parentFrame.dispose();
            }

            //To show the Gender panel in a new frame
            JFrame genderFrame = new JFrame("Gender Selection"); // Title of the new page
            genderFrame.setContentPane(new Gender()); // Navigate to the gender page
            genderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            genderFrame.pack();
            genderFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials");
        }
    }//GEN-LAST:event_continueButtonActionPerformed

    private void UserIDTBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIDTBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserIDTBoxActionPerformed

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordActionPerformed
        if (ShowPassword.isSelected()){
            PasswordTBox.setEchoChar((char)0); //To show number or text when the user selecting "show password"
        }
        else{
            PasswordTBox.setEchoChar((char)'•'); //To show dot only when the user not selecting "show password"
        }
        
        ShowPassword.setOpaque(false); //To make the background of the checkbox to be transparent
    }//GEN-LAST:event_ShowPasswordActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GameDescription;
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField PasswordTBox;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JLabel SignInToContinue;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel UserID;
    private javax.swing.JTextField UserIDTBox;
    private javax.swing.JButton continueButton;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
 }

class RoundButton extends JButton {

    private int arcWidth = 20; // Adjust the arc width for rounded corners
    private int arcHeight = 20; // Adjust the arc height for rounded corners

    public RoundButton(String label) {
        super(label);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, arcWidth, arcHeight);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint border
    }

    Shape shape;

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
        }
        return shape.contains(x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        int diameter = Math.max(size.width, size.height);
        size.setSize(diameter, diameter);
        return size;
    }
}