package com.msdev.order_controller_api.entity;


import com.msdev.order_controller_api.DTO.DTOName;
import com.msdev.order_controller_api.DTO.DTOProfileBody;
import com.msdev.order_controller_api.DTO.DTOUser;
import com.msdev.order_controller_api.DTO.DTOPhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.index.Indexed;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Collation("Profile")
public class UserProfile {
    @Id
    @Indexed(name = "profile_id")
    private String id;
    private DTOName name;
    @Indexed(name = "User", unique = true)
    private DTOUser user;
    private DTOPhoneNumber number;

    public UserProfile(DTOUser dtoUser, DTOProfileBody dtoProfileBody){
        this.name = dtoProfileBody.name();
        this.user = dtoUser;
        this.number = dtoProfileBody.phone();

    }
}