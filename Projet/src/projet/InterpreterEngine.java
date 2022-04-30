
package projet;

import projet.syntax.analysis.DepthFirstAdapter;
import projet.syntax.node.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class InterpreterEngine
        extends DepthFirstAdapter {

    private Map<String, Value> variables = new HashMap<>();

    private Value result;
   // private JFrame f =new JFrame();
   // private JLabel pointeur = new JLabel("x");
    private LogoInterface interface_logo = new LogoInterface();




    @Override
    public void caseAConstruireFrameInstr(AConstruireFrameInstr node) {
        int width = Integer.parseInt(node.getLeft().getText());
        int height = Integer.parseInt(node.getRight().getText());
        this.interface_logo.setFrameDimention(width,height);

        System.out.println("left is "+width);
        System.out.println(" right  is "+ height);


    }

    @Override
    public void caseADeplacerPointeurInstr(ADeplacerPointeurInstr node) {
        System.out.println(this.interface_logo.informations_pointeur());
        // Value val_left = eval(node.getLeft());
        // Value val_right = eval(node.getRight());
        // int x_destination = val_left.hashCode();
        // int y_destination = val_right.hashCode();
        PArgs t = node.getObject();
        ArrayList<String> PArgsList = new ArrayList<>(Arrays.asList(t.toString().split(",")));
        
        int x_destination = Integer.parseInt(PArgsList.get(0).trim());
        int y_destination = Integer.parseInt(PArgsList.get(1).trim());
        this.interface_logo.deplacer_pointeur(x_destination,y_destination);
        System.out.println(this.interface_logo.informations_pointeur());
    }


    @Override
    public void caseADessinerLigneInstr(ADessinerLigneInstr node) {
        PArgs t = node.getObject();
        System.out.println("PArgs = " + t.toString());
        ArrayList<String> PArgsList = new ArrayList<>(Arrays.asList(t.toString().split(",")));
        System.out.println("PArgs = " + PArgsList.get(0));
        
        //Value val_left = eval(node.getLeft());
        //Value val_right = eval(node.getRight());
        //int x_destination = val_left.hashCode();
        //int y_destination = val_right.hashCode();
        Color couleur = getCouleur(PArgsList.get(0).trim().toString());
        float thickness = Float.parseFloat(PArgsList.get(1).trim());
        int x_destination = Integer.parseInt(PArgsList.get(2).trim());
        int y_destination = Integer.parseInt(PArgsList.get(3).trim());
        Point point_ori = new Point(x_destination,y_destination);
        Point point_dest = new Point(this.interface_logo.get_pointeur_position_actuelle().getPosition().x,
                this.interface_logo.get_pointeur_position_actuelle().getPosition().y);
        Ligne ligne = new Ligne(point_ori, point_dest, thickness, couleur);
        this.interface_logo.deplacer_pointeur(x_destination,y_destination);
        this.interface_logo.add_ligne(ligne);
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

    public void visit(
            Node node) {
        if (node != null) {
            node.apply(this);
        }
    }

    private Value eval(
            Node node) {

        if (this.result != null) {
            // throw new RuntimeException("Erreur inattendue dans l'intérpéteur.");
        }

        visit(node);

        if (this.result == null) {
            // throw new RuntimeException("Erreur inattendue dans l'intérpéteur.");
        }

        Value result = this.result;
        this.result = null;
        return result;
    }

    // On ajoute quelques méthodes pour nous aider à évaluer les expressions
    // (ces méthodes remplacent les anciennes asBoolean, asInteger...)
    private boolean evalBoolean(
            Node node,
            Token token) {

        Value value = eval(node);
        if (!(value instanceof BoolValue)) {
            throw new InterpreterException(token,
                    "L'expression n'est pas un booléen.");
        }

        return ((BoolValue) value).getValue();
    }

    private int getNumberLeft(
            Value value,
            Token token) {

        if (!(value instanceof IntValue)) {
            throw new InterpreterException(token,
                    "L'expression de gauche n'est pas un nombre entier.");
        }

        return ((IntValue) value).getValue();
    }

    private int getNumberRight(
            Value value,
            Token token) {

        if (!(value instanceof IntValue)) {
            throw new InterpreterException(token,
                    "L'expression de droite n'est pas un nombre entier.");
        }

        return ((IntValue) value).getValue();
    }




    @Override
    public void caseAAssignInstr(
            AAssignInstr node) {

        Value value = eval(node.getExp());
        this.variables.put(node.getIdent().getText(), value);
    }

    @Override
    public void caseAPrintInstr(
            APrintInstr node) {

        Value value = eval(node.getExp());
        System.out.print(value);
    }

    @Override
    public void caseAPrintlnInstr(
            APrintlnInstr node) {

        System.out.println();
    }

    @Override
    public void caseAIfInstr(
            AIfInstr node) {

        if (evalBoolean(node.getExp(), node.getIf())) {
            visit(node.getBlock());
        }
    }



    @Override
    public void caseAWhileInstr(
            AWhileInstr node) {

        while (evalBoolean(node.getExp(), node.getWhile())) {
            visit(node.getBlock());
        }
    }

    @Override
    public void caseAEqExp(
            AEqExp node) {

        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());
        this.result = BoolValue.get(left.equals(right));
    }

    @Override
    public void caseALtExp(
            ALtExp node) {

        int left = getNumberLeft(eval(node.getLeft()), node.getLt());
        int right = getNumberRight(eval(node.getRight()), node.getLt());
        this.result = BoolValue.get(left < right);
    }

    @Override
    public void caseAGtExp(
            AGtExp node) {

        int left = getNumberLeft(eval(node.getLeft()), node.getGt());
        int right = getNumberRight(eval(node.getLeft()), node.getGt());
        this.result = BoolValue.get(left > right);
    }





    @Override
    public void caseAAddSum(
            AAddSum node) {

        Value left = eval(node.getLeft());
        Value right = eval(node.getRight());
        if (left instanceof StringValue || right instanceof StringValue) {
            this.result = new StringValue(left.toString() + right.toString());
            return;
        }

        if (left instanceof IntValue) {
            this.result = new IntValue(getNumberLeft(left, node.getPlus())
                    + getNumberRight(right, node.getPlus()));

            return;
        }

        throw new InterpreterException(node.getPlus(),
                "L'expression de gauche n'est ni une chaîne de caractères ni un nombre.");
    }

    @Override
    public void caseASubSum(
            ASubSum node) {

        int left = getNumberLeft(eval(node.getLeft()), node.getMinus());
        int right = getNumberRight(eval(node.getRight()), node.getMinus());
        this.result = new IntValue(left - right);
    }

    @Override
    public void caseANotNeg(
            ANotNeg node) {

        this.result = BoolValue.get(!evalBoolean(node.getExp(), node.getNot()));
    }

    @Override
    public void caseANumberTerm(
            ANumberTerm node) {

        try {
            this.result = new IntValue(
                    Integer.parseInt(node.getNumber().getText()));
        }
        catch (NumberFormatException e) {
            throw new InterpreterException(node.getNumber(),
                    "Le nombre indiqué est trop grand.");
        }
    }

    @Override
    public void caseAVarTerm(
            AVarTerm node) {

        String identifier = node.getIdent().getText();
        if (!this.variables.containsKey(identifier)) {
            new InterpreterException(node.getIdent(),
                    "La variable " + identifier + " n'a pas de valeur.");
        }

        Value value = this.variables.get(identifier);
        this.result = value;
    }

    @Override
    public void caseATrueTerm(
            ATrueTerm node) {

        this.result = BoolValue.TRUE;
    }

    @Override
    public void caseAFalseTerm(
            AFalseTerm node) {

        this.result = BoolValue.FALSE;
    }

    @Override
    public void caseAStringTerm(
            AStringTerm node) {

        String text = node.getString().getText();
        // On enlève les double guillemets du début et de la fin
        text = text.substring(1, text.length() - 1);
        // On remplace les paires de double guillemets
        text = text.replace("\"\"", "\"");
        this.result = new StringValue(text);
    }
}

