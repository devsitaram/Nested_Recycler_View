package com.example.nestedrecyclerview.PojoModel;

import java.util.List;

public class ParentAppsModelClass {

    public String title;
    public List<ChildAppsModelClass> childModelClassList;
    public ParentAppsModelClass(String title, List<ChildAppsModelClass> childModelClassList) {
        this.title = title;
        this.childModelClassList = childModelClassList;
    }
}
