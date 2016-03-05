
package com.teleportcall.util;

/**
 * Created by sriramk on 10/14/2014.
 */
public class UtilityFunction {

    public static String getCurrentLoggedinUser() {
        String loggedInUser = "";
        try {
            loggedInUser = "system";
        } catch (Exception e) {
            return "ANONYMOUS_USER";
        }
        return loggedInUser;
    }

}
