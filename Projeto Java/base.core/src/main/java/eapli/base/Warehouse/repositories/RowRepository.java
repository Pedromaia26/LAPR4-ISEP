package eapli.base.Warehouse.repositories;

import eapli.base.Warehouse.domain.Section;
import eapli.base.Warehouse.domain.RowIdentifier;
import eapli.framework.domain.repositories.DomainRepository;

public interface RowRepository extends DomainRepository<RowIdentifier, Section> {
}
