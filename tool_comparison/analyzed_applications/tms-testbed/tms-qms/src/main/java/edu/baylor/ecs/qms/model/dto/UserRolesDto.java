package edu.baylor.ecs.qms.model.dto;

public class UserRolesDto {
    private boolean admin;
    private boolean hotelManager;
    private boolean groupLeader;
    private boolean registered;

    public UserRolesDto(boolean admin, boolean hotelManager, boolean groupLeader, boolean registered) {
        this.admin = admin;
        this.hotelManager = hotelManager;
        this.groupLeader = groupLeader;
        this.registered = registered;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isHotelManager() {
        return hotelManager;
    }

    public void setHotelManager(boolean hotelManager) {
        this.hotelManager = hotelManager;
    }

    public boolean isGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(boolean groupLeader) {
        this.groupLeader = groupLeader;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
}
