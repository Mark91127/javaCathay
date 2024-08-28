package com.midterm.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.service.MidtermService;

@Service
public class MidtermServiceImpl implements MidtermService {

	@Autowired
	private DataSource dataSource;
	private static String selectString = "select * from student.EX_WORDLE";

	/**
	 * 範例程式
	 * 
	 * @param demoMap
	 * @return
	 */
	@Override
	public Map<String, Object> demoCode(Map<String, String> demoMap) {
		/* 1. 將前端傳入值取出：使用前端傳入物件的key值，從Map中取得對應value，例如： */
//        String id = demoMap.get("id");
//        String keyword = demoMap.get("keyword");
//        System.err.println("id--->" + id);
//        System.err.println("keyword--->" + keyword);
//
//        /* 2. 業務邏輯：檢核、題目要求邏輯實作，如需使用DB連線，請參考下列程式碼
//        try (Connection conn = dataSource.getConnection(); 
//                PreparedStatement pstmt = conn.prepareStatement(DEMOCODE_QUERY_SQL_STRING);) {
//        
//        
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//         */
//
//        /* 3. 把要回傳給前端的值包裝成Map後return，例如： */
//        Map<String, Object> rtnMap = new HashMap<>();
//        rtnMap.put("success", true);
//        rtnMap.put("returnMessage", "驗證成功");
//        rtnMap.put("metro_fee", 100);
//        rtnMap.put("pokerA", new ArrayList<>());
//        return rtnMap;
		return null;
	}

	/**
	 * 第一題：發撲克牌
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> deal(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 第二題：證件號碼驗證
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> checkId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;

	}

	/**
	 * 第二題：證件號碼驗證_加分題
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getRandomId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;

	}

	/**
	 * 第三題：Wordle
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> wordle(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 第四題：對對碰
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> matchingGame(Map<String, String> map) {
		// TODO Auto-generated method stub
		/* 1. 將前端傳入值取出：使用前端傳入物件的key值，從Map中取得對應value，例如： */
		int matrixSize = Integer.parseInt(map.get("matrixSize"));

		// 2. 業務邏輯：檢核、題目要求邏輯實作，如需使用DB連線，請參考下列程式碼
		List<String> randomStringList = new ArrayList<String>();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectString);) {

			List<String> wordle = new ArrayList<String>();
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					wordle.add(rs.getString(1)); // size:31
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			Random random = new Random(); // random.nextInt(31) 0-30
			Set<String> uniqueStringSet = new HashSet<>();
			while (uniqueStringSet.size() < matrixSize * matrixSize / 2) {
				String randomString = wordle.get(random.nextInt(wordle.size()));
				uniqueStringSet.add(randomString);
			}

			// 擴展單字列表
			randomStringList.addAll(uniqueStringSet);
			randomStringList.addAll(uniqueStringSet);

			// 隨機排序單字列表
			Collections.shuffle(randomStringList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		/* 3. 把要回傳給前端的值包裝成Map後return，例如： */
		Map<String, Object> rtnMap = new HashMap<>();
		for (int i = 0; i < randomStringList.size(); i++) {
			rtnMap.put(Integer.toString(i), randomStringList.get(i));
		}
		return rtnMap;
	}

	/**
	 * 第五題：捷運車資計算
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> metro(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
