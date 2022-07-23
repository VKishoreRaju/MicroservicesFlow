package com.kr.poc.common.exception;

import lombok.*;

import java.util.Date;


@Builder
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ApplicationException {
    private String message;
    private String code;
    private Date date;
}
