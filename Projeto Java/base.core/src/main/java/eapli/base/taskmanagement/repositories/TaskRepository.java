package eapli.base.taskmanagement.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.repositories.DomainRepository;

public interface TaskRepository extends DomainRepository<Long, Task> {

    /**
     * returns the task whose id is given
     *
     * @param id
     *            the id to search for
     * @return
     */
    Task findTaskByID(Long id);
}
