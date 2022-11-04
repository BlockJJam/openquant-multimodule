package com.tys.dto;

import lombok.*;

public class TokenDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Info{
        private String token;
    }
}
