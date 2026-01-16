package maze;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Fighting extends javax.swing.JPanel {
    //Private Fields
    private Image backgroundImage;
    private boolean speechBubbleVisible = false;
    
    public Fighting() throws MalformedURLException {
        
        JLabel label = new JLabel("Fighting");
        this.add(label);
        
        try {
            URL backgroundUrl = new URL("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/64448f8b-c9f5-4cf8-8b28-187ad23f85be/d63nvhj-e0334fc0-2c94-4175-b355-58df78c4237b.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzY0NDQ4ZjhiLWM5ZjUtNGNmOC04YjI4LTE4N2FkMjNmODViZVwvZDYzbnZoai1lMDMzNGZjMC0yYzk0LTQxNzUtYjM1NS01OGRmNzhjNDIzN2IuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.E12Mvz2-QaeUtjCcwjaJfEStYpIvxs36vabG11fBvbU");
            backgroundImage = ImageIO.read(backgroundUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        initComponents();
        loadImages();
        
        //To create speech bubble with text
        SBubble.setText("Your dad will be alright! \n" +
                "Come follow me out first, \n" +
                "we need to keep you safe!");        
        SBubble.setVisible(false);
        add(SBubble);
        
        //To add mouse listener to the panel for speech bubble to appear
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (speechBubbleVisible) {
                    try {
                        //To navigate to Ending when clicked after speech bubble is visible
                        navigateToEnding();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(Fighting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    //If not, make the speech bubble visible first
                    SBubble.setVisible(true);
                    speechBubbleVisible = true;
                    revalidate();
                    repaint();
                }
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
        if (SBubble.isVisible()) {
            Graphics2D g2d = (Graphics2D) g.create();

            int x = 145;
            int y = 130;
            int width = 470;
            int height = 72;
            int cornerRadius = 15;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //To create a rounded rectangle shape
            Shape shape = new RoundRectangle2D.Double(x, y, width, height, cornerRadius, cornerRadius);
            g2d.setColor(new Color(255, 255, 255, 200)); // Transparent white background
            g2d.fill(shape);
            g2d.dispose();
        }
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
        loadImage("https://static.vecteezy.com/system/resources/previews/022/483/990/original/attentive-3d-student-boy-with-finger-on-lips-on-white-background-transparent-background-free-png.png", FatherImage, 200, 200);
        loadImage("https://static.vecteezy.com/system/resources/previews/022/483/683/original/elegant-3d-fashion-boy-with-top-hat-ideal-for-vintage-or-victorian-themes-transparent-background-free-png.png", SonImage, 200, 200);
        loadImage("https://png.pngtree.com/png-clipart/20231024/original/pngtree-3d-halloween-witch-character-png-image_13409823.png", WitchImage, 200, 200); // Replace with the actual URL for WitchImage

        //To load background image
        try {
            URL backgroundUrl = new URL("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/64448f8b-c9f5-4cf8-8b28-187ad23f85be/d63nvhj-e0334fc0-2c94-4175-b355-58df78c4237b.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzY0NDQ4ZjhiLWM5ZjUtNGNmOC04YjI4LTE4N2FkMjNmODViZVwvZDYzbnZoai1lMDMzNGZjMC0yYzk0LTQxNzUtYjM1NS01OGRmNzhjNDIzN2IuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.E12Mvz2-QaeUtjCcwjaJfEStYpIvxs36vabG11fBvbU");
            backgroundImage = ImageIO.read(backgroundUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Function to navigate to Ending page after clicking anywhere
    private void navigateToEnding() throws MalformedURLException {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setContentPane(new Ending()); // Assuming Ending is another JPanel
        topFrame.revalidate();
        topFrame.repaint();
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame("Fighting");
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

        WitchImage = new javax.swing.JLabel();
        FatherImage = new javax.swing.JLabel();
        SonImage = new javax.swing.JLabel();
        CharacterImage = new javax.swing.JLabel();
        FairyImage = new javax.swing.JLabel();
        SBubble = new javax.swing.JLabel();

        WitchImage.setText("Witch");

        FatherImage.setText("Father");

        SonImage.setText("Son");

        CharacterImage.setText("Character");

        FairyImage.setText("Fairy");

        SBubble.setText("Your dad will be alright! Come follow me out first, we need to keep you safe!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(FairyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CharacterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(FatherImage, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(WitchImage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(SBubble, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(SBubble, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CharacterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FatherImage, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(WitchImage, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FairyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CharacterImage;
    private javax.swing.JLabel FairyImage;
    private javax.swing.JLabel FatherImage;
    private javax.swing.JLabel SBubble;
    private javax.swing.JLabel SonImage;
    private javax.swing.JLabel WitchImage;
    // End of variables declaration//GEN-END:variables
}