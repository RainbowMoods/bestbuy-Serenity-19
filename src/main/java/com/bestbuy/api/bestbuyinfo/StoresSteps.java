package com.bestbuy.api.bestbuyinfo;
import com.bestbuy.api.constants.EndPoint;
import com.bestbuy.api.model.StorePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StoresSteps {
    @Step("Create new store with name: {0}, type: {1}, address: {2}, address2: {3}, city: {4}, state: {5}," +
            "zip: {6}, lat: {7}, lng: {8}, hours: {9}")
    public ValidatableResponse createStore(String name, String type, String address, String address2, String city,
                                           String state, String zip, double lat, double lng, String hours){

        StorePojo storePojo = StorePojo.getStorePojo(name,type,address,address2,city,state,zip,lat,lng,hours);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post(EndPoint.CREATE_NEW_STORE)
                .then();

    }
    @Step ("Update store data by store ID: {0}, name: {1}, type: {2}, address: {3}, address1: {4}, city: {5}, state: {6}," +
            "zip: {7}, lat: {8}, lng: {9}, hours: {10} ")
    public ValidatableResponse updateStoreDetails1(int storeID, String name, String type, String address, String address1, String city,
                                               String state, String zip, double lat, double lng, String hours ){

        StorePojo storePojo = StorePojo.getStorePojo(name,type,address,address1,city,state,zip,lat,lng,hours);

        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",storeID)
                .body(storePojo)
                .when()
                .put(EndPoint.UPDATE_SINGLE_STORE_BY_ID)
                .then();

    }
    @Step("Get all the store")
    public ValidatableResponse getAllTheStore(){
        return SerenityRest.given()
                .when()
                .get(EndPoint.GET_ALL_THE_STORES)
                .then().log().all().statusCode(200);

    }
    @Step ("Delete store details by storeID: {0}" )
    public ValidatableResponse deleteStoreDetail(int storeID){
        return SerenityRest.given()
                .log().all()
                .pathParam("id",storeID)
                .when()
                .delete(EndPoint.DELETE_SINGLE_STORE_BY_ID)
                .then();

    }

}
