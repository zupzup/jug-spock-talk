package shop.importer;

import shop.importer.fancyreader.FancyReader;
import shop.importer.fancyutils.AmazingUtil;
import shop.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mario
 * Date: 20.10.13
 */
public class ProductImporter {

    public List<Product> importStuff(String importFile) {
        List<Product> result = new ArrayList<Product>();

        FancyReader fancyReader = new FancyReader();
        String[] strings = fancyReader.doStuff(importFile);

        int i = 0;
        for(String s : strings) {
            Product product = new Product();
            product.setId(i);
            product.setName(s);

            result.add(product);
            i++;
        }
        return result;
    }

    public boolean doSomethingImportantWithAProduct() {
        Product product = getMostImportantProduct();
        if(product == null) {
            product = new Product();
        }
        // do important stuff
        return true;
    }

    private Product getMostImportantProduct() {
        throw new NullPointerException();
    }

    public boolean doSomethingWithStaticMethod(String input) {
        String s = AmazingUtil.convertFromAtoB(input);

        if(s != null) {
            return true;
        }
        return false;
    }
}
