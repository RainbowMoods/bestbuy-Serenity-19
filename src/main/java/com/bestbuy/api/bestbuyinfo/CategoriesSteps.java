package com.bestbuy.api.bestbuyinfo;

import com.bestbuy.api.constants.EndPoint;
import com.bestbuy.api.model.CategoryPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CategoriesSteps {
    @Step("Create category record with id: {0}, name : {1}")
    public ValidatableResponse createCategory(String id, String name) {

        CategoryPojo categoryPojo = CategoryPojo.getCategoryPojo(id, name);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(categoryPojo)
                .when()
                .post(EndPoint.CREATE_NEW_CATEGORY)
                .then();
    }
    @Step("Update category record with id: {0}, name: {1}")
    public ValidatableResponse changeCategoryRecord(String id, String name){

        CategoryPojo categoryPojo = CategoryPojo.getCategoryPojo(id,name);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .body(categoryPojo)
                .when()
                .put(EndPoint.UPDATE_SINGLE_CATEGORY_BY_ID)
                .then();


    }
    @Step("Get all category data")
    public ValidatableResponse getAllCategory(){
        return SerenityRest.given()
                .when()
                .get(EndPoint.GET_ALL_THE_CATEGORIES)
                .then().log().all().statusCode(200);
    }
    @Step("Delete category by id")
    public ValidatableResponse deleteCategoryById(String id){
        return SerenityRest.given().log().all()
                .pathParam("id",id)
                .when()
                .delete(EndPoint.DELETE_SINGLE_CATEGORY_BY_ID)
                .then().log().all().statusCode(200);
    }
}

