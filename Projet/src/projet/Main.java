
package projet;

import projet.syntax.lexer.Lexer;
import projet.syntax.lexer.LexerException;
import projet.syntax.node.Node;
import projet.syntax.parser.Parser;
import projet.syntax.parser.ParserException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class Main {

    public static void main(
            String[] args) {

        // Vérification de l'argument
        if (args.length != 1) {
            System.err.println("USAGE: java main.java fichier.logo");
            System.exit(1);
        }

        String filename = args[0];
        if (!filename.endsWith(".logo")) {
            System.err.println("ERREUR: Le fichier \"" + filename
                    + "\" n'a pas le suffixe \".logo\".");
            System.exit(1);
        }

        try {
            PushbackReader reader
                    = new PushbackReader(new FileReader(filename), 1024);
            Parser parser = new Parser(new Lexer(reader));
            Node tree = parser.parse();
            InterpreterEngine interp = new InterpreterEngine();
            interp.visit(tree);
        }
        catch (FileNotFoundException e) {
            System.err.println("ERREUR: Le fichier \"" + filename
                    + "\" n'a pas été trouvé.");
            System.exit(1);
        }
        catch (ParserException e) {
            System.err.println("ERREUR DE SYNTAXE: " + e.getMessage());
            System.exit(1);
        }
        catch (LexerException e) {
            System.err.println("ERREUR LEXICALE: " + e.getMessage());
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("ERREUR D'ENTRÉE/SORTIE: " + e.getMessage());
            System.exit(1);
        }
        catch (InterpreterException e) {
            System.err.println("ERREUR D'EXECUTION: " + e.getMessage());
            System.exit(1);
        }
    }

}
