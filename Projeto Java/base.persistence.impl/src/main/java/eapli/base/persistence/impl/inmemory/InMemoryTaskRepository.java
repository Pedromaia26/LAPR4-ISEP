package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTaskRepository extends InMemoryDomainRepository<Task, Long>
        implements TaskRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Task findTaskByID(final Long id) {
        return null;
    }

    @Override
    public Task save(Task task) {
        return task;
    }
}
