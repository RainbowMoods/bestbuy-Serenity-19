package com.bestbuy.api.bestbuyapiinfo;

import com.bestbuy.api.bestbuyinfo.ServicesSteps;
import com.bestbuy.api.testbase.TestBase;
import com.bestbuy.api.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(SerenityRunner.class)
public class ServicesCRUDWithSteps extends TestBase {
    public static String name = "Windows Store"+ TestUtils.getRandomValue();
    public static int serviceID;
    @Steps
    ServicesSteps servicesSteps;
    @Title("Get all services detail")
    public void test001(){
        servicesSteps.getAllServices().log().all().statusCode(200);
    }
    @Title ("Create new service record")
    @Test
    public void test002(){

        servicesSteps.createService(name).log().all().statusCode(201);

    }
    @Title ("Update service ")
    @Test
    public void test003(){

        name = name+TestUtils.getRandomValue();

        servicesSteps.updateService(serviceID, name).log().all().statusCode(200);
    }

    @Title ("Delete service ")
    @Test
    public void test004() {
        servicesSteps.deleteService(serviceID).log().all().statusCode(200);
    }

}
