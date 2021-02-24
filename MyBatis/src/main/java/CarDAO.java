package main.java;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class CarDAO {
	public void save(Car car) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("main.resources.CarMapper.insertCar", car);
		session.commit();
		session.close();
	}
	
	public void update(Car car) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("main.resources.CarMapper.updateCar", car);
		session.commit();
		session.close();
	}
	
	public void delete(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("main.resources.CarMapper.deleteCar", id);
		session.commit();
		session.close();
	}
	
	public Car getCar(int id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Car car = session.selectOne("main.resources.CarMapper.selectCar", id);
		session.close();
		return car;
	}
	
	public List<Car> getAllCar() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Car> cars = session.selectList("main.resources.CarMapper.findAllCar");
		session.close();
		return cars;
	}
	
}
