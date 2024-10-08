package org.example;

import org.example.util.ProductClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeleniumChallenge {



  @Test
  public void testInit() {


    
    WebDriver driver = new ChromeDriver();
   

    driver.get("https://www.amazon.in/");

    driver.findElement(By.xpath("//input[contains(@placeholder,'Search Amazon.in')]")).sendKeys("lg soundbar");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='s-suggestion-container'])[1]")));
    driver.findElement(By.xpath("(//div[@class='s-suggestion-container'])[1]")).click();


    List<ProductClass> productList = new ArrayList<>();

    List<WebElement> prices = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='a-price-whole']")));
    List<WebElement> productNames = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']")));
    for (int i = 0; i < prices.size() && i < productNames.size() ; i++) {
      String price = prices.get(i).getText();
      char[] ch = price.toCharArray();
      StringBuilder s = new StringBuilder();
      for (char c : ch) {
        if (Character.isDigit(c)) {
          s.append(c);


        }

      }

      String priceText = s.toString();
      int originalPrice = Integer.parseInt(priceText);



        productList.add(new ProductClass(productNames.get(i).getText(), originalPrice));




    }
    Collections.sort(productList);

    for(ProductClass p : productList){
      System.out.println(p);
    }
  }
}




