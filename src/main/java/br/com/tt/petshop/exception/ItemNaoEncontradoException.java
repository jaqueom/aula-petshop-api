package br.com.tt.petshop.exception;

public class ItemNaoEncontradoException extends RuntimeException{
    public ItemNaoEncontradoException (String mensagem){
            super(mensagem);
    }
}
