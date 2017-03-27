package uet.usercontroller.DTO;

/**
 * Created by nhkha on 11/03/2017.
 */
public class ChangePasswordDTO {
    private String oldPassword;
    private  String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
