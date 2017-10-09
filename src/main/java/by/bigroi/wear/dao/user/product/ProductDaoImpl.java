package by.bigroi.wear.dao.user.product;

import by.bigroi.wear.model.catalog.Catalog;
import by.bigroi.wear.model.product.Product;
import by.bigroi.wear.model.product.ProductColor;
import by.bigroi.wear.model.product.ProductSize;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public  List<Catalog> getCatalogsByCollection(String collection){
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Catalog where collection =:paramCollection");
        query.setParameter("paramCollection", collection);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Catalog getCatalogByCollectionAndName(String collection, String catalogName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Catalog where collection =:paramCollection and name =:paramName");
        query.setParameter("paramCollection", collection);
        query.setParameter("paramName", catalogName);
        return (Catalog) query.getSingleResult();
    }

    @Override
    @Transactional
    public List<Product> allProducts(Catalog catalog) {
        Query query = sessionFactory.getCurrentSession()
        .createQuery("from Product where catalog =:paramCatalog");
        query.setParameter("paramCatalog", catalog);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Product getProductByID(long id){
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Product where id =:paramId");
        query.setParameter("paramId", id);
        return (Product) query.getSingleResult();
    }

    @Override
    @Transactional
    public List<ProductColor> getColorsByProductId(Long productId){
        Query query = sessionFactory.getCurrentSession()
                .createNativeQuery("select color from color where id_product =:paramId");
        query.setParameter("paramId", productId);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<ProductSize> getSizesByProductId(Long productId){
        Query query = sessionFactory.getCurrentSession()
                .createNativeQuery("select size from size where id_product =:paramId");
        query.setParameter("paramId", productId);
        return query.getResultList();
    }
}
