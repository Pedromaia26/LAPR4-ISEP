package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.ClientUserBuilder;
import eapli.base.productmanagement.domain.ExtendedDescription;
import eapli.base.productmanagement.domain.Product;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ContextTest {
    private static final String DESCRIPTION = "description description";

    private Context ContextBuild() {
        return new Context(new ExtendedDescription(DESCRIPTION));
    }

    @Test
    public void ensureCanChangeDescription() {
        final Context subject = ContextBuild();

        final ExtendedDescription newInfo = new ExtendedDescription("description1 description");

        subject.modifyDescription(newInfo);

        assertEquals(newInfo, subject.description());
    }

    @Test
    public void ensureContextEqualsAreTheSameForTheSameInstance() {

        final Context subject = ContextBuild();

        final boolean expected = subject.equals(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureContextEqualsFailsForDifferenteObjectTypes() {

        final Context subject = ContextBuild();

        final boolean expected = subject.equals(new Product());

        assertFalse(expected);
    }

    @Test
    public void ensureContextIsTheSameAsItsInstance() {

        final Context subject = ContextBuild();

        final boolean expected = subject.sameAs(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoContextWithDifferentDescriptionAreNotTheSame() {
        final Context subject1 = ContextBuild();

        final Context subject2 = ContextBuild();
        final ExtendedDescription newInfo = new ExtendedDescription("description1 description");

        subject1.modifyDescription(newInfo);
        final boolean expected = subject1.sameAs(subject2);

        assertTrue(expected);
    }
}