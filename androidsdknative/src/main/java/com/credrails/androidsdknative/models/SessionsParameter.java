package com.credrails.androidsdknative.models;

import android.os.Build;


public class SessionsParameter {

    private String userReference;
    private String email;
    private String name;

    private SessionsParameter() {

    }

    public String getUserReference() {
        return userReference;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        public String userReference;
        public String email;
        public String name;

        public  Builder setUserReference(String userReference) {

            if(userReference == null) {
                throw new IllegalArgumentException();
            }
            this.userReference = userReference;
            return this;
        }

        public Builder setEmail(String email) {
            if(email == null){
                throw new IllegalArgumentException();
            }
            this.email = email;
            return this;
        }

        public Builder setName(String name) {
            if(name == null) {
                throw new IllegalArgumentException();
            }
            this.name = name;
            return this;
        }

        public SessionsParameter Build() {
            SessionsParameter sp = new SessionsParameter();
            sp.name = this.name;
            sp.email = this.email;
            sp.userReference = userReference;
            return sp;
        }

    }


}
