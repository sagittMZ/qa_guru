package tests;

import conf.ArrayConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class ArrayTests {
    @Test
    public void testArray(){
        ArrayConfig config = ConfigFactory.newInstance()
                .create(ArrayConfig.class);
        for (String fruit: config.fruits()){
            System.out.println(fruit);
        }
    }
}
