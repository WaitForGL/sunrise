package com.sunrise.service;

import com.sunrise.domain.classroom.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    List<ClassRoom> selectList(ClassRoom classRoom);

    void addClassRoom(ClassRoom classRoom);

    void updateById(ClassRoom classRoom);

    ClassRoom detail(ClassRoom classRoom);
}
