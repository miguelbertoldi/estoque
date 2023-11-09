package net.weg.gerenciamentoestoque.exceptions;

public class InvalidInformationException extends RuntimeException {

    public InvalidInformationException() {
        super("Invalid or insufficient information");
    }

}
