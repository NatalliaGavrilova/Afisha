package com.gmail.natalliagavrilova.event.mapper;

import com.gmail.natalliagavrilova.event.dao.entity.Concert;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertCreate;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertRead;
import com.gmail.natalliagavrilova.event.page.PageRead;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConcertMapper {
    public static Concert mapCreate(ConcertCreate concertCreate) {

        Concert concert = new Concert();

        concert.setUuid(UUID.randomUUID());
        concert.setDtCreate(LocalDateTime.now());
        concert.setDtUpdate(LocalDateTime.now());
        concert.setTitle(concertCreate.getTitle());
        concert.setDtEvent(concertCreate.getDtEvent());
        concert.setStatus(concertCreate.getStatus());
        concert.setType(concertCreate.getType());
        concert.setDescription(concertCreate.getDescription());
        concert.setCategory(concertCreate.getCategory());
        concert.setDtEndOfSale(concertCreate.getDtEndOfSale());

        return concert;
    }

    public static ConcertRead mapRead(Concert concert) {
        return ConcertRead.ConcertBuilder.create().setDtCreate(concert.getDtCreate())
                .setDtUpdate(concert.getDtUpdate()).setTitle(concert.getTitle())
                .setDescription(concert.getDescription()).setStatus(concert.getStatus())
                .setType(concert.getType()).setDtEvent(concert.getDtEvent())
                .setDtEndOfSale(concert.getDtEndOfSale()).setCategory(concert.getCategory())
                .setUuid(concert.getUuid()).build();
    }

    public static PageRead<ConcertRead> mapPage(Page<Concert> page) {
        PageRead<ConcertRead> pageDto = new PageRead<>();
        List<ConcertRead> contentDto = new ArrayList<>();

        for (Concert concert: page.getContent()) {
            contentDto.add(mapRead(concert));
        }

        pageDto.setNumber(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setSize(page.getTotalPages());
        pageDto.setFirst(page.isFirst());
        pageDto.setNumberOfElements(page.getNumberOfElements());
        pageDto.setLast(page.isLast());
        pageDto.setContent(contentDto);

        return pageDto;
    }

}