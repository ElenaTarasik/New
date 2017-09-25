package by.bigroi.wear.dao.user.product;

import by.bigroi.wear.model.catalog.Catalog;
import by.bigroi.wear.model.product.Product;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface ProductDao {

    public  List<Catalog> getCatalogsByCollection(String collection);
    public Catalog getCatalogByCollectionAndName(String collection, String catalogName);
    public List<Product> allProducts(Catalog catalog);
    public Product getProductByID(long id);
}
