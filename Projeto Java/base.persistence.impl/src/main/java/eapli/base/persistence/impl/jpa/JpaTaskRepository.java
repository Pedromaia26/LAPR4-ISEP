package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;

import javax.persistence.*;

public class JpaTaskRepository extends BasepaRepositoryBase<Task, Long, Long>
        implements TaskRepository {

    JpaTaskRepository() {
        super("id");
    }

    @Override
    public Task findTaskByID(final Long id) {
        final TypedQuery<Task> query = super.createQuery(
                "SELECT d FROM Task d WHERE id = '" + id + "'",
                Task.class);

        return query.getSingleResult();
    }
}
