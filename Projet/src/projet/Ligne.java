package projet;

import java.awt.Color;

public class Ligne {
    private Point point_origine;

    public Point getPoint_origine() {
        return point_origine;
    }

    public void setPoint_origine(Point point_origine) {
        this.point_origine = point_origine;
    }

    public Point getPoint_destination() {
        return point_destination;
    }

    public void setPoint_destination(Point point_destination) {
        this.point_destination = point_destination;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    private Point point_destination;
    // Epaisseur du trait
    private float thickness;
    private Color couleur;

    public Ligne(Point point_origine, Point point_destination, float thickness, Color couleur) {
        this.point_origine = point_origine;
        this.point_destination = point_destination;
        this.thickness = thickness;
        this.couleur = couleur;
    }


    public static Color getCouleur(String couleur){
        Color codeCouleur = null;
        switch(couleur){
            case "noir":
                codeCouleur = Color.BLACK;
                break;
            case "bleu":
                codeCouleur = Color.BLUE;
                break;
            case "rouge":
                codeCouleur = Color.RED;
                break;
            case "jaune":
                codeCouleur = Color.YELLOW;
                break;
            case "cyan":
                codeCouleur = Color.CYAN;
                break;
            case "gris":
                codeCouleur = Color.GRAY;
                break;
            case "vert":
                codeCouleur = Color.GREEN;
                break;
            case "magenta":
                codeCouleur = Color.MAGENTA;
                break;
            case "orange":
                codeCouleur = Color.ORANGE;
                break;
            case "rose":
                codeCouleur = Color.PINK;
                break;
            case "gris_fonce":
                codeCouleur = Color.DARK_GRAY;
                break;
            case "gris_pale":
                codeCouleur = Color.LIGHT_GRAY;
                break;
        }

        return codeCouleur;
    }
}
