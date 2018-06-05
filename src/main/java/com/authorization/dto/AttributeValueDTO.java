package com.authorization.dto;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-04
 * @Time: 12:33
 */
public class AttributeValueDTO {

    private String email;
    private String resourceValue;
    private String role;
    private String actionValue;

    public AttributeValueDTO() {
    }

    public AttributeValueDTO(String email, String resourceValue, String role, String actionValue) {
        this.email = email;
        this.resourceValue = resourceValue;
        this.role = role;
        this.actionValue = actionValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActionValue() {
        return actionValue;
    }

    public void setActionValue(String actionValue) {
        this.actionValue = actionValue;
    }

    @Override
    public String toString() {
        return "AttributeValueDTO{" +
                "email='" + email + '\'' +
                ", resourceValue='" + resourceValue + '\'' +
                ", role='" + role + '\'' +
                ", actionValue='" + actionValue + '\'' +
                '}';
    }
}
