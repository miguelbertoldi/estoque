package net.weg.gerenciamentoestoque.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {

    public ProductAlreadyExistsException() {
        super("Product already exists");
    }

}
