package com.bestbuy.api.bestbuyapiinfo;

import com.bestbuy.api.bestbuyinfo.StoresSteps;
import com.bestbuy.api.testbase.TestBase;
import com.bestbuy.api.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class StoreCRUDWithSteps extends TestBase {
    public static String name = "St Cloud" + TestUtils.getRandomValue();
    public static String type = "BigBox";
    public static String address = "4130 W Division St";
    public static String address2 = "";
    public static String city = "Saint Cloud";
    public static String state = "MN";
    public static String zip = "56301";
    public static double lat =45.55275;
    public static double lng = -94.209656;
    public static String hours = "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 9-9; Sat: 9-9; Sun: 10-8";
    public static int storeID;
    @Steps
    StoresSteps storesSteps;

    @Title("Create new store record")
    @Test
    public void test001() {

        storesSteps.createStore(name,type,address,address2,city,state,zip,lat,lng,hours).log().all().statusCode(201);

    }
    @Title("Get All store details")
    @Test
    public void test002() {
        storesSteps.getAllTheStore();
    }

    @Title("Update store details")
    @Test
    public void test003() {
        name = name+TestUtils.getRandomValue();

        storesSteps.updateStoreDetails1(storeID,name,type,address,address2,city,state,zip,lat,lng,hours).log().all().statusCode(200);
    }

    @Title("Delete store data ")
    @Test
    public void test004() {

        storesSteps.deleteStoreDetail(storeID).log().all().statusCode(200);
    }


}
