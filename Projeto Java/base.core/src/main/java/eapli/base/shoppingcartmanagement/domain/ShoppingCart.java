package eapli.base.shoppingcartmanagement.domain;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.clientusermanagement.domain.BillingPostalAddresses;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.DeliveringPostalAddresses;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.productmanagement.domain.Price;
import eapli.base.productmanagement.domain.Product;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart implements AggregateRoot<Long> {

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private ClientUser clientUser;

    @ElementCollection
    private Set<Line> shoppingCartLines = new HashSet<>();

    public ShoppingCart(ClientUser clientUser_id){

        if (clientUser_id == null) throw new IllegalArgumentException();

        this.clientUser = clientUser_id;
    }

    public ShoppingCart() {

    }

    public ClientUser clientUser() {
        return clientUser;
    }

    public boolean addShoppingCartLine(final ShoppingCartLine shoppingCartLine) {
        return shoppingCartLines.add(new Line(shoppingCartLine));
    }

    public boolean removeShoppingCartLine(final Line line) {
        return shoppingCartLines.remove(line);
    }

    public Set<Line> shoppingCartLines() {
        return Collections.unmodifiableSet(shoppingCartLines);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }


    @Override
    public Long identity() {
        return id;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}
