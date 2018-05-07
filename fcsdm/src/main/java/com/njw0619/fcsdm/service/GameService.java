package com.njw0619.fcsdm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njw0619.fcsdm.mapper.GameMapper;
import com.njw0619.fcsdm.model.Attendance;
import com.njw0619.fcsdm.model.Carpool;
import com.njw0619.fcsdm.model.Game;
import com.njw0619.fcsdm.model.Record;
import com.njw0619.fcsdm.model.Score;

@Service
public class GameService {
	
	@Autowired
	GameMapper gameMapper;

	public int addGame(Game game){
		return gameMapper.insertGame(game);
	}
	
	public int addAttendance(Attendance attendance){
		return gameMapper.insertAttendance(attendance);
	}
	
	public int addCarpool(Carpool carpool){
		return gameMapper.insertCarpool(carpool);
	}
	
	public int addRecord(Record record){
		return gameMapper.insertRecord(record);
	}
	
	public int addScore(Score score){
		return gameMapper.insertScore(score);
	}
	
	public int getLatestSeq() {
		return gameMapper.selectLatestSeq();
	}
	
	public List<Score> getScore(){
		return gameMapper.selectScore();
	}
	
	public List<Map<String, String>> getAttendRanking(){
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		List<Map<String, String>> records = gameMapper.selectAttendRanking();
		int totalCount = 0;
		int rank = 1;
		int previous = 0;
		for(Map<String, String> record : records) {
			totalCount++;
			int attendCount = MapUtils.getIntValue(record, "COUNT");
			if(totalCount == 1) previous = attendCount;
			if(attendCount == previous) {
				record.put("rank", String.valueOf(rank));
			}
			else {
				rank = totalCount;
				record.put("rank", String.valueOf(rank));
			}
			previous = attendCount;
			result.add(record);
			if(totalCount >= 10) break;
		}
		
		return result;
	}
	
	public List<Map<String, String>> getGoalRanking(){
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		List<Map<String, String>> records = gameMapper.selectGoalRanking();
		int totalCount = 0;
		int rank = 1;
		int previous = 0;
		for(Map<String, String> record : records) {
			totalCount++;
			int goal = MapUtils.getIntValue(record, "GOAL");
			if(totalCount == 1) previous = goal;
			if(goal == previous) {
				record.put("rank", String.valueOf(rank));
			}
			else {
				rank = totalCount;
				record.put("rank", String.valueOf(rank));
			}
			previous = goal;
			result.add(record);
			if(totalCount >= 10) break;
		}
		
		return result;
	}
	
	public List<Map<String, String>> getMVPRanking(){
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		List<Map<String, String>> records = gameMapper.selectMVPRanking();
		int totalCount = 0;
		int rank = 1;
		int previous = 0;
		for(Map<String, String> record : records) {
			totalCount++;
			int mvpCount = MapUtils.getIntValue(record, "COUNT");
			if(totalCount == 1) previous = mvpCount;
			if(mvpCount == previous) {
				record.put("rank", String.valueOf(rank));
			}
			else {
				rank = totalCount;
				record.put("rank", String.valueOf(rank));
			}
			previous = mvpCount;
			result.add(record);
			if(totalCount >= 10) break;
		}
		
		return result;
	}
	
}
