package eapli.base.persistence.impl.jpa;

import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;

import javax.persistence.*;

public class JpaProductRepository extends BasepaRepositoryBase<Product, InternalCode, InternalCode>
        implements ProductRepository {

    JpaProductRepository() {
        super("internalCode");
    }

    @Override
    public Iterable<Product> findAll() {
        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT d FROM Product d", Product.class);

        return query.getResultList();
    }

    public Iterable<Product> findByBrand(String brand) {
        final TypedQuery<Product> query = super.createQuery(
                "SELECT d FROM Product d WHERE brand = '" + brand + "'",
                Product.class);

        return query.getResultList();
    }

    public Iterable<Product> findByDescription(String description) {
        final TypedQuery<Product> query = super.createQuery(
                "SELECT d FROM Product d WHERE shortdescription = '" + description + "'",
                Product.class);

        return query.getResultList();
    }

    @Override
    public Product findByCode(String productCode) {
        final TypedQuery<Product> query = super.createQuery(
                "SELECT d FROM Product d WHERE internalCode = '" + productCode + "'",
                Product.class);

        return query.getSingleResult();
    }

    @Override
    public Iterable<Product> findByCategoryCode(String code) {
        final TypedQuery<Product> query = super.createQuery(
                "SELECT d FROM Product d WHERE category_code = '" + code + "'",
                Product.class);

        return query.getResultList();
    }
}
