package org.itacademy.donerkingtest.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itacademy.donerkingtest.models.Address;
import org.itacademy.donerkingtest.models.Addressbook;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.stream.IntStream;

public class DataProviderAddresses {

    private static final Logger log = LogManager.getLogger(DataProviderAddresses.class);

    @DataProvider
    public Object[][] adresses() {
        Addressbook object = JsonUtil.getObjectFromFile(Config.getDataFileAddressbook(), Addressbook.class);
        List<Address> list = object.getAddresses();
        int size = list.size();
        Object[][] data = new Object[size][1];
        IntStream.range(0, size)
                .peek(i -> log.info("DATAPROVIDER ["+ i +"] "+ list.get(i)))
                .forEach(i -> data[i][0] = list.get(i));
        return data;
    }
}
