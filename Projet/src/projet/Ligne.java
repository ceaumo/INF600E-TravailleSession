package projet;

import java.awt.Color;

public class Ligne {
    Point point_origine;
    Point point_destination;
    // Epaisseur du trait
    float point_thickness;
    Color point_couleur;

    public Ligne(Point point_origine, Point point_destination, float point_thickness, Color point_couleur) {
        this.point_origine = point_origine;
        this.point_destination = point_destination;
        this.point_thickness = point_thickness;
        this.point_couleur = point_couleur;
    }
}
