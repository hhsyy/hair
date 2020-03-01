package com.it.hair.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yiyu
 * @since 2020-02-29
 */
@Data
@Setter
@Getter

@EqualsAndHashCode
public class Haircut implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gh;

    private String xm;

    private String sj;

    private String bm;

    private String date1;

    private String date2;

    private LocalDateTime createtime;

    private Integer xh;


}
