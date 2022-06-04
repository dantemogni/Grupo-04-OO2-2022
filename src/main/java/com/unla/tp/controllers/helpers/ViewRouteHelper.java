package com.unla.tp.controllers.helpers;

public class ViewRouteHelper {
    private ViewRouteHelper() {
        throw new IllegalStateException("Helper class");
    }

    // HOME
    public static final String INDEX = "home/index";
    public static final String HELLO = "home/hello";

    // USER
    public static final String USER_LOGIN = "user/login";
    public static final String USER_LOGOUT = "user/logout";
    public static final String USER_REGISTRATION = "user/register";
    public static final String USERS_LST = "user/usersLst";
    public static final String USER_EDIT = "user/editUser";

    //PETITIONS
    public static final String PETITIONS_LST = "managementPetitions/manOrderNotes";
    public static final String NEW_PETITION = "petitionNote/petitionNote";
}
