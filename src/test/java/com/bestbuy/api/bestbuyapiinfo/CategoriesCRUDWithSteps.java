package com.bestbuy.api.bestbuyapiinfo;

import com.bestbuy.api.bestbuyinfo.CategoriesSteps;
import com.bestbuy.api.testbase.TestBase;
import com.bestbuy.api.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CategoriesCRUDWithSteps extends TestBase {

    public static String name = "Gift Ideas"+ TestUtils.getRandomValue();
    public static String id = "abcat001"+TestUtils.getRandomValue();

    @Steps
    CategoriesSteps categoriesSteps;
    @Title("Get all the categories")
    @Test
    public void test001(){
        categoriesSteps.getAllCategory().log().all().statusCode(200);
    }

    @Title("Create new category")
    @Test
    public void test002() {
        categoriesSteps.createCategory(id, name).log().all().statusCode(201);
    }


    @Title("Update  category data")
    @Test
    public void test003(){
        name = name+TestUtils.getRandomValue();
        categoriesSteps.changeCategoryRecord(id,name).log().all();
    }
    @Title("Delete category by id")
    @Test
    public void test004(){
        categoriesSteps.deleteCategoryById(id).log();
    }
}