
package com.foodwaste.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationRequest {

    private String foodName;

    private String quantity;

    private String foodType;

    private LocalDateTime expiryTime;

    private String location;
}

