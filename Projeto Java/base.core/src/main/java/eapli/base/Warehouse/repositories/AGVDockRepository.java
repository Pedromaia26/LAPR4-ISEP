package eapli.base.Warehouse.repositories;


import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.domain.AGVDockIdentifier;
import eapli.framework.domain.repositories.DomainRepository;

public interface AGVDockRepository  extends DomainRepository<AGVDockIdentifier, AGVDock> {
    /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
    //public AGVDock save(AGVDock entity);
}
