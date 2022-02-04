package com.zzang.shop.api;

import com.zzang.shop.dto.member.SellerDTO;
import com.zzang.shop.service.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
@Slf4j
public class SellerApiController {

    private final SellerService sellerService;

    @PostMapping("/seller/join/{name}/{introduce}")
    public ResponseEntity<?> join(@RequestBody SellerDTO sellerDTO,
                                  @PathVariable("name") String name,
                                  @PathVariable("introduce") String introduce) {
        sellerService.joinSellerAndCreateStore(sellerDTO, name, introduce);
        return ResponseEntity.ok(sellerDTO.getSellerId());
    }
}
