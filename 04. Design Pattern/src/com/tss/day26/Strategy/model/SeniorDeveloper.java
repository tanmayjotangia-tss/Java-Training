package com.tss.day26.Strategy.model;

public class SeniorDeveloper implements Role{
    @Override
    public String getDescription() {
        return "Guide Junior Developer, plan sprints";
    }
}
