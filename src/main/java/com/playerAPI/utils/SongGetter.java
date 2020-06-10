package com.playerAPI.utils;

import org.springframework.core.io.InputStreamResource;

public interface SongGetter {
    InputStreamResource getSong(String id);
}
