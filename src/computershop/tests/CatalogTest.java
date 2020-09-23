package tests;


import computershop.Types;
import computershop.components.Catalog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogTest {
    @BeforeEach
    public void init() {

    }


    @Test
    public void setName() {
        Catalog.values()[1].setName("new Name");
        Catalog.values()[1].setConnectionType(Types.CPUSocketType.Intel_H2_Socket.name());
        Catalog.values()[1].setPrice(0);
        Catalog.values()[1].setPower(100);
        Catalog.values()[1].setPerformance(100);
//        Catalog.values()[1].setComponentType(Types.ComponentType.DRIVES);
        assertEquals("new Name", Catalog.values()[1].getName());
    }

//    @Test
//    public void typesTest(){
//
//    }
}
