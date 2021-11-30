package mock;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoMock {

    public static Produto racaoCachorro(){
        return new Produto(1l, "Ração para cachorros",BigDecimal.valueOf(142.62d), true);
    }

    public static Produto racaoGatos(){
        return new Produto(2l, "Ração para gatos",BigDecimal.valueOf(292.99d), true);
    }

    public static Produto racaoPorcos(){
        return new Produto(3l, "Ração para porcos",BigDecimal.valueOf(199.50d), false);
    }
    public static Produto brinquedo(){
        return new Produto(4l, "Brinquedo de morder",BigDecimal.valueOf(10d), true);
    }

}
