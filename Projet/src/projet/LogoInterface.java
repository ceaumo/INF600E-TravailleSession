package projet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LogoInterface extends  JFrame{
    //private JFrame f =new JFrame();


    private Pointeur pointeur = new Pointeur();
    private ArrayList<Ligne> lignes = new ArrayList<>();
    private Color couleur;
    private int thickness;


    public LogoInterface(){
        this.thickness = 1;
        this.couleur = Color.BLUE;
    }


    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ligne ligne :this.lignes) {
            g2.setStroke(new BasicStroke(ligne.getThickness()));
            g2.setColor(ligne.getCouleur());
            g2.drawLine(ligne.getPoint_origine().getX(),ligne.getPoint_origine().getY(),
                    ligne.getPoint_destination().getX(),ligne.getPoint_destination().getY());
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    public void setFrameDimention(int width, int height ){
        this.frameInit();
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Leia app");
        this.setBackground(Color.WHITE);
        this.setSize(width,height);
        this.setLayout(null);
        this.setVisible(true);
        Point position_initial = new Point(width/2,height/2);
        this.pointeur.setPosition(position_initial);

    }

    public void deplacer_pointeur(int new_x,int new_y){
        Point new_position = new Point(new_x,new_y);
        this.pointeur.setPosition(new_position);

    }


    public String informations_pointeur(){
        return "Le pointeur est a la position  X = "+ pointeur.getPosition().getX() +
                " Y = "+ pointeur.getPosition().getY();
    }


    public void add_ligne(Ligne ligne){
        this.lignes.add(ligne);
    }

    public Pointeur get_pointeur_position_actuelle(){
        return this.pointeur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }



}