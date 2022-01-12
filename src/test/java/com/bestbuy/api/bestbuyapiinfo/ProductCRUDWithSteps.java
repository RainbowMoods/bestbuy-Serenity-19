package com.bestbuy.api.bestbuyapiinfo;

import com.bestbuy.api.bestbuyinfo.ProductsSteps;
import com.bestbuy.api.testbase.TestBase;
import com.bestbuy.api.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.jruby.ir.operands.SValue;
import org.junit.Test;
import org.junit.runner.RunWith;

import static java.nio.file.Paths.get;

@RunWith(SerenityRunner.class)
public class ProductCRUDWithSteps extends TestBase {
   public static String name="Apple Tab"+ TestUtils.getRandomValue();
   public static String type="Electronics"+TestUtils.getRandomValue();
   public static double price=999.99;
   public static String upc="010101";
   public static double shipping=9.99;
   public static String description="Best apple tab";
   public static String manufacturer="Apple";
   public static String model="apple001";
   public static String url="http://www.bestbuy.com/site/duracell-aa-1-5v-coppertop-batteries-4-pack/48530.p?id=1099385268988&skuId=48530&cmp=RMXCC";
   public static String image="http://img.bbystatic.com/BestBuy_US/images/products/4853/48530_sa.jpg";
   public static int productId = 43900;

   @Steps
   ProductsSteps productsSteps;
   @Title("Get all the product")
   @Test
   public void test001(){
      productsSteps.getAllProduct();
   }
   @Title("Create new product ")
   @Test
   public void test002(){
      productsSteps.createNewProduct(name,type,price,upc,shipping,description,manufacturer,model,url,image)
              .log().all().statusCode(201);


   }
   @Title("Update the product")
   @Test
   public void test003(){
      name=name+"Updated";
      productsSteps.updateProduct(productId,name,type,price,upc,shipping,description,manufacturer,model,url,image).log().all();


   }
   @Title("Delete the product by id")
   @Test
   public void test004(){
      productsSteps.deleteProduct(productId).log().all().statusCode(200);
   }

}
