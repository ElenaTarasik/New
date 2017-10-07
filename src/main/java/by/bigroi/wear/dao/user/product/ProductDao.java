package by.bigroi.wear.dao.user.product;

import by.bigroi.wear.model.catalog.Catalog;
import by.bigroi.wear.model.product.Product;
import by.bigroi.wear.model.product.ProductColor;
import by.bigroi.wear.model.product.ProductSize;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface ProductDao {

    public List<Catalog> getCatalogsByCollection(String collection);
    public Catalog getCatalogByCollectionAndName(String collection, String catalogName);
    public List<Product> allProducts(Catalog catalog);
    public Product getProductByID(long id);
    public List<ProductColor> getColorsByProductId(Long productId);
    public List<ProductSize> getSizesByProductId(Long productId);
}
