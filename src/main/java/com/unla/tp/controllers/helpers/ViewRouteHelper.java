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

    // PETITIONS
    public static final String PETITIONS_LST = "petitionNote/made";
    public static final String NEW_PETITION = "petitionNote/create";
    public static final String PETITION_DETAILS = "petitionNote/details";
    public static final String PETITION_PROFESOR_LST = "petitionNote/profesor/list";

    // BUILDING
    public static final String BUILDING_LST = "buildings/list";
    public static final String BUILDING_EDIT = "buildings/modify";

    // AULA
    public static final String CLASSROOM_LST = "classrooms/list";
    public static final String CLASSROOM_LST_BLDNG = "classrooms/byBuilding";
    public static final String CLASSROOM_EDIT = "classrooms/update";;

    // ESPACIO
    public static final String SPACE_LST = "spaces/list";
}
