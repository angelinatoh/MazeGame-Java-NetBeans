package maze;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Ending extends javax.swing.JPanel {
    //Private Fields
    private Image backgroundImage;
    private boolean speechBubbleVisible = false;

    //To show the background image through URL
    public Ending() throws MalformedURLException {
        try {
            URL imageUrl = new URL("https://t3.ftcdn.net/jpg/06/31/61/62/360_F_631616239_lBevD3A9Iu4dYOxc1UE1nQGOlB0hIRzr.jpg");
            backgroundImage = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        initComponents();
        loadImages();
        replaceContinueButtonWithRoundButton();
        
        //To create speech bubble with text
        speechBubble.setText("<html>Forgive me for not revealing this sooner, but I am your mother, and seeing all of you safe here fills my heart with joy. However, my mission ends here and I have to go now. Go forth, for I hope I shall be able to see you again next time!</html>");
        speechBubble.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        speechBubble.setPreferredSize(new Dimension(400, 78)); // Adjust size to fit the text
        speechBubble.setAutoscrolls(true);
        
        //To add mouse listener to the panel for speech bubble to appear
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                speechBubble.setVisible(true);
                speechBubbleVisible = true;
                revalidate();
                repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //To draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        //To draw rounded speech bubble
        if (speechBubble.isVisible()) {
            Graphics2D g2d = (Graphics2D) g.create();
            int x = 300;
            int y = 170;
            int width = 400;
            int height = 78;
            int cornerRadius = 15;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //To create a rounded rectangle shape
            Shape shape = new RoundRectangle2D.Double(x, y, width, height, cornerRadius, cornerRadius);
            g2d.setColor(new Color(255, 255, 255, 200)); // Transparent white background
            g2d.fill(shape);
            g2d.dispose();
        }
    }
    
    //To declare the round button function
    private void replaceContinueButtonWithRoundButton() {
        RoundButton roundContinueButton = new RoundButton("CONTINUE");
        roundContinueButton.setBackground(new Color(0, 153, 51));
        roundContinueButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        roundContinueButton.setForeground(Color.WHITE);
        roundContinueButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            RestartButtonActionPerformed(evt);
        });

        //To replace the existing continueButton with the roundContinueButton
        GroupLayout layout = (GroupLayout) this.getLayout();
        layout.replace(RestartButton, roundContinueButton);
        RestartButton = roundContinueButton;
    }
    
    //To load the images by making them into JLabel first
    private void loadImage(String imageUrl, JLabel label, int width, int height) {
        try {
            URL url = new URL(imageUrl);
            ImageIcon icon = new ImageIcon(url);

            //To scale the icon image to fit within the JLabel dimensions
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);

            label.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //To load all the images through URL
    private void loadImages() {
        loadImage("https://static.vecteezy.com/system/resources/previews/022/484/673/non_2x/capturing-moments-3d-cute-girl-photographer-in-action-transparent-background-free-png.png", CharacterImage, 200, 200);
        loadImage("https://cdn.pixabay.com/photo/2023/06/15/14/55/fairy-8065764_1280.png", FairyImage, 85, 95);
        loadImage("https://static.vecteezy.com/system/resources/previews/022/483/990/original/attentive-3d-student-boy-with-finger-on-lips-on-white-background-transparent-background-free-png.png", FatherImage, 300, 300);
        loadImage("https://static.vecteezy.com/system/resources/previews/022/483/683/original/elegant-3d-fashion-boy-with-top-hat-ideal-for-vintage-or-victorian-themes-transparent-background-free-png.png", SonImage, 200, 200);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame("Ending");
                frame.setContentPane(new Story());
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

        Title = new javax.swing.JLabel();
        GameDescription = new javax.swing.JLabel();
        FatherImage = new javax.swing.JLabel();
        CharacterImage = new javax.swing.JLabel();
        SonImage = new javax.swing.JLabel();
        FairyImage = new javax.swing.JLabel();
        speechBubble = new javax.swing.JLabel();
        RestartButton = new javax.swing.JButton();

        Title.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("WHISPER OF THE MAZE");

        GameDescription.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        GameDescription.setForeground(new java.awt.Color(255, 255, 255));
        GameDescription.setText("A Maze of Secrets");

        FatherImage.setText("Father");

        CharacterImage.setText("Character");

        SonImage.setText("Son");

        FairyImage.setText("Fairy");

        speechBubble.setText("Forgive me for not revealing this sooner, but I am your mother, and seeing all of you safe here fills my heart with joy. However, my mission ends here and I have to go now. Go forth, for i hope i shall be able to see you again next time!");
        speechBubble.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        speechBubble.setAutoscrolls(true);
        speechBubble.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        RestartButton.setText("Restart Game");
        RestartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(FatherImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(speechBubble, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FairyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(CharacterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(RestartButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Title)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(GameDescription)))))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GameDescription)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FairyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(speechBubble, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CharacterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RestartButton)
                                .addGap(80, 80, 80))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FatherImage, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RestartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartButtonActionPerformed
        //It performs the actions needed to transition from the ending scene to the login page.

        //Dispose of the current frame
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (parentFrame != null) {
            parentFrame.dispose();
        }

        //Create and show the Login frame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame loginFrame = new JFrame("Login");
                loginFrame.setContentPane(new Login());
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginFrame.pack();
                loginFrame.setResizable(false);
                loginFrame.setVisible(true);
            }
        });
    }//GEN-LAST:event_RestartButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CharacterImage;
    private javax.swing.JLabel FairyImage;
    private javax.swing.JLabel FatherImage;
    private javax.swing.JLabel GameDescription;
    private javax.swing.JButton RestartButton;
    private javax.swing.JLabel SonImage;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel speechBubble;
    // End of variables declaration//GEN-END:variables
}
