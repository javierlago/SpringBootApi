package com.reibax.api_rest.model.dto;

import com.reibax.api_rest.model.entity.Club;
import com.reibax.api_rest.model.entity.Remero;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
@Builder
public class ClubDto {

    private int idClub;

    private String name;

    private String city;

    private String province;

    private String comunity;

    private int yearFoundation;

    private int yearInCompetition;

    private List<Remero> remeros;
    public static ClubDto fromEntity(Club club) {
        return ClubDto.builder()
                .idClub(club.getIdClub())
                .name(club.getName())
                .city(club.getCity())
                .province(club.getProvince())
                .comunity(club.getComunity())
                .yearFoundation(club.getYearFoundation())
                .yearInCompetition(club.getYearInCompetition())
                .remeros(club.getRemeros())
                .build();
    }
}
