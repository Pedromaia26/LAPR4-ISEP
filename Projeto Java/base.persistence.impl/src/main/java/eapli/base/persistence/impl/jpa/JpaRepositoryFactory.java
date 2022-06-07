/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.Warehouse.domain.Warehouse;
import eapli.base.Warehouse.repositories.*;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.persistence.impl.inmemory.InMemoryOrderLineRepository;
import eapli.base.persistence.impl.inmemory.InMemoryOrderRepository;
import eapli.base.persistence.impl.inmemory.InMemoryShoppingCartLineRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartLineRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.base.surveymanagement.repositories.*;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

   /* @Override
    public JpaAGVDockRepository agvDock(final TransactionalContext autoTx) {
        return new JpaAGVDockRepository(autoTx);
    }

    @Override
    public JpaAGVDockRepository agvDock() {
        return new JpaAGVDockRepository(Application.settings().getPersistenceUnitName());
    }*/
   @Override
   public AGVDockRepository agvDock() {
       return new JpaAGVDockRepository();
   }
    @Override
    public AisleRepository aisle() {
        return new JpaAisleRepository();
    }
    @Override
    public RowRepository row() {
        return new JpaRowRepository();
    }

    @Override
    public ShelfRepository shelf() {
        return new JpaShelfRepository();
    }
    @Override
    public WarehouseRepository warehouse() {
        return new JpaWarehouseRepository();
    }
    @Override
    public ProductRepository products() {
        return new JpaProductRepository();
    }

    @Override
    public CategoryRepository categories() {
        return new JpaCategoryRepository();
    }

    @Override
    public AnswerRepository answers() {
        return new JpaAnswerRepository();
    }

    @Override
    public ContextRepository contexts() {
        return new JpaContextRepository();
    }

    @Override
    public OrderLineRepository orderlines() {
        return new JpaOrderLineRepository();
    }

    @Override
    public OrderRepository orders() {
        return new JpaOrderRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public OrderRepository orders(TransactionalContext autoTx) {
        return new JpaOrderRepository(autoTx);
    }

    @Override
    public StatusRepository status() {
        return new JpaStatusRepository();
    }

    @Override
    public TaskRepository tasks() {
        return new JpaTaskRepository();
    }

    @Override
    public ShoppingCartRepository shoppingCarts(TransactionalContext autoTx) {
        return new JpaShoppingCartRepository(autoTx);
    }

    @Override
    public ShoppingCartLineRepository shoppingCartLines(TransactionalContext autoTx) {
        return new JpaShoppingCartLineRepository(autoTx);
    }

    @Override
    public SurveyRepository surveys(TransactionalContext autoTx) {
        return new JpaSurveyRepository(autoTx);
    }

    @Override
    public SectionRepository sections(TransactionalContext autoTx) {
        return new JpaSectionRepository(autoTx);
    }

    @Override
    public QuestionRepository questions(TransactionalContext autoTx) {
        return new JpaQuestionRepository(autoTx);
    }

    @Override
    public AGVRepository agv() { return new JpaAGVRepository(Application.settings().getPersistenceUnitName()); }

    @Override
    public AGVRepository agv(TransactionalContext autoTx) {
        return new JpaAGVRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

}
