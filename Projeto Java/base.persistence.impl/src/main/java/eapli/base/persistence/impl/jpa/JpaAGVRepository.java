package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.domain.AGVDockIdentifier;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.AGVIdentifier;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.ordermanagement.domain.ProductOrder;
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


    @Override
    public Iterable<AGV> findFreeAGV() {
        final TypedQuery<AGV> query = super.createQuery(
                "SELECT d FROM AGV d WHERE task_id = 1",
                AGV.class);

        return query.getResultList();
    }

    @Override
    public AGV findById(String id) {
        final TypedQuery<AGV> query = super.createQuery(
                "SELECT d FROM AGV d WHERE id = '" + id + "'",
                AGV.class);

        return query.getSingleResult();
    }

    public Iterable<AGV> findAGVServingOrder() {
        final TypedQuery<AGV> query = super.createQuery(
                "SELECT d FROM AGV d WHERE task_id = 3",
                AGV.class);

        return query.getResultList();
    }

    @Override
    public Iterable<AGV> findAGVInMaintenance() {
        final TypedQuery<AGV> query = super.createQuery(
                "SELECT d FROM AGV d WHERE task_id = 4",
                AGV.class);

        return query.getResultList();
    }

    @Override
    public AGV findAGVInMaintenanceById(String id) {
        final TypedQuery<AGV> query = super.createQuery(
                "SELECT d FROM AGV d WHERE id = '" + id + "' and task_id = 4",
                AGV.class);

        return query.getSingleResult();
    }


}

