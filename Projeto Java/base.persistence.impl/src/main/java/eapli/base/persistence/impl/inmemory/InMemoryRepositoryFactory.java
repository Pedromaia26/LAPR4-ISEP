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
package eapli.base.persistence.impl.inmemory;

import eapli.base.Warehouse.repositories.*;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartLineRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.base.surveymanagement.repositories.*;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    /*@Override
    public AGVDockRepository agvDock(TransactionalContext autoTx) {
        return new InMemoryAGVDockRepository();
    }*/

   /* @Override
    public AGVDockRepository agvDock() {
        return agvDock(null);
    }*/
    @Override
    public AGVDockRepository agvDock(){
        return new InMemoryAGVDockRepository();
    }

    @Override
    public AGVRepository agv() {
        return new InMemoryAGVRepository();
    }

    @Override
    public AGVRepository agv(TransactionalContext autoTx) {
        return new InMemoryAGVRepository();
    }

    @Override
    public AisleRepository aisle(){
        return new InMemoryAisleRepository();
    }

    @Override
    public RowRepository row(){
        return new InMemoryRowRepository();
    }

    @Override
    public ShelfRepository shelf(){
        return new InMemoryShelfRepository();
    }

    @Override
    public WarehouseRepository warehouse(){
        return new InMemoryWarehouseRepository();
    }

    @Override
    public ProductRepository products() {
        return new InMemoryProductRepository();
    }

    @Override
    public CategoryRepository categories() {
        return new InMemoryCategoryRepository();
    }

    @Override
    public AnswerRepository answers() {
        return new InMemoryAnswerRepository();
    }

    @Override
    public OrderLineRepository orderlines() {
        return new InMemoryOrderLineRepository();
    }

    @Override
    public ContextRepository contexts() {
        return new InMemoryContextRepository();
    }

    @Override
    public OrderRepository orders() {
        return new InMemoryOrderRepository();
    }

    @Override
    public OrderRepository orders(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public StatusRepository status() {
        return new InMemoryStatusRepository();
    }

    @Override
    public TaskRepository tasks() {
        return new InMemoryTaskRepository();
    }

    @Override
    public ShoppingCartRepository shoppingCarts(TransactionalContext autoTx) {
        return new InMemoryShoppingCartRepository();
    }

    @Override
    public ShoppingCartLineRepository shoppingCartLines(TransactionalContext autoTx) {
        return new InMemoryShoppingCartLineRepository();
    }

    @Override
    public SurveyRepository surveys(TransactionalContext autoTx) {
        return new InMemorySurveyRepository(autoTx);
    }

    @Override
    public SectionRepository sections(TransactionalContext autoTx) {
        return new InMemorySectionRepository(autoTx);
    }

    @Override
    public QuestionRepository questions(TransactionalContext autoTx) {
        return new InMemoryQuestionRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
