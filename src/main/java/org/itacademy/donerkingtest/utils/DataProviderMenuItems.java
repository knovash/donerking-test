package org.itacademy.donerkingtest.utils;

import lombok.extern.log4j.Log4j2;
import org.itacademy.donerkingtest.models.MenuItem;
import org.itacademy.donerkingtest.models.Menu;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.stream.IntStream;

@Log4j2
public class DataProviderMenuItems {

    @DataProvider
    public Object[][] menuItems() {
        Menu object = JsonUtil.getObjectFromFile(Config.getDataFileMenu(), Menu.class);
        List<MenuItem> list = object.getMenuItems();
        int size = list.size();
        Object[][] data = new Object[size][1];
        IntStream.range(0, size)
                .peek(i -> log.info("DATAPROVIDER ["+ i +"] "+ list.get(i)))
                .forEach(i -> data[i][0] = list.get(i));
        return data;
    }
}
