package eapli.base.persistence.impl.jpa;

import eapli.base.Warehouse.domain.Aisle;
import eapli.base.Warehouse.domain.AisleIdentifier;
import eapli.base.Warehouse.repositories.AisleRepository;

public class JpaAisleRepository extends BasepaRepositoryBase<Aisle, AisleIdentifier, AisleIdentifier> implements AisleRepository {

    JpaAisleRepository() {
            super("aisleIdentifier");
        }

}
