package eapli.base.persistence.impl.jpa;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.domain.AGVDockIdentifier;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.repositories.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaAGVDockRepository extends BasepaRepositoryBase<AGVDock, AGVDockIdentifier, AGVDockIdentifier>
        implements AGVDockRepository {

    JpaAGVDockRepository() {
        super("agvDockIdentifier");
    }

}
