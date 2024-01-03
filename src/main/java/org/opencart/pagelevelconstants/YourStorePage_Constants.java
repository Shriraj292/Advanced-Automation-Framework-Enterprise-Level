package org.opencart.pagelevelconstants;

/**
 * YourStorePage_Constants contains enum variables and getter method to get the 
 * value assigned to the variable. The variables are the constant web elements of 
 * {@link org.opencart.pages.YourStorePage}
 * 
 * @author Shriraj Ghorpade
 */
public enum YourStorePage_Constants {
	
	MY_ACCOUNT("My Account"), //top-links below --------------------!
    WISHLIST("WishList"),
    Shopping_Cart("Shopping Cart"),
    CHECKOUT("Checkout"),
    DESKTOPS("Desktops"), //navbar menus below ---------------------!
    LAPTOPS_NOTEBOOKS("Laptops & Notebooks"),
    COMPONENTS("Components"),
    MP3_Players("MP3 Players"),
    PC("PC"), //navbar sub-menus below------------------------------!
    MAC("Mac"),
    SHOWALLDESKTOPS("Show All Desktops"),
    MACS("Macs"),
    WINDOWS("Windows"),
    SHOW_ALL_LAPTOPS_AND_DESKTOPS("Show All Laptops & Notebooks"),
    MICE_AND_TRACKBALLS("Mice and Trackballs"),
    MONITORS("Monitors"),
    PRINTERS("Printers"),
    SCANNERS("Scanners"),
    WEB_CAMERAS("Web Cameras"),
    SHOW_ALL_COMPONENTS("Show All Components"),
	SHOW_ALL_MP3_PLAYERS("Show All MP3 Players");
	

    private final String value;

    YourStorePage_Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
