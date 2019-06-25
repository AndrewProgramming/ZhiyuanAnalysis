package com.andrewprogramming.gaokao.entity;


import java.util.List;

class UrlLink{
    private String school_id;
    private String link;
    private String type;

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Video{
    private String school_id;
    private String url;
    private String url_type;
    private String img_url;

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_type() {
        return url_type;
    }

    public void setUrl_type(String url_type) {
        this.url_type = url_type;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}


public class School {
    private String school_id;
    private String data_code;
    private String name;
    private String type;
    private String school_type;
    private String school_nature;
    private String level;
    private String code_enroll;
    private String belong; //北京市教育委员会
    private String f985; //2 是不是985
    private String f211; //1 是不是211
    private String department;
    private String admissions;
    private String central;
    private String dual_class;

    private String is_seal;
    private String num_subject;
    private String num_master;
    private String num_doctor;

    private String num_academician;
    private String num_library;
    private String num_lab;
    private String province_id;

    private String city_id;
    private String county_id;
    private String is_ads;
    private String is_recruitment;
    private String create_date;

    private String area;
    private String old_name;
    private String status;
    private String add_id;

    private String add_time;
    private String update_id;
    private String update_time;

    private String ad_level;
    private String short_name;

    private String e_pc;
    private String e_app;

    private String ruanke_rank; //综合排名
    private String logo;

    private String level_name; //普通本科
    private String type_name; //理工类
    private String school_type_name; //普通本科
    private String school_nature_name; //公办
    private String dual_class_name; //双一流
    private String province_name; //北京
    private String city_name; //北京市
    private String town_name; //朝阳区
    private String weiwangzhan;
    private List<UrlLink> urlLinkList;

    private String yjszs; //研究生
    private String xiaoyuan;
    private String email;
    private String address;
    private String postcode;
    private String site;
    private String phone;
    private String content;

    private String is_video;


    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getData_code() {
        return data_code;
    }

    public void setData_code(String data_code) {
        this.data_code = data_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchool_type() {
        return school_type;
    }

    public void setSchool_type(String school_type) {
        this.school_type = school_type;
    }

    public String getSchool_nature() {
        return school_nature;
    }

    public void setSchool_nature(String school_nature) {
        this.school_nature = school_nature;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCode_enroll() {
        return code_enroll;
    }

    public void setCode_enroll(String code_enroll) {
        this.code_enroll = code_enroll;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getF985() {
        return f985;
    }

    public void setF985(String f985) {
        this.f985 = f985;
    }

    public String getF211() {
        return f211;
    }

    public void setF211(String f211) {
        this.f211 = f211;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAdmissions() {
        return admissions;
    }

    public void setAdmissions(String admissions) {
        this.admissions = admissions;
    }

    public String getCentral() {
        return central;
    }

    public void setCentral(String central) {
        this.central = central;
    }

    public String getDual_class() {
        return dual_class;
    }

    public void setDual_class(String dual_class) {
        this.dual_class = dual_class;
    }

    public String getIs_seal() {
        return is_seal;
    }

    public void setIs_seal(String is_seal) {
        this.is_seal = is_seal;
    }

    public String getNum_subject() {
        return num_subject;
    }

    public void setNum_subject(String num_subject) {
        this.num_subject = num_subject;
    }

    public String getNum_master() {
        return num_master;
    }

    public void setNum_master(String num_master) {
        this.num_master = num_master;
    }

    public String getNum_doctor() {
        return num_doctor;
    }

    public void setNum_doctor(String num_doctor) {
        this.num_doctor = num_doctor;
    }

    public String getNum_academician() {
        return num_academician;
    }

    public void setNum_academician(String num_academician) {
        this.num_academician = num_academician;
    }

    public String getNum_library() {
        return num_library;
    }

    public void setNum_library(String num_library) {
        this.num_library = num_library;
    }

    public String getNum_lab() {
        return num_lab;
    }

    public void setNum_lab(String num_lab) {
        this.num_lab = num_lab;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCounty_id() {
        return county_id;
    }

    public void setCounty_id(String county_id) {
        this.county_id = county_id;
    }

    public String getIs_ads() {
        return is_ads;
    }

    public void setIs_ads(String is_ads) {
        this.is_ads = is_ads;
    }

    public String getIs_recruitment() {
        return is_recruitment;
    }

    public void setIs_recruitment(String is_recruitment) {
        this.is_recruitment = is_recruitment;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOld_name() {
        return old_name;
    }

    public void setOld_name(String old_name) {
        this.old_name = old_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdd_id() {
        return add_id;
    }

    public void setAdd_id(String add_id) {
        this.add_id = add_id;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(String update_id) {
        this.update_id = update_id;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getAd_level() {
        return ad_level;
    }

    public void setAd_level(String ad_level) {
        this.ad_level = ad_level;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getE_pc() {
        return e_pc;
    }

    public void setE_pc(String e_pc) {
        this.e_pc = e_pc;
    }

    public String getE_app() {
        return e_app;
    }

    public void setE_app(String e_app) {
        this.e_app = e_app;
    }

    public String getRuanke_rank() {
        return ruanke_rank;
    }

    public void setRuanke_rank(String ruanke_rank) {
        this.ruanke_rank = ruanke_rank;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getSchool_type_name() {
        return school_type_name;
    }

    public void setSchool_type_name(String school_type_name) {
        this.school_type_name = school_type_name;
    }

    public String getSchool_nature_name() {
        return school_nature_name;
    }

    public void setSchool_nature_name(String school_nature_name) {
        this.school_nature_name = school_nature_name;
    }

    public String getDual_class_name() {
        return dual_class_name;
    }

    public void setDual_class_name(String dual_class_name) {
        this.dual_class_name = dual_class_name;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getTown_name() {
        return town_name;
    }

    public void setTown_name(String town_name) {
        this.town_name = town_name;
    }

    public String getWeiwangzhan() {
        return weiwangzhan;
    }

    public void setWeiwangzhan(String weiwangzhan) {
        this.weiwangzhan = weiwangzhan;
    }

    public List<UrlLink> getUrlLinkList() {
        return urlLinkList;
    }

    public void setUrlLinkList(List<UrlLink> urlLinkList) {
        this.urlLinkList = urlLinkList;
    }

    public String getYjszs() {
        return yjszs;
    }

    public void setYjszs(String yjszs) {
        this.yjszs = yjszs;
    }

    public String getXiaoyuan() {
        return xiaoyuan;
    }

    public void setXiaoyuan(String xiaoyuan) {
        this.xiaoyuan = xiaoyuan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIs_video() {
        return is_video;
    }

    public void setIs_video(String is_video) {
        this.is_video = is_video;
    }
}
