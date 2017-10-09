package by.bigroi.wear.service.user.product;

import by.bigroi.wear.model.catalog.Catalog;
import by.bigroi.wear.model.product.Product;
import by.bigroi.wear.model.product.ProductColor;
import by.bigroi.wear.model.product.ProductSize;

import java.util.List;
import java.util.Set;

public interface ProductService {

    public List<Catalog> getCatalogs(String collection);
    public List<Product> getProductsFromCatalogAndCollection(String collection, String catalogName);
    public Product getProductByID(long id);
    public List<ProductColor> getColors(Long productId);
    public List<ProductSize> getSizes(Long productId);
}
