package org.mddarr.order.request.service.dto.orders;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    String customerID;
    List<String> vendors;
    List<String> products;
    List<Long> quantities;

}