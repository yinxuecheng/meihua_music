package com.meihua.service;

import com.meihua.dto.MusicCreateRequest;
import com.meihua.dto.MusicDto;
import com.meihua.dto.MusicUpdateRequest;

import java.util.List;

public interface MusicService {

    MusicDto create(MusicCreateRequest musicCreateRequest);

    MusicDto update(String id, MusicUpdateRequest musicUpdateRequest);

    List<MusicDto> list();

    void publish(String id);

    void closed(String id);
}
