package me.stefan923.nameinverter;

import org.junit.Assert;
import org.junit.Test;

public class NameInverterTest {

    @Test
    public void testInvertedName() {
        Assert.assertNull(NameInverter.getInvertedName(null));
        Assert.assertEquals("", NameInverter.getInvertedName(""));
        Assert.assertEquals("Stefan", NameInverter.getInvertedName("Stefan"));
        Assert.assertEquals("Popescu, Stefan", NameInverter.getInvertedName("Stefan Popescu"));
        Assert.assertEquals("Popescu, Stefan", NameInverter.getInvertedName(" Stefan  Popescu  "));
        Assert.assertEquals("Popescu, Stefan Mr.", NameInverter.getInvertedName("Mr.   Stefan  Popescu"));
        Assert.assertEquals("Popescu, Stefan Phd.", NameInverter.getInvertedName("Phd. Stefan  Popescu "));
        Assert.assertEquals("Popescu, Stefan Mr. Phd.", NameInverter.getInvertedName("Mr. Phd. Stefan  Popescu "));
    }

}
