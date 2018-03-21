package com.example.a71568.persondoctor.adapter;


import java.sql.Date;

/**
 * Created by 71568 on 2017/12/25.
 * @author zth
 *
 *  id 病人编号  病人姓名  手机号 年龄 患病种类  患病编号 患病日期  就诊医生  病情描述  就诊建议  用药以及说明 记录生成时间
 */

public class IllHistoryBean {
    public int sickPersonId;
    public String sickPersonName;
    public String sickPersonMobile;
    public int age;
    public String illType;
    public int sickId;
    public Date sickDate;//给sql用的
    //public Date sickDateRight;
    public String doctorName;
    public String illDescription;
    public String doctorSuggestion;
    public String medicineExplain;
    public Date recordDate;

}
