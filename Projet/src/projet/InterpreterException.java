
package projet;

import projet.syntax.node.Token;

public class InterpreterException
        extends RuntimeException {

    private Token token;

    private String message;

    public InterpreterException(
            Token token,
            String message) {

        this.token = token;
        this.message = message;
    }

    @Override
    public String getMessage() {

        return "À la ligne " + this.token.getLine() + ", position "
                + this.token.getPos() + ": " + this.message;
    }
}
