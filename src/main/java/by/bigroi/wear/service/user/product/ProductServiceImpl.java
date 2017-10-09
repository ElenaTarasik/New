package by.bigroi.wear.service.user.product;

import by.bigroi.wear.dao.user.product.ProductDao;
import by.bigroi.wear.model.catalog.Catalog;
import by.bigroi.wear.model.product.Product;
import by.bigroi.wear.model.product.ProductColor;
import by.bigroi.wear.model.product.ProductSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Catalog> getCatalogs(String collection) {
        return productDao.getCatalogsByCollection(collection);
    }

    @Override
    public List<Product> getProductsFromCatalogAndCollection(String collection, String catalogName) {
        return productDao.allProducts(productDao.getCatalogByCollectionAndName(collection, catalogName));
    }

    @Override
    public Product getProductByID(long id) {

        return productDao.getProductByID(id);
    }

    @Override
    public List<ProductColor> getColors(Long productId){
        return productDao.getColorsByProductId(productId);
    }

    @Override
    public List<ProductSize> getSizes(Long productId){
        return productDao.getSizesByProductId(productId);
    }
}
