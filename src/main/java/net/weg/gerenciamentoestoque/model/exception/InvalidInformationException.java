package net.weg.gerenciamentoestoque.model.exception;

public class InvalidInformationException extends RuntimeException {

    public InvalidInformationException() {
        super("Invalid or insufficient information");
    }

}
