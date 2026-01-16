package maze;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FinalRevelation extends javax.swing.JPanel {
    
    private Image backgroundImage;
    private JLabel speechBubble;
    private JLabel textLabel;
    private boolean speechBubbleVisible = false; // Declare and initialize speechBubbleVisible
    //Audio audio = new Audio();

    
    public FinalRevelation() throws MalformedURLException{
        JLabel label = new JLabel("Final Revelation");
        this.add(label);

        //To load background image
        try {
            URL backgroundUrl = new URL("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/64448f8b-c9f5-4cf8-8b28-187ad23f85be/d63nvhj-e0334fc0-2c94-4175-b355-58df78c4237b.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzY0NDQ4ZjhiLWM5ZjUtNGNmOC04YjI4LTE4N2FkMjNmODViZVwvZDYzbnZoai1lMDMzNGZjMC0yYzk0LTQxNzUtYjM1NS01OGRmNzhjNDIzN2IuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.E12Mvz2-QaeUtjCcwjaJfEStYpIvxs36vabG11fBvbU");
            backgroundImage = ImageIO.read(backgroundUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        initComponents();
        loadImages();
        
        textLabel = new JLabel("<html><div style='text-align: center;'>You made it! Here they are!</div></html>");
        textLabel.setForeground(Color.BLACK);
        textLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        textLabel.setBounds(310, 130, 189, 78);
        textLabel.setVisible(false);
        add(textLabel);
        
        speechBubble = new JLabel(new ImageIcon(new URL("https://static.vecteezy.com/system/resources/previews/021/665/053/non_2x/speech-bubble-thought-bubble-comic-bubble-transparent-free-free-png.png")));
        speechBubble.setVisible(false);
        add(speechBubble);
        
        //To add mouse listener to the panel for speech bubble to appear
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //stopAudio(0);
                //playSoundEffect(3);
                //playBGM (4);

                if (speechBubbleVisible) {
                    try {
                        //To navigate to Fighting.java when clicked after speech bubble is visible
                        navigateToFighting();
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(FinalRevelation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    speechBubble.setVisible(true);
                    textLabel.setVisible(true);
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
        if (speechBubble.isVisible()) {
            Graphics2D g2d = (Graphics2D) g.create();

            int x = 300;
            int y = 130;
            int width = 189;
            int height = 78;
            int cornerRadius = 15;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //To create a rounded rectangle shape
            Shape shape = new RoundRectangle2D.Double(x, y, width, height, cornerRadius, cornerRadius);
            g2d.setColor(new Color(255, 255, 255, 200)); // Transparent white background
            g2d.fill(shape);

            //To draw the speech bubble image
            speechBubble.paint(g2d);

            g2d.dispose();
        }
    }
    
    //Function to navigate to Fighting page after clicking anywhere
    private void navigateToFighting() throws MalformedURLException {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.setContentPane(new Fighting()); // Assuming Fighting is another JPanel
        topFrame.revalidate();
        topFrame.repaint();
    }
    
    //To load the images by making them into JLabel first
    private void loadImage(String imageUrl, JLabel label, int width, int height) {
        try {
            URL url = new URL(imageUrl);
            ImageIcon icon = new ImageIcon(url);

            //Scale the icon image to fit within the JLabel dimensions
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
        loadImage("https://png.pngtree.com/png-clipart/20231024/original/pngtree-3d-halloween-witch-character-png-image_13409823.png", WitchImage, 115, 115); // Replace with the actual URL for WitchImage

        //To load background image
        try {
            URL backgroundUrl = new URL("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/64448f8b-c9f5-4cf8-8b28-187ad23f85be/d63nvhj-e0334fc0-2c94-4175-b355-58df78c4237b.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzY0NDQ4ZjhiLWM5ZjUtNGNmOC04YjI4LTE4N2FkMjNmODViZVwvZDYzbnZoai1lMDMzNGZjMC0yYzk0LTQxNzUtYjM1NS01OGRmNzhjNDIzN2IuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.E12Mvz2-QaeUtjCcwjaJfEStYpIvxs36vabG11fBvbU");
            backgroundImage = ImageIO.read(backgroundUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**public void playBGM(int i) {       
        audio.setFile(i);
        audio.play();
        audio.loop();
    }

    public void playSoundEffect(int i) {     
        audio.setFile(i);
        audio.play();
    }
    
    public void stopAudio(int i) {     
        audio.setFile(i);
        audio.stop();
    }**/


        
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {    
                
                JFrame frame = new JFrame("Final Revelation");
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

        SonImage = new javax.swing.JLabel();
        FatherImage = new javax.swing.JLabel();
        CharacterImage = new javax.swing.JLabel();
        FairyImage = new javax.swing.JLabel();
        WitchImage = new javax.swing.JLabel();
        SpeechBubble = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        SonImage.setText("Son");

        FatherImage.setText("Father");

        CharacterImage.setText("MainCharacter");

        FairyImage.setText("Fairy");

        WitchImage.setText("Witch");

        SpeechBubble.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(CharacterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FairyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(FatherImage, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SpeechBubble, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(WitchImage, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(WitchImage, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CharacterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FatherImage, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105))))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpeechBubble, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FairyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CharacterImage;
    private javax.swing.JLabel FairyImage;
    private javax.swing.JLabel FatherImage;
    private javax.swing.JLabel SonImage;
    private javax.swing.JLabel SpeechBubble;
    private javax.swing.JLabel WitchImage;
    // End of variables declaration//GEN-END:variables

}
