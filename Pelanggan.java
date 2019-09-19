package tsp;

import java.awt.*;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

class Surface extends JPanel{ 
    private int[] X;
    private int[] Y;
    private int Jumlah;
    private int[] result = Library.GetResult();
    
    public Surface (){
        int[][] x = Library.GetCoordinate();
        int n = x.length;
        X = new int[n];
        Y = new int[n];
        for(int i = 0; i < n; i++) {
            // ini diganti menyusuaian ukuran
            X[i] = x[i][0]/20+10;
            Y[i] = x[i][1]/20+10;
        }
        Jumlah = n;
    }
    
    private void doDrawing(Graphics g){
        Graphics g2d = (Graphics2D) g;
        
        Color wh = Color.white;
        Color bc = Color.BLACK;

        g2d.setColor(bc);
        for(int i = 0 ; i < Jumlah ; i++) {
            //ini besar lingkaran
            int z = 2;
            g2d.fillOval(X[i]-z,Y[i]-z,2*z+1,2*z+1);
        }
        
        for(int i = 0 ; i < Jumlah-1 ; i++) {
            g2d.drawLine(X[result[i]],Y[result[i]],X[result[i+1]],Y[result[i+1]]);
        }
        g2d.drawLine(X[result[0]],Y[result[0]],X[result[Jumlah-1]],Y[result[Jumlah-1]]);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Pelanggan extends JFrame{
    public Pelanggan() throws Exception{
        Surface tampilan = new Surface();
        add(tampilan); 
        setTitle("Hasil");
        setSize(425, 320);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);
        
        getSaveSnapShot(tampilan, "gambar.jpg");
    }
    
    public void getSaveSnapShot(Component a, String b) throws Exception {
        BufferedImage img = getScreenShot(a);
        ImageIO.write(img, "png", new File(b));
    }
    
    public BufferedImage getScreenShot(Component a) {
        BufferedImage image = new BufferedImage(a.getWidth(), a.getHeight(),BufferedImage.TYPE_INT_RGB);
        a.paint(image.getGraphics());
        return image;
    }
}