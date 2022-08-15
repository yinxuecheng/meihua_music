package com.meihua.controller;

import com.meihua.dto.MusicCreateRequest;
import com.meihua.dto.MusicUpdateRequest;
import com.meihua.mapper.MusicMapper;
import com.meihua.service.MusicService;
import com.meihua.vo.MusicVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/music")
@Api(tags = "歌曲管理")
public class MusicController {
    @Autowired
    private MusicService musicService;
    @Autowired
    private MusicMapper musicMapper;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation("创建歌曲")
    public MusicVo create(@Validated  @RequestBody MusicCreateRequest musicCreateRequest) {
        return musicMapper.toVo(musicService.create(musicCreateRequest));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation("编辑歌曲")
    public MusicVo update(@Validated @PathVariable String id,
                          @RequestBody MusicUpdateRequest musicUpdateRequest){
        return musicMapper.toVo(musicService.update(id,musicUpdateRequest));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation("歌曲列表")
    public List<MusicVo> list() {
        return musicService.list()
                .stream()
                .map(musicMapper::toVo)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}/publish")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation("歌曲上架")
    public void publish(@PathVariable String id) {
        musicService.publish(id);
    }

    @PostMapping("/{id}/closed")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation("歌曲下架")
    public void closed(@PathVariable String id) {
        musicService.closed(id);
    }
}
