package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.domain.AGVDockIdentifier;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.AGVIdentifier;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaAGVRepository extends JpaAutoTxRepository<AGV, AGVIdentifier, AGVIdentifier>
        implements AGVRepository {

    public JpaAGVRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(), "agvIdentifier");
    }

    public JpaAGVRepository(TransactionalContext autoTx){
        super(autoTx, "agvIdentifier");
    }



}

