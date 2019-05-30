package com.internousdev.orion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.orion.dto.DestinationInfoDTO;
import com.internousdev.orion.util.DBConnector;

public class DestinationInfoDAO {

//    宛先情報を登録する
	public int insert(String userId,String familyName,String firstName,String familyNameKana,
			String firstNameKana,String email,String telNumber,String userAddress){

		int destination=0;

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="INSERT INTO destination_info(user_id,family_name,first_name,family_name_kana,"
        + "first_name_kana,email,tel_number,user_address,regist_date,update_date)"
		+ "VALUES(?,?,?,?,?,?,?,?,now(),now())";

//		テーブルにセット
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,familyName);
			ps.setString(3,firstName);
			ps.setString(4,familyNameKana);
			ps.setString(5,firstNameKana);
			ps.setString(6,email);
			ps.setString(7,telNumber);
			ps.setString(8,userAddress);

			destination=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
			    con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return destination;
	}

	//ユーザーIDと紐付いている宛先情報のリストを取得する(登録日昇順)
	public List<DestinationInfoDTO> getDestinationInfoList(String loginUserId) {

		List<DestinationInfoDTO> destinationInfoList = new ArrayList<DestinationInfoDTO>();

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "SELECT * FROM destination_info WHERE user_id = ? ORDER BY regist_date";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
				destinationInfoDTO.setId(resultSet.getInt("id"));
				destinationInfoDTO.setFamilyName(resultSet.getString("family_name"));
				destinationInfoDTO.setFirstName(resultSet.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				destinationInfoDTO.setEmail(resultSet.getString("email"));
				destinationInfoDTO.setTelNumber(resultSet.getString("tel_number"));
				destinationInfoDTO.setUserAddress(resultSet.getString("user_address"));

				destinationInfoList.add(destinationInfoDTO);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return destinationInfoList;
	}

	//宛先IDと一致する宛先情報を削除する
	public int deleteDestinationInfo(int destinationInfoId) {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "DELETE FROM destination_info WHERE id = ?";

		int result = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, destinationInfoId);

			result = preparedStatement.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
