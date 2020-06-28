package com.example.levelate.model;

import java.util.ArrayList;

public class EducationSectionModel {
    private String headerTitle;
    private ArrayList<EducationSingleItemModel> educationSingleItemModels;


    public EducationSectionModel() {

    }
    public EducationSectionModel(String headerTitle, ArrayList<EducationSingleItemModel> educationSingleItemModels) {
        this.headerTitle = headerTitle;
        this.educationSingleItemModels = educationSingleItemModels;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<EducationSingleItemModel> getAllItemsInSection() {
        return educationSingleItemModels;
    }

    public void setAllItemsInSection(ArrayList<EducationSingleItemModel> educationSingleItemModels) {
        this.educationSingleItemModels = educationSingleItemModels;
    }


}

