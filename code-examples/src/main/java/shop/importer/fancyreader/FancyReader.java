package shop.importer.fancyreader;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * User: mario
 * Date: 20.10.13
 */
public class FancyReader {

    @Autowired
    EvenFancierReader evenFancierReader;

    public FancyReader() {
    }

    public String[] doStuff(String file) {
        evenFancierReader.doStuff();
        return new String [] {"1", "2"};
    }

}
