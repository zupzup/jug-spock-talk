package shop.importer;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import shop.importer.fancyreader.FancyReader;
import shop.importer.fancyutils.AmazingUtil;
import shop.models.Product;

/**
 * User: mario
 * Date: 20.10.13
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ProductImporter.class,AmazingUtil.class})
public class ProductImporterTest {

    ProductImporter productImporter;

    @Before
    public void setUp() throws Exception {
        productImporter = new ProductImporter();
    }

    @Test
    public void testImportStuff() throws Exception {
        assertThat(productImporter.importStuff("prod1, prod2"), hasSize(2));
    }

    @Test
    public void testImportStuffPowerMock() throws Exception {
        FancyReader fancyReader = mock(FancyReader.class);

        whenNew(FancyReader.class).withNoArguments().thenReturn(fancyReader);
        when(fancyReader.doStuff(anyString())).thenReturn(new String[]{"prod1", "prod2"});

        assertThat(productImporter.importStuff("prod1, prod2"), hasSize(2));
    }

    // ###################################################################################

    @Test
    public void testDoImportantStuff() throws Exception {
        assertThat(productImporter.doSomethingImportantWithAProduct(), is(true));
    }

    @Test
    public void testDoImportantStuffPowerMock() throws Exception {
        ProductImporter classUnderTest = spy(new ProductImporter());
        doReturn(mock(Product.class)).when(classUnderTest, "getMostImportantProduct");

        assertThat(classUnderTest.doSomethingImportantWithAProduct(), is(true));
        verifyPrivate(classUnderTest).invoke("getMostImportantProduct");

    }

    // ###################################################################################

    @Test
    public void testdoSomethingAmazingWithStatic() throws Exception {
        assertThat(productImporter.doSomethingWithStaticMethod("awesomestring"), is(true));
    }

    @Test
    public void testdoSomethingAmazingWithStaticMockito() throws Exception {
        Mockito.when(AmazingUtil.convertFromAtoB(anyString())).thenReturn("someString");

        assertThat(productImporter.doSomethingWithStaticMethod("awesomestring"), is(true));
    }

    @Test
    public void testdoSomethingAmazingWithStaticPowerMock() throws Exception {
        mockStatic(AmazingUtil.class);
        Mockito.when(AmazingUtil.convertFromAtoB(anyString())).thenReturn("someString");

        assertThat(productImporter.doSomethingWithStaticMethod("awesomestring"), is(true));

        verifyStatic();
        AmazingUtil.convertFromAtoB("awesomestring");
    }
}
