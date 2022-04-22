package com.example.demo.model.request;

import com.example.demo.entity.Location;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateJob {
    private String title;
    private String description;
    @NotNull(message = "Location is required")
    @NotEmpty(message = "Location is required")
    @Email(message = "Please provide Location")
    @ApiModelProperty(
            example="HA_NOI, HAI_PHONG, DA_NANG, HO_CHI_MINH",
            notes="Email cannot be empty",
            required=true
    )
    private Location location;
    private int minSalary;
    private int maxSalary;

}
