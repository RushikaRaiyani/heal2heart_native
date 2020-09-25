package com.example.heal2heart.models.response.login;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

@SerializedName("user_name")
@Expose
private String userName;
@SerializedName("id")
@Expose
private Integer id;
@SerializedName("user_image")
@Expose
private String userImage;
@SerializedName("first_name")
@Expose
private String firstName;
@SerializedName("signup_type")
@Expose
private String signupType;
@SerializedName("country_code")
@Expose
private String countryCode;
@SerializedName("dob")
@Expose
private String dob;
@SerializedName("gender")
@Expose
private String gender;
@SerializedName("address")
@Expose
private String address;
@SerializedName("latitude")
@Expose
private String latitude;
@SerializedName("longitude")
@Expose
private String longitude;
@SerializedName("notification_status")
@Expose
private String notificationStatus;
@SerializedName("city")
@Expose
private String city;
@SerializedName("country")
@Expose
private String country;
@SerializedName("country_code_id")
@Expose
private String countryCodeId;
@SerializedName("timezone_id")
@Expose
private String timezoneId;
@SerializedName("timezone")
@Expose
private String timezone;
@SerializedName("timezone_title")
@Expose
private String timezoneTitle;
@SerializedName("last_name")
@Expose
private String lastName;
@SerializedName("email")
@Expose
private String email;
@SerializedName("mobile_number")
@Expose
private String mobileNumber;
@SerializedName("is_email_verify")
@Expose
private String isEmailVerify;
@SerializedName("is_mobile_verify")
@Expose
private String isMobileVerify;
@SerializedName("user_free_credit_left")
@Expose
private Integer userFreeCreditLeft;
@SerializedName("languages")
@Expose
private List<Language> languages = null;
@SerializedName("access_token")
@Expose
private String accessToken;

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getUserImage() {
return userImage;
}

public void setUserImage(String userImage) {
this.userImage = userImage;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getSignupType() {
return signupType;
}

public void setSignupType(String signupType) {
this.signupType = signupType;
}

public String getCountryCode() {
return countryCode;
}

public void setCountryCode(String countryCode) {
this.countryCode = countryCode;
}

public String getDob() {
return dob;
}

public void setDob(String dob) {
this.dob = dob;
}

public String getGender() {
return gender;
}

public void setGender(String gender) {
this.gender = gender;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getLatitude() {
return latitude;
}

public void setLatitude(String latitude) {
this.latitude = latitude;
}

public String getLongitude() {
return longitude;
}

public void setLongitude(String longitude) {
this.longitude = longitude;
}

public String getNotificationStatus() {
return notificationStatus;
}

public void setNotificationStatus(String notificationStatus) {
this.notificationStatus = notificationStatus;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public String getCountryCodeId() {
return countryCodeId;
}

public void setCountryCodeId(String countryCodeId) {
this.countryCodeId = countryCodeId;
}

public String getTimezoneId() {
return timezoneId;
}

public void setTimezoneId(String timezoneId) {
this.timezoneId = timezoneId;
}

public String getTimezone() {
return timezone;
}

public void setTimezone(String timezone) {
this.timezone = timezone;
}

public String getTimezoneTitle() {
return timezoneTitle;
}

public void setTimezoneTitle(String timezoneTitle) {
this.timezoneTitle = timezoneTitle;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getMobileNumber() {
return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
this.mobileNumber = mobileNumber;
}

public String getIsEmailVerify() {
return isEmailVerify;
}

public void setIsEmailVerify(String isEmailVerify) {
this.isEmailVerify = isEmailVerify;
}

public String getIsMobileVerify() {
return isMobileVerify;
}

public void setIsMobileVerify(String isMobileVerify) {
this.isMobileVerify = isMobileVerify;
}

public Integer getUserFreeCreditLeft() {
return userFreeCreditLeft;
}

public void setUserFreeCreditLeft(Integer userFreeCreditLeft) {
this.userFreeCreditLeft = userFreeCreditLeft;
}

public List<Language> getLanguages() {
return languages;
}

public void setLanguages(List<Language> languages) {
this.languages = languages;
}

public String getAccessToken() {
return accessToken;
}

public void setAccessToken(String accessToken) {
this.accessToken = accessToken;
}

}