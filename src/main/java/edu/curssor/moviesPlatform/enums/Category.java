package edu.curssor.moviesPlatform.enums;

public enum Category {
    ACT("action"),
    ADV("adventure"),
    COM("comedy"),
    CRM("crime"),
    DRM("drama"),
    HOR("horror"),
    SCF("science fiction"),
    WES("western"),
    OTH("other");

    private String category;

    Category(String category) {
        this.category = category;
    }

    public static Category getCategoryFromString(String category) {
        for (Category cat : Category.values()) {
            if (cat.getCategory().equalsIgnoreCase(category))
                return cat;
        }
        return Category.OTH;
    }

    public static String getStringFromCategory(Category category){

        for (Category cat  : Category.values()) {
            if (cat.getCategory().equalsIgnoreCase(category.getCategory()))
                return cat.getCategory();
        }
        return Category.OTH.getCategory();
    }

    public String getCategory() {
        return category;
    }
}
