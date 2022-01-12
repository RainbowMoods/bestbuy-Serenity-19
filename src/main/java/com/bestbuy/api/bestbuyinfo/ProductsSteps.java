package com.bestbuy.api.bestbuyinfo;

import com.bestbuy.api.constants.EndPoint;
import com.bestbuy.api.model.ProductPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
public class ProductsSteps {

    @Step("Create new product with name: {0},type: {1},price: {2},upc: {3}, shipping: {4},description: {5},manufacturer: {6},model: {7},url: {8},image: {9} ")
    public ValidatableResponse createNewProduct(String name,String type,
             double price,
             String upc,
             double shipping,
             String description,
             String manufacturer,
             String model,
             String url,
             String image) {
        ProductPojo productPojo = ProductPojo.getProductPojo(name, type, price, upc,shipping,  description, manufacturer, model, url, image);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productPojo)
                .when()
                .post(EndPoint.CREATE_NEW_PRODUCT)
                .then();

    }
    @Step("Update product with productId: {0},name: {1},type: {2},price: {3},upc: {4}, shipping: {5},description: {6},manufacturer: {7},model: {8},url: {9},image: {10}" )
    public ValidatableResponse updateProduct(int productId,String name,String type,
                                             double price,
                                             String upc,
                                             double shipping,
                                             String description,
                                             String manufacturer,
                                             String model,
                                             String url,
                                             String image) {
       ProductPojo productPojo= ProductPojo.getProductPojo(name, type, price, upc, shipping, description, manufacturer, model, url, image);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",productId)
                .body(productPojo)
                .when()
                .post(EndPoint.UPDATE_SINGLE_PRODUCT_BY_ID)
                .then();

    }
   @Step("Get all the product")
    public ValidatableResponse getAllProduct(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoint.GET_ALL_THE_PRODUCTS)
                .then().log().all().statusCode(200);

   }
   @Step("Delete the product by productID: {0}")
    public ValidatableResponse deleteProduct(int productID){

        return SerenityRest.given()
                .log().all()
                .pathParam("id",productID)
                .when()
                .delete(EndPoint.DELETE_SINGLE_PRODUCT_BY_ID)
                .then();
   }



}
