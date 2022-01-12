package com.bestbuy.api.bestbuyinfo;

import com.bestbuy.api.constants.EndPoint;
import com.bestbuy.api.model.ServicePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import jnr.ffi.provider.InAccessibleMemoryIO;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ServicesSteps {
    public int Id;
    @Step("Create service record with name : {0}")
    public ValidatableResponse createService(String name){

        ServicePojo servicePojo = ServicePojo.getServicePojo(name);

        return SerenityRest.given().
                log().all()
                .contentType(ContentType.JSON)
                .body(servicePojo)
                .when()
                .post(EndPoint.CREATE_NEW_SERVICE)
                .then().statusCode(201);
      

    }
    @Step ("Update service record for serviceID : {0}, name : {1}")
    public ValidatableResponse updateService(int serviceID, String name){

        ServicePojo servicePojo = ServicePojo.getServicePojo(name);
        return SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("id",serviceID)
                .body(servicePojo)
                .when()
                .put(EndPoint.UPDATE_SINGLE_SERVICE_BY_ID)
                .then();
    }
    @Step ("Delete service by serviceID: {0}")
    public ValidatableResponse deleteService(int serviceID){

        return SerenityRest.given()
                .log().all()
                .pathParam("id",serviceID)
                .when()
                .delete(EndPoint.DELETE_SINGLE_SERVICE_BY_ID)
                .then();
    }
    @Step("Get all the services")
    public ValidatableResponse getAllServices(){
        return SerenityRest.given()
                .when()
                .get(EndPoint.GET_ALL_THE_SERVICES)
                .then().log().all().statusCode(200);
    }

}
