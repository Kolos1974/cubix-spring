package hu.cubix.hr.kolos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.cubix.hr.kolos.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {

	public List<Position> findByName(String name);
}