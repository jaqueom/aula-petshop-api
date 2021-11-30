package mock;

import br.com.tt.petshop.model.Cliente;

import java.time.LocalDate;

public class ClienteMock {
    public static Cliente theo(){
        return new Cliente(2L,"Theo", LocalDate.parse("1987-05-06"), "51993333333", "29090223070");
    }
}
