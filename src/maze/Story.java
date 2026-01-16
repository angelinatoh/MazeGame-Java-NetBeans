package maze;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Story extends javax.swing.JPanel {
    //Private fields
    private String selectedGender;
    private Image backgroundImage;
    
    public Story() {
        //Constructors
        this.selectedGender = selectedGender;
        
        try {
            URL imageUrl = new URL("https://t3.ftcdn.net/jpg/06/31/61/62/360_F_631616239_lBevD3A9Iu4dYOxc1UE1nQGOlB0hIRzr.jpg");
            backgroundImage = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        initComponents();
        replaceContinueButtonWithRoundButton();
        loadFairyImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // Set alpha to 0.5 for 50% transparency
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            g2d.dispose();
        }
    }
        
    //Declare the button
    //Event Handling
    private void replaceContinueButtonWithRoundButton() {
        RoundButton roundContinueButton = new RoundButton("CONTINUE");
        roundContinueButton.setBackground(new Color(0, 153, 51));
        roundContinueButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        roundContinueButton.setForeground(Color.WHITE);
        roundContinueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MazeButtonActionPerformed(evt);
            }
        });

        //To replace the existing continueButton with the roundContinueButton
        GroupLayout layout = (GroupLayout) this.getLayout();
        layout.replace(MazeButton, roundContinueButton);
        MazeButton = roundContinueButton;
    }

    private void loadFairyImage() {
        try {
            URL imageUrl = new URL("https://cdn.pixabay.com/photo/2023/06/15/14/55/fairy-8065764_1280.png");
            ImageIcon icon = new ImageIcon(imageUrl);

            //To scale the icon image to fit within the JLabel dimensions
            int labelWidth = 200;  //Width
            int labelHeight = 200; //Height
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);

            FairyImage.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame("Story");
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

        Story1 = new javax.swing.JLabel();
        Story2 = new javax.swing.JLabel();
        Story3 = new javax.swing.JLabel();
        Story4 = new javax.swing.JLabel();
        Story5 = new javax.swing.JLabel();
        Story6 = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        GameDescription = new javax.swing.JLabel();
        MazeButton = new javax.swing.JButton();
        FairyImage = new javax.swing.JLabel();

        Story1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Story1.setText("Welcome, Player! I am your Fairy Godmother, here to guide you. You have  ");
        Story1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Story2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Story2.setText("awoken in this mystical forest with no memory of your past, but your journey to");

        Story3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Story3.setText("uncover the truth begins now. To regain your memories, you must navigate");

        Story4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Story4.setText("through three mazes, each more challenging than the last, and collect keys");

        Story5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Story5.setText("that reveal your past. I will offer guidance and hints along the way.");

        Story6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Story6.setText(" Remember, you are not alone. Your journey begins here!");

        Title.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("WHISPERS OF THE PAST");

        GameDescription.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        GameDescription.setForeground(new java.awt.Color(255, 255, 255));
        GameDescription.setText("A Maze of Secrets");

        MazeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MazeButton.setText("Let's Get Started!");
        MazeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MazeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(GameDescription))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(Title)))
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FairyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Story5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Story6)
                                        .addGap(28, 28, 28)))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Story2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Story4)
                                        .addComponent(Story3))))
                            .addComponent(Story1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MazeButton)
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(GameDescription)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(Story1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Story2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Story3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Story4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Story5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Story6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MazeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(FairyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        FairyImage.getAccessibleContext().setAccessibleName("FairyImage");
        FairyImage.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void MazeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MazeButtonActionPerformed
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (parentFrame != null) {
            parentFrame.dispose();
        }

        // Launch JavaFX application
        SwingUtilities.invokeLater(() -> {
            try {
                Main.main(new String[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }//GEN-LAST:event_MazeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FairyImage;
    private javax.swing.JLabel GameDescription;
    private javax.swing.JButton MazeButton;
    private javax.swing.JLabel Story1;
    private javax.swing.JLabel Story2;
    private javax.swing.JLabel Story3;
    private javax.swing.JLabel Story4;
    private javax.swing.JLabel Story5;
    private javax.swing.JLabel Story6;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}