package com.sunrise.mapper;

import com.sunrise.domain.classroom.ClassRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassRoomMapper {
    List<ClassRoom> selectList(ClassRoom classRoom);

    void addClassRoom(ClassRoom classRoom);

    void updateById(ClassRoom classRoom);

    ClassRoom selectById(String roomName);

    ClassRoom detail(ClassRoom classRoom);
}
