package maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;

public class Gender extends javax.swing.JPanel {
    //Private fields
    private Image backgroundImage;
    private JLabel selectedImageLabel;
    
    private final String girlImageUrl = "https://static.vecteezy.com/system/resources/previews/022/484/673/non_2x/capturing-moments-3d-cute-girl-photographer-in-action-transparent-background-free-png.png";
    private final String boyImageUrl = "https://static.vecteezy.com/system/resources/previews/022/484/023/original/adventurous-3d-student-boy-with-globe-on-white-background-transparent-background-free-png.png";
    
    //Constructors
    public Gender() {
        try {
            URL imageUrl = new URL("https://t3.ftcdn.net/jpg/06/31/61/62/360_F_631616239_lBevD3A9Iu4dYOxc1UE1nQGOlB0hIRzr.jpg");
            backgroundImage = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        initComponents();
        replaceContinueButtonWithRoundButton();
        
        setLabelImage(GirlImage, girlImageUrl);
        setLabelImage(BoyImage, boyImageUrl);
        
        //Event Handling for Image Selection
        GirlImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleImageSelection(GirlImage);
            }
        });

        BoyImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleImageSelection(BoyImage);
            }
        });

        //Initially no image is selected
        selectedImageLabel = null;
        //Disable button initially
        ConfirmButton.setEnabled(false);
    }
    
    private void handleImageSelection(JLabel selectedLabel) {
        if (selectedImageLabel != null) {
            selectedImageLabel.setBorder(null); // Remove border from previously selected label
        }
        //Highlight the selected label
        selectedImageLabel = selectedLabel;
        selectedLabel.setBorder(BorderFactory.createLineBorder(Color.green, 1)); // Add border to the selected label
        
        ConfirmButton.setEnabled(true);
    }
    
    private JLabel createImageLabel(String imageUrl) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(150, 150));
        setLabelImage(label, imageUrl);
        return label;
    }
    
    //Methods for Setting Label Images
    private void setLabelImage(javax.swing.JLabel label, String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            ImageIcon icon = new ImageIcon(url);
            Image scaledImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //To draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    private void replaceContinueButtonWithRoundButton() {
        RoundButton roundContinueButton = new RoundButton("CONTINUE");
        roundContinueButton.setBackground(new Color(0, 153, 51));
        roundContinueButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        roundContinueButton.setForeground(Color.WHITE);
        roundContinueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        //To replace the existing continueButton with the roundContinueButton
        GroupLayout layout = (GroupLayout) this.getLayout();
        layout.replace(ConfirmButton, roundContinueButton);
        ConfirmButton = roundContinueButton;
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Gender Selection");
                frame.setContentPane(new Gender());
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
        ChooseurGender = new javax.swing.JLabel();
        HorizontalLine = new javax.swing.JSeparator();
        ConfirmButton = new javax.swing.JButton();
        BoyHorizontal = new javax.swing.JSeparator();
        GirlHorizontal = new javax.swing.JSeparator();
        GirlT = new javax.swing.JLabel();
        BoyT = new javax.swing.JLabel();
        GirlImage = new javax.swing.JLabel();
        BoyImage = new javax.swing.JLabel();

        setForeground(new java.awt.Color(255, 255, 255));

        Title.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("WHISPERS OF THE PAST");

        ChooseurGender.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        ChooseurGender.setForeground(new java.awt.Color(255, 255, 255));
        ChooseurGender.setText("Choose Your Gender");

        HorizontalLine.setForeground(new java.awt.Color(255, 255, 255));

        ConfirmButton.setBackground(new java.awt.Color(0, 125, 0));
        ConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ConfirmButton.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmButton.setText("CONFIRM");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        BoyHorizontal.setBackground(new java.awt.Color(255, 255, 255));
        BoyHorizontal.setForeground(new java.awt.Color(255, 255, 255));

        GirlHorizontal.setBackground(new java.awt.Color(255, 255, 255));
        GirlHorizontal.setForeground(new java.awt.Color(255, 255, 255));

        GirlT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GirlT.setForeground(new java.awt.Color(255, 255, 255));
        GirlT.setText("Girl");

        BoyT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BoyT.setForeground(new java.awt.Color(255, 255, 255));
        BoyT.setText("Boy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(HorizontalLine, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(GirlImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(GirlHorizontal, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BoyHorizontal, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(BoyImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(236, 236, 236))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ChooseurGender)
                        .addGap(317, 317, 317))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(GirlT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)
                        .addComponent(BoyT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(279, 279, 279))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(ChooseurGender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HorizontalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GirlImage, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(BoyImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BoyHorizontal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GirlHorizontal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoyT)
                    .addComponent(GirlT))
                .addGap(70, 70, 70)
                .addComponent(ConfirmButton)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        //To dispose of the current frame
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (parentFrame != null) {
            parentFrame.dispose();
        }

        //To show the Gender panel in a new frame
        String selectedGender = getSelectedGender();
        JFrame storyFrame = new JFrame("Gender");
        storyFrame.setContentPane(new Story());
        storyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        storyFrame.pack();
        storyFrame.setResizable(false);
        storyFrame.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_ConfirmButtonActionPerformed
    
    private String getSelectedGender() {
        if (selectedImageLabel == GirlImage) {
            return "Girl";
        } else if (selectedImageLabel == BoyImage) {
            return "Boy";
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator BoyHorizontal;
    private javax.swing.JLabel BoyImage;
    private javax.swing.JLabel BoyT;
    private javax.swing.JLabel ChooseurGender;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JSeparator GirlHorizontal;
    private javax.swing.JLabel GirlImage;
    private javax.swing.JLabel GirlT;
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}