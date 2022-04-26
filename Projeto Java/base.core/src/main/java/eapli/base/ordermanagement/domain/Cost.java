package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Cost implements ValueObject {

        private double cost;

        public Cost(final double cost){

            if (cost < 0)
                throw new IllegalArgumentException("Cost cannot be negative!");

            this.cost = cost;
        }

        public Cost() {

        }

        @Override
        public String toString(){

            return String.valueOf(cost);
        }
}
