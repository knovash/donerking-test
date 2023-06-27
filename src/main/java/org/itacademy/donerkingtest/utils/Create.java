package org.itacademy.donerkingtest.utils;

import lombok.extern.log4j.Log4j2;
import org.itacademy.donerkingtest.models.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Create {

    public static void main(String[] args) {
        log.info("CREATE JSON FILE");
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("бургер"));
        menuItems.add(new MenuItem("донер"));
        menuItems.add(new MenuItem("пончик"));
        Menu menu = new Menu();
        menu.setMenuItems(menuItems);
        JsonUtil.setObjectToFile(menu, Config.getDataFileMenu());
        log.info("MENU CREATED:\n" + menu);

        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Кульман", "15"));
        addressList.add(new Address("Богдановича", "10"));
        Addressbook addresses = new Addressbook();
        addresses.setAddresses(addressList);
        JsonUtil.setObjectToFile(addresses, Config.getDataFileAddressbook());
    }
}


