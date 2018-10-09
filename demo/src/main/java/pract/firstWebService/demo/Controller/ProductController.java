package pract.firstWebService.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pract.firstWebService.demo.Dao.interfaceDao.IProductoDao;
import pract.firstWebService.demo.dto.Producto;

@RestController
@RequestMapping("/producto")
public class ProductController {

    @Autowired
    private IProductoDao productoDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Producto getProducto(@PathVariable byte id){
        return productoDao.findById(id);
    }
}
