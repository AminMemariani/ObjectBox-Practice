package com.example.admin.myapplicationtest.models;import io.objectbox.annotation.Entity;import io.objectbox.annotation.Id;@Entitypublic class Books {    @Id    public long id;    public String name;}