package common;

import org.openqa.selenium.By;

public class DesktopElement {

    public final String name;
    public final By locator;
    public final boolean required;

    public DesktopElement(String name, By locator, boolean required){
        this.name = name;
        this.locator = locator;
        this.required = required;
    }

    public DesktopElement(String name, By locator){
        this(name, locator, false);
    }

    /**
     * Gets the appropriate locator.
     *
     * @return the appropriate By locator of this element.
     */
    public By getLocator(){
        return this.locator;
    }
}
