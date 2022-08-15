package com.meihua.service.impl;

import com.meihua.dto.MusicCreateRequest;
import com.meihua.dto.MusicDto;
import com.meihua.dto.MusicUpdateRequest;
import com.meihua.entity.Music;
import com.meihua.enums.MusicStatus;
import com.meihua.exception.BizException;
import com.meihua.exception.ExceptionType;
import com.meihua.mapper.MusicMapper;
import com.meihua.repository.MusicRepository;
import com.meihua.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private MusicMapper musicMapper;

    @Override
    public MusicDto create(MusicCreateRequest musicCreateRequest) {
        Music music = musicMapper.createEntity(musicCreateRequest);
        music.setStatus(MusicStatus.DRAFT);
        return musicMapper.toDto(musicRepository.save(music));
    }

    @Override
    public MusicDto update(String id, MusicUpdateRequest musicUpdateRequest) {
        Music musicExist = getMusic(id);
        Music music = musicMapper.updateEntity(musicExist,musicUpdateRequest);
        return musicMapper.toDto(musicRepository.save(music));
    }


    @Override
    public List<MusicDto> list() {
        return musicRepository.findAll().stream().map(musicMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void publish(String id) {
        Music music = getMusic(id);
        music.setStatus(MusicStatus.PUBLISHED);
        musicRepository.save(music);
    }

    @Override
    public void closed(String id) {
        Music music = getMusic(id);
        music.setStatus(MusicStatus.CLOSED);
        musicRepository.save(music);
    }

    /**
     * 获取当前歌曲是否存在
     * @param id
     * @return
     */
    private Music getMusic(String id) {
        Optional<Music> musicOptional = musicRepository.findById(id);
        if (!musicOptional.isPresent()){
            throw new BizException(ExceptionType.MUSIC_NOT_FOUND);
        }
        return musicOptional.get();
    }
}
