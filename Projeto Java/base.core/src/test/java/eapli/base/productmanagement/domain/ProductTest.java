package eapli.base.productmanagement.domain;

import eapli.base.Warehouse.domain.*;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.ClientUserBuilder;
import eapli.base.ordermanagement.domain.*;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.time.util.Calendars;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProductTest {

    private Product ProductBuild() throws IOException {
        Category category = new Category(new CategoryCode("abc123"), new CategoryDescription("description"));
        List<String> photos = new ArrayList<>();
        photos.add("src/test/resources/hasbi.jpg");
        WarehouseBuilder warehouseBuilder= new WarehouseBuilder("warehouse",4,4,1,"cm");

        Warehouse warehouse= warehouseBuilder.build();
        AisleBuilder aisleBuilder = new AisleBuilder(1,1,1,1,1,1,1,"asd",warehouse);
        Aisle aisle = aisleBuilder.build();

        RowBuilder rowBuilder = new RowBuilder(1,1,1,1,1,aisle);
        Section section = rowBuilder.build();
        ShelfIdentifier shelfIdentifier = new ShelfIdentifier(1, section, aisle);
        Shelf shelf = new Shelf(shelfIdentifier);
        ProductBuilder b = new ProductBuilder(category,
                photos,
        "short_description",
        "extended description test create a product",
        "technical description",
        "brand",
        "abcd12345",
        "a.123",
        "abcd.12345",
        10,
        "1234567890987",
        10,
        20,
        30,
        25,
        shelf);
        return b.build();
    }

    @Test
    public void ensureCanChangeInternalCode() throws IOException {
        final Product subject = ProductBuild();

        final InternalCode newInfo = new InternalCode("aaaa.11111");

        subject.modifyInternalCode(newInfo);

        assertEquals(newInfo, subject.InternalCode());
    }

    @Test
    public void ensureCanChangeSetOfPhotos() throws IOException {
        final Product subject = ProductBuild();

        List<String> photos = new ArrayList<>();
        photos.add("src/test/resources/b4.png");

        final Photo newInfo = new Photo(photos);

        subject.modifysetPhoto(newInfo);

        assertEquals(newInfo, subject.Photo());
    }

    @Test
    public void ensureCanChangeShortDescription() throws IOException {
        final Product subject = ProductBuild();

        final ShortDescription newInfo = new ShortDescription("shoooooort");

        subject.modifyShortDescription(newInfo);

        assertEquals(newInfo, subject.ShortDescription());
    }

    @Test
    public void ensureCanChangeExtendedDescription() throws IOException {
        final Product subject = ProductBuild();

        final ExtendedDescription newInfo = new ExtendedDescription("aaabbbcccdddeeefffggghhhjjoojoj");

        subject.modifyExtendedDescription(newInfo);

        assertEquals(newInfo, subject.ExtendedDescription());
    }

    @Test
    public void ensureCanChangeTechnicalDescription() throws IOException {
        final Product subject = ProductBuild();

        final TechnicalDescription newInfo = new TechnicalDescription("technical description");

        subject.modifyTechnicalDescription(newInfo);

        assertEquals(newInfo, subject.TechnicalDescription());
    }

    @Test
    public void ensureCanChangeBrand() throws IOException {
        final Product subject = ProductBuild();

        final Brand newInfo = new Brand("brandddd");

        subject.modifyBrand(newInfo);

        assertEquals(newInfo, subject.Brand());
    }

    @Test
    public void ensureCanChangeReference() throws IOException {
        final Product subject = ProductBuild();

        final Reference newInfo = new Reference("aaaa11111");

        subject.modifyReference(newInfo);

        assertEquals(newInfo, subject.Reference());
    }

    @Test
    public void ensureCanChangeProductionCode() throws IOException {
        final Product subject = ProductBuild();

        final ProductionCode newInfo = new ProductionCode("b.123");

        subject.modifyProductionCode(newInfo);

        assertEquals(newInfo, subject.ProductionCode());
    }

    @Test
    public void ensureCanChangePrice() throws IOException {
        final Product subject = ProductBuild();

        final Price newInfo = new Price(27);

        subject.modifyPrice(newInfo);

        assertEquals(newInfo, subject.Price());
    }

    @Test
    public void ensureCanChangeBarcode() throws IOException {
        final Product subject = ProductBuild();

        final Barcode newInfo = new Barcode("1111111111111");

        subject.modifyBarcode(newInfo);

        assertEquals(newInfo, subject.Barcode());
    }

    @Test
    public void ensureCanChangeHeight() throws IOException {
        final Product subject = ProductBuild();

        final Height newInfo = new Height(1);

        subject.modifyHeight(newInfo);

        assertEquals(newInfo, subject.Height());
    }

    @Test
    public void ensureCanChangeLength() throws IOException {
        final Product subject = ProductBuild();

        final Length newInfo = new Length(2);

        subject.modifyLength(newInfo);

        assertEquals(newInfo, subject.Length());
    }

    @Test
    public void ensureCanChangeWidth() throws IOException {
        final Product subject = ProductBuild();

        final Width newInfo = new Width(3);

        subject.modifyWidth(newInfo);

        assertEquals(newInfo, subject.Width());
    }

    @Test
    public void ensureCanChangeWeight() throws IOException {
        final Product subject = ProductBuild();

        final Weight newInfo = new Weight(4);

        subject.modifyWeight(newInfo);

        assertEquals(newInfo, subject.Weight());
    }

    @Test
    public void ensureCanChangeShelf() throws IOException {
        final Product subject = ProductBuild();

        WarehouseBuilder warehouseBuilder= new WarehouseBuilder("warehouse",4,4,1,"cm");

        Warehouse warehouse= warehouseBuilder.build();
        AisleBuilder aisleBuilder = new AisleBuilder(1,1,1,1,1,1,1,"asd",warehouse);
        Aisle aisle = aisleBuilder.build();

        RowBuilder rowBuilder = new RowBuilder(1,1,1,1,1,aisle);
        Section section = rowBuilder.build();
        ShelfIdentifier shelfIdentifier = new ShelfIdentifier(2, section, aisle);
        Shelf newInfo = new Shelf(shelfIdentifier);

        subject.modifyShelf(newInfo);

        assertEquals(newInfo, subject.Shelf());
    }

    @Test
    public void ensureCanChangeCategory() throws IOException {
        final Product subject = ProductBuild();

        Category newInfo = new Category(new CategoryCode("aaa111"), new CategoryDescription("descriptionn"));

        subject.modifyCategory(newInfo);

        assertEquals(newInfo, subject.Category());
    }

    @Test
    public void ensureProductEqualsAreTheSameForTheSameInstance() throws IOException {

        final Product subject = ProductBuild();

        final boolean expected = subject.equals(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureProductEqualsFailsForDifferenteObjectTypes() throws IOException {

        final Product subject = ProductBuild();

        final boolean expected = subject.equals(new Product());

        assertFalse(expected);
    }

    @Test
    public void ensureProductIsTheSameAsItsInstance() throws IOException {

        final Product subject = ProductBuild();

        final boolean expected = subject.sameAs(subject);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoOrderLineWithDifferentAGVIdentifierAreNotTheSame() throws IOException {
        final Product subject1 = ProductBuild();

        Category category = new Category(new CategoryCode("abc123"), new CategoryDescription("description"));
        List<String> photos = new ArrayList<>();
        photos.add("src/test/resources/hasbi.jpg");
        WarehouseBuilder warehouseBuilder= new WarehouseBuilder("warehouse",4,4,1,"cm");

        Warehouse warehouse= warehouseBuilder.build();
        AisleBuilder aisleBuilder = new AisleBuilder(1,1,1,1,1,1,1,"asd",warehouse);
        Aisle aisle = aisleBuilder.build();

        RowBuilder rowBuilder = new RowBuilder(1,1,1,1,1,aisle);
        Section section = rowBuilder.build();
        ShelfIdentifier shelfIdentifier = new ShelfIdentifier(1, section, aisle);
        Shelf shelf = new Shelf(shelfIdentifier);
        ProductBuilder b = new ProductBuilder(category,
                photos,
                "short_description",
                "extended description test create a product",
                "technical description",
                "brand",
                "abcd12345",
                "abcd.12345",
                10,
                "1234567890987",
                10,
                20,
                30,
                25,
                shelf);
        final Product subject2 = b.build();
        final boolean expected = subject1.sameAs(subject2);

        assertFalse(expected);
    }
}