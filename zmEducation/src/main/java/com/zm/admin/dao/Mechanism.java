package com.zm.admin.dao;

public class Mechanism {
    private Integer id;

    private String name;

    private String address;

    private String info;

    private String logo;

    private String testService;

    private String schoolPermit;

    private String businessLicense;

    private String contact;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getTestService() {
        return testService;
    }

    public void setTestService(String testService) {
        this.testService = testService == null ? null : testService.trim();
    }

    public String getSchoolPermit() {
        return schoolPermit;
    }

    public void setSchoolPermit(String schoolPermit) {
        this.schoolPermit = schoolPermit == null ? null : schoolPermit.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}