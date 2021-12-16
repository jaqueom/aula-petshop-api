package br.com.tt.petshop.client.petshop;

import java.beans.ConstructorProperties;

public class BuscarFotoAnimal {
    private final String tamanho;
    private final String url;

    @ConstructorProperties({"fileSizeBytes","url"})
    public BuscarFotoAnimal (String tamanho, String url){
        this.tamanho = tamanho;
        this.url = url;
    }

}
