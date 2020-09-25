package com.example.heal2heart.models.response.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("language_name")
@Expose
private String languageName;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getLanguageName() {
return languageName;
}

public void setLanguageName(String languageName) {
this.languageName = languageName;
}

}