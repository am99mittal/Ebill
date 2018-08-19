package com.example.am99m.assignment;

/**
 * Created by am99m on 18-08-2018.
 */

public class artist {
    String date,bill_no,category,name,status,price,address,rate,discount,start,end,total,job,service,required;

    public artist() {

    }

    public artist(String date, String bill_no, String category, String name, String status, String price, String address,String rate, String discount,String start,String end,String total,String job,String service,String required) {

        this.date=date;
        this.bill_no=bill_no;
        this.category=category;
        this.name=name;
        this.status=status;
        this.price=price;
        this.address=address;
        this.rate=rate;
        this.discount=discount;
        this.start=start;
        this.end=end;
        this.total=total;
        this.job=job;
        this.service=service;
        this.required=required;
    }
    public String getDate()
    {
        return date;
    }
    public String getBill_no()
    {
        return bill_no;
    }
    public String getCategory()
    {
        return category;
    }
    public String getName()
    {
        return name;
    }
    public String getStatus()
    {
        return status;
    }
    public String getPrice()
    {
        return price;
    }
    public String getAddress() { return address; }

    public String getRate() {
        return rate;
    }

    public String getDiscount() {
        return discount;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getTotal() {
        return total;
    }

    public String getJob() {
        return job;
    }

    public String getService() {
        return service;
    }

    public String getRequired() {
        return required;
    }



    public void setDate(String date) {
        this.date = date;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public void setService(String service) {
        this.service = service;
    }
}
