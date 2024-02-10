package com.cengizhanyavuz.restapibestpractices.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@ApiModel(description = "A user object")
public class UserDto {

    @ApiModelProperty(notes = "Provided id", hidden = true)
    private int id;

    @ApiModelProperty(notes = "user name of user, it can be nickname", value = "nick", required = true)
    @NotBlank(message = "Name cannot be blank.")
    private String name;

    @ApiModelProperty(notes = "personal email of user", value = "gokhana@mail.com", required = true)
    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid. Please follow the example: gokhana@mail.com")
    @NotBlank
    private String email;

    @ApiModelProperty(notes = "any personal detail of user", value = "Nothing special.", required = false)
    private String detail;
}