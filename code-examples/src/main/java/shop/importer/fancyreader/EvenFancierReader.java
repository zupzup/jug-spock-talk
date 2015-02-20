package shop.importer.fancyreader;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: mario
 * Date: 20.10.13
 */
public class EvenFancierReader {

    @Autowired
    TheAbsoluteFanciestReader theAbsoluteFanciestReader;

    public void doStuff() {
        theAbsoluteFanciestReader.doStuff();
    }

}
