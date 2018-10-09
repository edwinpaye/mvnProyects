package pract.firstWebService.demo.Dao.interfaceDao;

import pract.firstWebService.demo.dto.Producto;

public interface IProductoDao {

    Producto findById(byte id);

}
