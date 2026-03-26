package com.swaglabs.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utilties {
    public String getRandomString(int length){
        StringBuilder stringBuilder = new StringBuilder();
        String characters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        for(int i = 0; i < length; i++){
            int index = (int)(Math.random() * characters.length());
            stringBuilder.append(characters.charAt(index));
        }
        return stringBuilder.toString();
    }

    public void takeScreenshot(WebDriver driver, String methodName) throws IOException {
        System.out.println("\\u001B[34mTaking screenshot ..\\u001B[0m");
        String fileName = methodName + "_" + getRandomString(15) + ".png";
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile,new File(directory + fileName));
    }
}
