package com.example.levelate.model;

import java.util.ArrayList;

public class WeeklySectionModel {
    private String headerTitle;
    private ArrayList<WeeklySingleModel> weeklySingleModelArrayList;


    public WeeklySectionModel() {

    }
    public WeeklySectionModel(String headerTitle, ArrayList<WeeklySingleModel> weeklySingleModels) {
        this.headerTitle = headerTitle;
        this.weeklySingleModelArrayList = weeklySingleModels;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<WeeklySingleModel> getAllItemsInSection() {
        return weeklySingleModelArrayList;
    }

    public void setAllItemsInSection(ArrayList<WeeklySingleModel> allItemsInSection) {
        this.weeklySingleModelArrayList = allItemsInSection;
    }


}


