package com.yuchai.maintain.salarymaintain.entity;


import com.yuchai.maintain.salarymaintain.anno.EnableGenerateResMap;
import com.yuchai.maintain.salarymaintain.anno.IgnoreInResultMap;

import java.util.Date;
import java.lang.String;
@EnableGenerateResMap(classPath = "com.yuchai.maintain.salarymaintain.entity.SlrHoliday",xmlNames = "SlrHolidayMapper")
public class SlrHoliday{
private String dateType;
private String salaryDay;
private Date dateDate;
@IgnoreInResultMap
private String key;
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getSalaryDay() {
        return salaryDay;
    }

    public void setSalaryDay(String salaryDay) {
        this.salaryDay = salaryDay;
    }

    public Date getDateDate() {
        return dateDate;
    }

    public void setDateDate(Date dateDate) {
        this.dateDate = dateDate;
    }

    @Override
    public String toString() {
        return "SlrHoliday{" +
                "dateType='" + dateType + '\'' +
                ", salaryDay='" + salaryDay + '\'' +
                ", dateDate=" + dateDate +
                ", key='" + key + '\'' +
                '}';
    }
}
