package com.njw0619.fcsdm.mapper;

import com.njw0619.fcsdm.model.Attendance;
import com.njw0619.fcsdm.model.Carpool;
import com.njw0619.fcsdm.model.Game;
import com.njw0619.fcsdm.model.Record;
import com.njw0619.fcsdm.model.Score;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * Created by Peter on 2018-02-06.
 */
@Repository
public interface GameMapper {    
    public int insertGame(Game game);
    public int insertAttendance(Attendance attendance);
    public int insertCarpool(Carpool carpool);
    public int insertRecord(Record record);
    public int insertScore(Score score);
    
    public int selectLatestSeq();
    public List<Score> selectScore();
    public List<Map<String, String>> selectAttendRanking();
    public List<Map<String, String>> selectGoalRanking();
    public List<Map<String, String>> selectMVPRanking();
    
}
