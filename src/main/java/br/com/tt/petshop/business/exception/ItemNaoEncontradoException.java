package br.com.tt.petshop.business.exception;

public class ItemNaoEncontradoException extends RuntimeException{
    public ItemNaoEncontradoException (String mensagem){
            super(mensagem);
    }
}
