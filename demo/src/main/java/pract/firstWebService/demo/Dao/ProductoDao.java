package pract.firstWebService.demo.Dao;

import org.springframework.stereotype.Component;
import pract.firstWebService.demo.Dao.interfaceDao.IProductoDao;
import pract.firstWebService.demo.dto.Producto;

@Component
public class ProductoDao implements IProductoDao {

    @Override
    public Producto findById(byte id) {
        return new Producto(id, "Pepe", 1235d);
    }

}
