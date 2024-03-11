package com.springRunner.club.dto;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

// ClubDto & ClubForm 'Currently the model ain't need 2 DTO classes'
@Data
@Builder
public class ClubDto {
    // Here we add the validation annotations we desire, in the controller, we add the @Valid annotation so it triggers these annotations to work!
    private Long id;
    @NotEmpty(message = "Title can't be empty!")
    private String title;
    @NotEmpty(message = "Please provide a valid image URL!")
    private String photoUrl;
    @NotEmpty(message = "Club's description can't be empty!")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
