package eapli.base.agvmanagement.repositories;

import eapli.base.Warehouse.domain.AGVDockIdentifier;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.AGVIdentifier;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.repositories.DomainRepository;

public interface AGVRepository extends DomainRepository<AGVIdentifier, AGV> {


}
