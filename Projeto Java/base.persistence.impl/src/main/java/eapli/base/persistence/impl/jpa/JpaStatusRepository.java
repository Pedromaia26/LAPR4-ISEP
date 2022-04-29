package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.productmanagement.domain.InternalCode;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;

import javax.persistence.*;

public class JpaStatusRepository extends BasepaRepositoryBase<Status, Long, Long>
        implements StatusRepository {

    JpaStatusRepository() {
        super("id");
    }


    @Override
    public Status findByStatusId(final Long id) {
        final TypedQuery<Status> query = super.createQuery(
                "SELECT d FROM Status d WHERE id = '" + id + "'",
                Status.class);

        return query.getSingleResult();
    }
}
