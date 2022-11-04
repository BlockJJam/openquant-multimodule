package com.tys.api;


import com.tys.dto.LoginDto;
import com.tys.dto.TokenDto;
import com.tys.dto.UserDto;
import com.tys.service.AuthService;
import com.tys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;


    /**
     * id와 pwd 요청이 들어오는 경우 등록된 회원에 한하여 토큰을 발급하여 전송해주는 API
     * - Validation: login으로 들어오는 request parameter는 LoginDto innerclass Req에서 진행
     * @param loginReq
     * @return Token info
     * @author Jaemin.Joo
     */
    @PostMapping("/login")
    public ResponseEntity<TokenDto.Info> loginUser(@Valid @RequestBody LoginDto.Req loginReq, HttpServletRequest request){

        HttpHeaders httpHeaders = authService.getAuthHeaderWithNewToken(loginReq, request);


        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }

    /**
     * security context에 저장된 정보와 request의 인증 정보가 같은 회원정보를 제공하는 API
     * @return UserDto.Auth
     * @author Jaemin.Joo
     */
    @GetMapping("/auth")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<UserDto.Auth> getActivatedInfo(HttpServletRequest request){
        UserDto.Auth authData = userService.getActivatedUserWithAuthoritySet();
//        HttpHeaders httpHeaders = authService.getAuthHeaderWithUpdatedToken(request);
//        return new ResponseEntity<>(authData, httpHeaders, HttpStatus.OK);
        return ResponseEntity.ok(authData);
    }
}