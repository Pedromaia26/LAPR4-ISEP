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
package eapli.base.productmanagement.application;

import java.io.IOException;
import java.util.Calendar;
import java.util.Set;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBuilder;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.Calendars;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Created by nuno on 21/03/16.
 */
@UseCaseController
public class SpecifyNewProductController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();

    /**
     * Get existing Products available to the user.
     *
     * @return a list of Products
     */
    public Product[] getProducts() {
        return null;
    }


    public Product addProduct(final String setOfPhotos, final String shortDescription, final String extendedDescription,
                              final String technicalDescription,
                              final String brand, final String reference, final String productionCode,
                              final String internalCode, final double price, String barcode,
                              final double height, final double length, final double width, final double weight) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        final var newProduct = new ProductBuilder(setOfPhotos, shortDescription, extendedDescription, technicalDescription,
                brand, reference, productionCode, internalCode, price, barcode, height, length, width, weight);


        return productRepository.save(newProduct.build());
    }


    public Product addProduct(final String setOfPhotos, final String shortDescription, final String extendedDescription,
                              final String technicalDescription,
                              final String brand, final String reference, final String internalCode, final double price, final String barcode,
                              final double height, final double length, final double width, final double weight ) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        final var newProduct = new ProductBuilder(setOfPhotos, shortDescription, extendedDescription, technicalDescription,
                brand, reference, internalCode, price, barcode, height, length, width, weight);
        return productRepository.save(newProduct.build());
    }

}
